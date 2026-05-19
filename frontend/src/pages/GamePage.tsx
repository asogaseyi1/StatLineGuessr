import { useCallback, useEffect, useState } from 'react';
import { fetchRandomStatline, submitGuess } from '../api/client';
import GuessInput from '../components/GuessInput';
import StatlineCard from '../components/StatlineCard';
import type { GuessResult, LocalStats, StatlineGameView } from '../types';

const MAX_GUESSES = 5;

function loadStats(): LocalStats {
  try {
    const raw = localStorage.getItem('slg-stats');
    if (raw) return JSON.parse(raw) as LocalStats;
  } catch { /* ignore */ }
  return { totalGames: 0, totalCorrect: 0, currentStreak: 0, bestStreak: 0 };
}

function saveStats(s: LocalStats) {
  localStorage.setItem('slg-stats', JSON.stringify(s));
}

interface GuessEntry {
  name: string;
  correct: boolean;
}

export default function GamePage() {
  const [statline, setStatline] = useState<StatlineGameView | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  const [guesses, setGuesses] = useState<GuessEntry[]>([]);
  const [lastResult, setLastResult] = useState<GuessResult | null>(null);
  const [gameOver, setGameOver] = useState(false);
  const [stats, setStats] = useState<LocalStats>(loadStats);

  const loadNewGame = useCallback(async () => {
    setLoading(true);
    setError(null);
    setGuesses([]);
    setLastResult(null);
    setGameOver(false);
    try {
      const s = await fetchRandomStatline();
      if (!s) setError('No stat lines available. Make sure the backend is running and seeded.');
      else setStatline(s);
    } catch {
      setError('Could not connect to the server. Please try again later.');
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => { loadNewGame(); }, [loadNewGame]);

  const handleGuess = async (playerName: string) => {
    if (!statline || gameOver) return;
    try {
      const result = await submitGuess(statline.id, playerName);
      const newGuesses = [...guesses, { name: playerName, correct: result.correct }];
      setGuesses(newGuesses);
      setLastResult(result);

      if (result.correct) {
        setGameOver(true);
        const updated: LocalStats = {
          totalGames: stats.totalGames + 1,
          totalCorrect: stats.totalCorrect + 1,
          currentStreak: stats.currentStreak + 1,
          bestStreak: Math.max(stats.bestStreak, stats.currentStreak + 1),
        };
        setStats(updated);
        saveStats(updated);
      } else if (newGuesses.length >= MAX_GUESSES) {
        setGameOver(true);
        const updated: LocalStats = {
          ...stats,
          totalGames: stats.totalGames + 1,
          currentStreak: 0,
        };
        setStats(updated);
        saveStats(updated);
      }
    } catch {
      setError('Failed to submit guess. Please try again.');
    }
  };

  const isCorrect = guesses.some(g => g.correct);
  const wrongCount = guesses.filter(g => !g.correct).length;
  const attemptsLeft = MAX_GUESSES - guesses.length;
  const accuracy = stats.totalGames > 0
    ? Math.round((stats.totalCorrect / stats.totalGames) * 100)
    : 0;

  const hints: { label: string; value: string }[] = [];
  if (lastResult && wrongCount >= 1) hints.push({ label: 'Position', value: lastResult.position });
  if (lastResult && wrongCount >= 2) hints.push({ label: 'Team', value: lastResult.team });
  if (lastResult && wrongCount >= 3) hints.push({ label: 'First Letter', value: lastResult.actualPlayerName.charAt(0).toUpperCase() });

  return (
    <div className="game-page">
      <header className="header">
        <div className="header-inner">
          <h1 className="logo">🏀 StatLineGuessr</h1>
          <div className="streak-display">🔥 {stats.currentStreak}</div>
        </div>
      </header>

      <main className="game-container">
        <p className="subtitle">Identify the player from this stat line.</p>

        {loading && <div className="loading">Loading stat line…</div>}
        {error && <div className="error-msg">{error}</div>}

        {!loading && statline && (
          <>
            <StatlineCard statline={statline} />

            {hints.length > 0 && (
              <div className="hints">
                {hints.map(h => (
                  <div key={h.label} className="hint-item">
                    <span className="hint-label">💡 {h.label}:</span>
                    <span className="hint-value">{h.value}</span>
                  </div>
                ))}
              </div>
            )}

            {guesses.length > 0 && (
              <div className="guess-history">
                {guesses.map((g, i) => (
                  <div key={i} className={`guess-entry ${g.correct ? 'correct' : 'wrong'}`}>
                    <span className="guess-icon">{g.correct ? '✓' : '✗'}</span>
                    <span className="guess-name">{g.name}</span>
                    {!g.correct && <span className="guess-feedback">Not quite</span>}
                  </div>
                ))}
              </div>
            )}

            {!gameOver && (
              <>
                <GuessInput onSubmit={handleGuess} disabled={gameOver} />
                {guesses.length > 0 && (
                  <p className="attempts-left">
                    {attemptsLeft} attempt{attemptsLeft !== 1 ? 's' : ''} left
                  </p>
                )}
              </>
            )}

            {gameOver && (
              <div className={`result-banner ${isCorrect ? 'result-correct' : 'result-wrong'}`}>
                <div className="result-icon">{isCorrect ? '🎉' : '😅'}</div>
                <div className="result-title">{isCorrect ? 'Correct!' : 'Game Over'}</div>
                <div className="result-player">{lastResult?.actualPlayerName}</div>
                <div className="result-details">
                  {lastResult?.team} · {lastResult?.position} · {lastResult?.sport}
                </div>
                <button className="next-btn" onClick={loadNewGame}>Next Round →</button>
              </div>
            )}
          </>
        )}

        <div className="stats-panel">
          {[
            { value: stats.totalGames, label: 'Played' },
            { value: `${accuracy}%`, label: 'Accuracy' },
            { value: stats.currentStreak, label: 'Streak' },
            { value: stats.bestStreak, label: 'Best' },
          ].map(b => (
            <div key={b.label} className="stat-block">
              <div className="stat-block-value">{b.value}</div>
              <div className="stat-block-label">{b.label}</div>
            </div>
          ))}
        </div>
      </main>
    </div>
  );
}
