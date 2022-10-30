package de.cronn.poolleague.repositories;

import de.cronn.poolleague.model.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository extends JpaRepository<League, Long> {
}