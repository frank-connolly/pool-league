package de.cronn.poolleague.repositories;

import de.cronn.poolleague.model.LeagueStanding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StandingRepository extends JpaRepository<LeagueStanding, Long> {
}
