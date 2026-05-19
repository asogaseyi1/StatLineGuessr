import type { GuessResult, Player, StatlineGameView } from '../types';

const BASE = (import.meta.env.VITE_API_URL ?? 'http://localhost:8080') + '/api';

export async function fetchRandomStatline(): Promise<StatlineGameView | null> {
  const res = await fetch(`${BASE}/game/random`);
  if (res.status === 204) return null;
  if (!res.ok) throw new Error('Failed to fetch stat line');
  return res.json();
}

export async function submitGuess(
  statlineId: number,
  guessedPlayerName: string,
): Promise<GuessResult> {
  const res = await fetch(`${BASE}/guess`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ statlineId, guessedPlayerName }),
  });
  if (!res.ok) throw new Error('Failed to submit guess');
  return res.json();
}

export async function searchPlayers(q: string): Promise<Player[]> {
  if (q.length < 2) return [];
  const res = await fetch(`${BASE}/players/search?q=${encodeURIComponent(q)}`);
  if (!res.ok) return [];
  return res.json();
}
