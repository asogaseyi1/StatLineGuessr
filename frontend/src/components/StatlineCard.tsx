import type { StatlineGameView } from '../types';

interface Props {
  statline: StatlineGameView;
}

const SPORT_EMOJI: Record<string, string> = { NBA: '🏀', NFL: '🏈' };

function formatDate(iso: string): string {
  return new Date(iso).toLocaleDateString('en-US', {
    year: 'numeric', month: 'long', day: 'numeric', timeZone: 'UTC',
  });
}

export default function StatlineCard({ statline }: Props) {
  const emoji = SPORT_EMOJI[statline.sport] ?? '🏅';
  const stats = [
    { label: 'PTS', value: statline.points },
    { label: 'REB', value: statline.rebounds },
    { label: 'AST', value: statline.assists },
    { label: 'STL', value: statline.steals },
    { label: 'BLK', value: statline.blocks },
    { label: 'MIN', value: statline.minutesPlayed },
  ];

  return (
    <div className="statline-card">
      <div className="statline-meta">
        <span className="sport-badge">{emoji} {statline.sport}</span>
        <span className="game-date">{formatDate(statline.gameDate)}</span>
      </div>
      <div className="stat-grid">
        {stats.map(s => (
          <div key={s.label} className="stat-item">
            <div className="stat-label">{s.label}</div>
            <div className="stat-value">{s.value}</div>
          </div>
        ))}
      </div>
      <p className="player-mystery">Who scored this? 🤔</p>
    </div>
  );
}
