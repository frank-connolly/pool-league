package de.cronn.poolleague.model;

import javax.persistence.*;

@Entity
@Table(name = "league_standings")
public class LeagueStanding {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long leagueId;
    private int numGamesPlayed;
    private int numOfWins;
    private int numOfLosses;
    private int numOfNoContests; // Abandoned games or whatever
    private int points;

    public LeagueStanding() {
    }

    public LeagueStanding(Long leagueId, int numGamesPlayed, int numOfWins, int numOfLosses, int numOfNoContests, int points) {
        this.leagueId = leagueId;
        this.numGamesPlayed = numGamesPlayed;
        this.numOfWins = numOfWins;
        this.numOfLosses = numOfLosses;
        this.numOfNoContests = numOfNoContests;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public int getNumGamesPlayed() {
        return numGamesPlayed;
    }

    public void setNumGamesPlayed(int numGamesPlayed) {
        this.numGamesPlayed = numGamesPlayed;
    }

    public int getNumOfWins() {
        return numOfWins;
    }

    public void setNumOfWins(int numOfWins) {
        this.numOfWins = numOfWins;
    }

    public int getNumOfLosses() {
        return numOfLosses;
    }

    public void setNumOfLosses(int numOfLosses) {
        this.numOfLosses = numOfLosses;
    }

    public int getNumOfNoContests() {
        return numOfNoContests;
    }

    public void setNumOfNoContests(int numOfNoContests) {
        this.numOfNoContests = numOfNoContests;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
