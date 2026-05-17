package com.statlineguessr.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "guess")
@Data
@NoArgsConstructor
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

    @PrePersist
    protected void onCreate() {
        guessedAt = LocalDateTime.now();
    }

    public Guess(Statline statline, String guessedPlayerName, boolean correct, int hintsUsed) {
        this.statline = statline;
        this.guessedPlayerName = guessedPlayerName;
        this.correct = correct;
        this.hintsUsed = hintsUsed;
    }
}
