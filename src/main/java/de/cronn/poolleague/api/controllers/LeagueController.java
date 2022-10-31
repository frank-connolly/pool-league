package de.cronn.poolleague.api.controllers;

import de.cronn.poolleague.model.League;
import de.cronn.poolleague.repositories.LeagueRepository;
import de.cronn.poolleague.repositories.PlayerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/leagues")
public class LeagueController {

    private LeagueRepository leagueRepository;

    public LeagueController(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @GetMapping
    public ResponseEntity<List<League>> getLeagues() {
        List<League> leagues = leagueRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(leagues);
    }

    @GetMapping("/{leagueId}")
    public ResponseEntity<Optional<League>> getLeagueById(@PathVariable Long leagueId) {
        if (leagueRepository.existsById(leagueId)) {
            return ResponseEntity.status(HttpStatus.OK).body(leagueRepository.findById(leagueId));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
