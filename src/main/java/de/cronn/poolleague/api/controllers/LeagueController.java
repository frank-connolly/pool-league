package de.cronn.poolleague.api.controllers;

import de.cronn.poolleague.model.League;
import de.cronn.poolleague.repositories.LeagueRepository;
import de.cronn.poolleague.repositories.PlayerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/leagues")
public class LeagueController {

    private LeagueRepository leagueRepository;

    public LeagueController(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @GetMapping
    public List<League> getLeagues() {
        return leagueRepository.findAll();
    }

    @GetMapping("/{leagueId}")
    public League getLeagueById(@PathVariable Long leagueId) {
        return leagueRepository.findById(leagueId)
                .orElseThrow(() -> new NoSuchElementException("League with id " + leagueId + " not found."));
    }
}
