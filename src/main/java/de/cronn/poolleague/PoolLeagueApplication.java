package de.cronn.poolleague;

import de.cronn.poolleague.model.League;
import de.cronn.poolleague.model.Player;
import de.cronn.poolleague.repositories.LeagueRepository;
import de.cronn.poolleague.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PoolLeagueApplication implements CommandLineRunner {

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private PlayerRepository playerRepository;


    public static void main(String[] args) {
        SpringApplication.run(PoolLeagueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        League league1 = new League();
        league1.setCode("slainte");

        Player player1 = new Player();
        player1.setLeagueId(league1.getId());
        player1.setFirstName("Henrik");
        player1.setLastName("Larsson");

        Player player2 = new Player();
        player2.setLeagueId(league1.getId());
        player2.setFirstName("Alex");
        player2.setLastName("Murphy");

        Player player3 = new Player();
        player3.setLeagueId(league1.getId());
        player3.setFirstName("Richard");
        player3.setLastName("Jones");

        leagueRepository.save(league1);
        playerRepository.save(player1);
        playerRepository.save(player2);
        playerRepository.save(player3);
    }
}
