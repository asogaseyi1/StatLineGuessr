package com.statlineguessr.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "statline", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"player_id", "game_date"})
})
@Data
@NoArgsConstructor
public class Statline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(name = "game_date", nullable = false)
    private LocalDate gameDate;

    private Integer points;
    private Integer assists;
    private Integer rebounds;
    private Integer steals;
    private Integer blocks;

    @Column(name = "minutes_played", precision = 4, scale = 1)
    private BigDecimal minutesPlayed;

    public Statline(Player player, LocalDate gameDate, Integer points, Integer assists,
                    Integer rebounds, Integer steals, Integer blocks, BigDecimal minutesPlayed) {
        this.player = player;
        this.gameDate = gameDate;
        this.points = points;
        this.assists = assists;
        this.rebounds = rebounds;
        this.steals = steals;
        this.blocks = blocks;
        this.minutesPlayed = minutesPlayed;
    }
}
