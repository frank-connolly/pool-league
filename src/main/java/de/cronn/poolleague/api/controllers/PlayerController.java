package de.cronn.poolleague.api.controllers;

import de.cronn.poolleague.api.requests.AddPlayerRequest;
import de.cronn.poolleague.api.requests.JoinLeagueRequest;
import de.cronn.poolleague.model.League;
import de.cronn.poolleague.model.Player;
import de.cronn.poolleague.repositories.LeagueRepository;
import de.cronn.poolleague.repositories.PlayerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {

    // TODO Either fill in bad responses with specific error info on why it's wrong OR
    // refactor bad responses to throw exceptions instead and catch in a separate error handling class

    private PlayerRepository playerRepository;
    private LeagueRepository leagueRepository;

    public PlayerController(PlayerRepository playerRepository, LeagueRepository leagueRepository) {
        this.playerRepository = playerRepository;
        this.leagueRepository = leagueRepository;
    }

    @GetMapping
    public ResponseEntity<List<Player>> getPlayers() {
        List<Player> players = playerRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(players);
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<Optional<Player>> getPlayerById(@PathVariable final Long playerId) {
        if (playerRepository.existsById(playerId)) {
            return ResponseEntity.status(HttpStatus.OK).body(playerRepository.findById(playerId));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody AddPlayerRequest playerRequest) {
        Player player = new Player();
        player.setFirstName(playerRequest.getFirstName());
        player.setLastName(playerRequest.getLastName());
        playerRepository.save(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(player);
    }

    @PutMapping("/{playerId}")
    public ResponseEntity<Player> addPlayerToLeague(@PathVariable Long playerId,
                                                              @RequestBody JoinLeagueRequest request) {
        if (!playerRepository.existsById(playerId) || !leagueRepository.existsById(request.getLeagueId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Optional<Player> player = playerRepository.findById(playerId);
        if (isValidLeagueCode(request.getLeagueId(), request.getLeagueCode())) {
            player.get().setLeagueId(request.getLeagueId());
            return ResponseEntity.status(HttpStatus.OK).body(playerRepository.save(player.get()));
        }
        System.out.println("League code incorrect");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    public boolean isValidLeagueCode(Long leagueId, String code) {
        League league = leagueRepository.findById(leagueId).orElseThrow(NoSuchElementException::new);
        return league.getCode().equals(code);
    }

    // TODO Add security to delete endpoint
    @DeleteMapping("/{playerId}")
    public ResponseEntity deletePlayer(@PathVariable Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new NoSuchElementException("No player with id " + playerId + " found."));
        playerRepository.delete(player);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
