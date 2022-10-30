package de.cronn.poolleague.repositories;

import de.cronn.poolleague.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}