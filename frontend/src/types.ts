export interface StatlineGameView {
  id: number;
  sport: string;
  gameDate: string; // ISO date: "2024-01-15"
  points: number;
  assists: number;
  rebounds: number;
  steals: number;
  blocks: number;
  minutesPlayed: number;
}

export interface GuessResult {
  correct: boolean;
  actualPlayerName: string;
  team: string;
  position: string;
  sport: string;
  message: string;
}

export interface Player {
  id: number;
  name: string;
  sport: string;
  team: string;
  position: string;
}

export interface LocalStats {
  totalGames: number;
  totalCorrect: number;
  currentStreak: number;
  bestStreak: number;
}
