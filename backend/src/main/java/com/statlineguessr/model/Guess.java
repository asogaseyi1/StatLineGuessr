package com.statlineguessr.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "guess")
public class Guess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "statline_id")
    private Statline statline;

    @Column(name = "guessed_player_name")
    private String guessedPlayerName;

    @Column(name = "is_correct")
    private boolean correct;

    @Column(name = "hints_used")
    private int hintsUsed;

    @Column(name = "guessed_at")
    private LocalDateTime guessedAt;

    public Guess() {}

    public Guess(Statline statline, String guessedPlayerName, boolean correct, int hintsUsed) {
        this.statline = statline;
        this.guessedPlayerName = guessedPlayerName;
        this.correct = correct;
        this.hintsUsed = hintsUsed;
    }

    @PrePersist
    protected void onCreate() {
        guessedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Statline getStatline() { return statline; }
    public String getGuessedPlayerName() { return guessedPlayerName; }
    public boolean isCorrect() { return correct; }
    public int getHintsUsed() { return hintsUsed; }
    public LocalDateTime getGuessedAt() { return guessedAt; }

    public void setId(Long id) { this.id = id; }
    public void setStatline(Statline statline) { this.statline = statline; }
    public void setGuessedPlayerName(String guessedPlayerName) { this.guessedPlayerName = guessedPlayerName; }
    public void setCorrect(boolean correct) { this.correct = correct; }
    public void setHintsUsed(int hintsUsed) { this.hintsUsed = hintsUsed; }
    public void setGuessedAt(LocalDateTime guessedAt) { this.guessedAt = guessedAt; }
}
