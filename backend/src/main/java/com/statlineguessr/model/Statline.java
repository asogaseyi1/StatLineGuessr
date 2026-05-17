package com.statlineguessr.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "statline", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"player_id", "game_date"})
})
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

    public Statline() {}

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

    public Long getId() { return id; }
    public Player getPlayer() { return player; }
    public LocalDate getGameDate() { return gameDate; }
    public Integer getPoints() { return points; }
    public Integer getAssists() { return assists; }
    public Integer getRebounds() { return rebounds; }
    public Integer getSteals() { return steals; }
    public Integer getBlocks() { return blocks; }
    public BigDecimal getMinutesPlayed() { return minutesPlayed; }

    public void setId(Long id) { this.id = id; }
    public void setPlayer(Player player) { this.player = player; }
    public void setGameDate(LocalDate gameDate) { this.gameDate = gameDate; }
    public void setPoints(Integer points) { this.points = points; }
    public void setAssists(Integer assists) { this.assists = assists; }
    public void setRebounds(Integer rebounds) { this.rebounds = rebounds; }
    public void setSteals(Integer steals) { this.steals = steals; }
    public void setBlocks(Integer blocks) { this.blocks = blocks; }
    public void setMinutesPlayed(BigDecimal minutesPlayed) { this.minutesPlayed = minutesPlayed; }
}
