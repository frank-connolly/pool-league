package de.cronn.poolleague.api.requests;

public class JoinLeagueRequest {

    private Long leagueId;
    private String leagueCode;

    public JoinLeagueRequest() {}

    public JoinLeagueRequest(Long leagueId, String leagueCode) {
        this.leagueId = leagueId;
        this.leagueCode = leagueCode;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueCode() {
        return leagueCode;
    }

    public void setLeagueCode(String leagueCode) {
        this.leagueCode = leagueCode;
    }
}
