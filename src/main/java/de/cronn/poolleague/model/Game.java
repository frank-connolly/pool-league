package de.cronn.poolleague.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long player1Id;
    private Long player2Id;
    private Long winnerId;
    private Date startTime;
    private Date endTime; // TODO if there is an endTime and no winnerId then it is a NC

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
