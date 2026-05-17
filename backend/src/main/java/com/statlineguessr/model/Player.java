package com.statlineguessr.model;

import jakarta.persistence.*;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String sport;

    @Column(length = 50)
    private String team;

    @Column(length = 50)
    private String position;

    public Player() {}

    public Player(String name, String sport, String team, String position) {
        this.name = name;
        this.sport = sport;
        this.team = team;
        this.position = position;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSport() { return sport; }
    public String getTeam() { return team; }
    public String getPosition() { return position; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSport(String sport) { this.sport = sport; }
    public void setTeam(String team) { this.team = team; }
    public void setPosition(String position) { this.position = position; }
}
