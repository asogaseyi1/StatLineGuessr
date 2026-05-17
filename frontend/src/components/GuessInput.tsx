import { useEffect, useRef, useState } from 'react';
import { searchPlayers } from '../api/client';
import type { Player } from '../types';

interface Props {
  onSubmit: (name: string) => void;
  disabled: boolean;
}

export default function GuessInput({ onSubmit, disabled }: Props) {
  const [value, setValue] = useState('');
  const [suggestions, setSuggestions] = useState<Player[]>([]);
  const [showDrop, setShowDrop] = useState(false);
  const containerRef = useRef<HTMLDivElement>(null);
  const timerRef = useRef<ReturnType<typeof setTimeout> | null>(null);

  useEffect(() => {
    const handler = (e: MouseEvent) => {
      if (containerRef.current && !containerRef.current.contains(e.target as Node)) {
        setShowDrop(false);
      }
    };
    document.addEventListener('mousedown', handler);
    return () => document.removeEventListener('mousedown', handler);
  }, []);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const q = e.target.value;
    setValue(q);
    if (timerRef.current) clearTimeout(timerRef.current);
    if (q.length < 2) { setSuggestions([]); setShowDrop(false); return; }
    timerRef.current = setTimeout(async () => {
      const results = await searchPlayers(q);
      setSuggestions(results);
      setShowDrop(results.length > 0);
    }, 300);
  };

  const handleSelect = (name: string) => {
    setValue(name);
    setShowDrop(false);
  };

  const handleSubmit = () => {
    const trimmed = value.trim();
    if (!trimmed) return;
    onSubmit(trimmed);
    setValue('');
    setSuggestions([]);
    setShowDrop(false);
  };

  return (
    <div className="guess-input-wrapper" ref={containerRef}>
      <div className="guess-input-row">
        <input
          type="text"
          className="guess-input"
          placeholder="Search for a player..."
          value={value}
          onChange={handleChange}
          onKeyDown={e => e.key === 'Enter' && handleSubmit()}
          disabled={disabled}
          autoComplete="off"
        />
        <button
          className="guess-btn"
          onClick={handleSubmit}
          disabled={disabled || !value.trim()}
        >
          Guess
        </button>
      </div>
      {showDrop && (
        <ul className="suggestions-list">
          {suggestions.map(p => (
            <li
              key={p.id}
              className="suggestion-item"
              onMouseDown={() => handleSelect(p.name)}
            >
              <span className="suggestion-name">{p.name}</span>
              <span className="suggestion-meta">{p.team} · {p.position}</span>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}
