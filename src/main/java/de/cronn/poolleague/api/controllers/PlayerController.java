package de.cronn.poolleague.api.controllers;

import de.cronn.poolleague.api.requests.AddPlayerRequest;
import de.cronn.poolleague.api.requests.JoinLeagueRequest;
import de.cronn.poolleague.model.League;
import de.cronn.poolleague.model.Player;
import de.cronn.poolleague.repositories.LeagueRepository;
import de.cronn.poolleague.repositories.PlayerRepository;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private PlayerRepository playerRepository;
    private LeagueRepository leagueRepository;

    public PlayerController(PlayerRepository playerRepository, LeagueRepository leagueRepository) {
        this.playerRepository = playerRepository;
        this.leagueRepository = leagueRepository;
    }

    @GetMapping
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/{playerId}")
    public Player getPlayerById(@PathVariable Long playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new NoSuchElementException("No player with id " + playerId + " found."));
    }

    @PostMapping
    public Player addPlayer(@RequestBody AddPlayerRequest playerRequest) {
        Player player = new Player();
        player.setFirstName(playerRequest.getFirstName());
        player.setLastName(playerRequest.getLastName());
        return playerRepository.save(player);
    }

    @PutMapping("/{playerId}")
    public void addPlayerToLeague(@PathVariable Long playerId, @RequestBody JoinLeagueRequest joinLeagueRequest) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new NoSuchElementException("No player with id " + playerId + " found."));
        League league = leagueRepository.findById(joinLeagueRequest.getLeagueId())
                .orElseThrow(() -> new NoSuchElementException("Requested league not found"));

        if (joinLeagueRequest.getLeagueCode().equals(league.getCode())) {
            player.setLeagueId(joinLeagueRequest.getLeagueId());
            playerRepository.save(player);
        } else {
            System.out.println("League code incorrect");
        }
    }

    @DeleteMapping("/{playerId}")
    public void deletePlayer(@PathVariable Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new NoSuchElementException("No player with id " + playerId + " found."));
        playerRepository.delete(player);
    }
}
