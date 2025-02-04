package com.project;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.nba.player.Player;
import com.project.nba.player.PlayerRepository;

import java.util.Optional;

@DataJpaTest
public class TestPlayerRepository {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void testSavePlayer() {
        Player player = new Player("Kevin Durant", "OKC", 81, 3119, 731, 1433, 0.510, 334, 0.416, 679, 750, 0.905, 640, 374, 116, 105, 280, 143, 2280, 2462);
        playerRepository.save(player);

        Optional<Player> retrievedPlayer = playerRepository.findByName("Kevin Durant");
        assertTrue(retrievedPlayer.isPresent());
        assertEquals("OKC", retrievedPlayer.get().getTeam());
    }

    @Test
    void testFindPlayerByName() {
        Player player = new Player("LeBron James", "MIA", 76, 2877, 765, 1354, 0.565, 254, 0.406, 403, 535, 0.753, 610, 551, 129, 67, 226, 110, 2036, 2446);
        playerRepository.save(player);

        Optional<Player> retrievedPlayer = playerRepository.findByName("LeBron James");
        assertTrue(retrievedPlayer.isPresent());
        assertEquals("MIA", retrievedPlayer.get().getTeam());
    }

    @Test
    void testDeletePlayerByName() {
        Player player = new Player("Kobe Bryant", "LAL", 78, 3013, 738, 1595, 0.463, 407, 0.324, 525, 626, 0.839, 433, 469, 106, 25, 287, 173, 2133, 1921);
        playerRepository.save(player);

        playerRepository.deleteByName("Kobe Bryant");
        Optional<Player> retrievedPlayer = playerRepository.findByName("Kobe Bryant");
        assertFalse(retrievedPlayer.isPresent());
    }

    @Test
    void testUpdatePlayer() {
        Player player = new Player("Stephen Curry", "GSW", 78, 2800, 700, 1500, 0.467, 600, 0.421, 400, 450, 0.889, 450, 550, 120, 30, 250, 150, 2100, 2300);
        playerRepository.save(player);

        player.setTeam("Warriors");
        player.setPoints(2200);
        playerRepository.save(player);

        Optional<Player> updatedPlayer = playerRepository.findByName("Stephen Curry");
        assertTrue(updatedPlayer.isPresent());
        assertEquals("Warriors", updatedPlayer.get().getTeam());
        assertEquals(2200, updatedPlayer.get().getPoints());
    }
}
