package de.cronn.poolleague.service;

public class GameService {

    private PlayerService playerService;

    public void recordResult(Long winnerId, Long loserId) {
        // TODO fetch both player objects
        // TODO increment Games Played
        // TODO 3 points to winner
    }

    public void recordNoContest(Long player1Id, Long player2Id) {
        // TODO fetch both player objects
        // TODO increment Games Played
        // TODO increment NC
    }
}
