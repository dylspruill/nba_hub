package com.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import com.project.nba.player.Player;
import com.project.nba.player.PlayerService;
import com.project.nba.player.PlayerRepository;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TestPlayerService {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Test
    void testGetPlayers() {
        Player kd = new Player("Kevin Durant", "OKC", 81, 3119, 731, 1433, 0.510, 334, 0.416, 679, 750, 0.905, 640, 374, 116, 105, 280, 143, 2280, 2462);
        Player kobe = new Player("Kobe Bryant", "LAL", 78, 3013, 738, 1595, 0.463, 407, 0.324, 525, 626, 0.839, 433, 469, 106, 25, 287, 173, 2133, 1921);
        playerRepository.save(kd);
        playerRepository.save(kobe);

        List<Player> result = playerService.getPlayers();

        assertEquals(2, result.size());
    }

    @Test
    void testGetPlayersFromTeam() {
        Player kd = new Player("Kevin Durant", "OKC", 81, 3119, 731, 1433, 0.510, 334, 0.416, 679, 750, 0.905, 640, 374, 116, 105, 280, 143, 2280, 2462);
        Player lebron = new Player("LeBron James", "MIA", 76, 2877, 765, 1354, 0.565, 254, 0.406, 403, 535, 0.753, 610, 551, 129, 67, 226, 110, 2036, 2446);
        playerRepository.save(kd);
        playerRepository.save(lebron);

        List<Player> result = playerService.getPlayersFromTeam("OKC");

        assertEquals(1, result.size());
        assertEquals("OKC", result.get(0).getTeam());
    }

    @Test
    void testGetPlayersByName() {
        Player kobe = new Player("Kobe Bryant", "LAL", 78, 3013, 738, 1595, 0.463, 407, 0.324, 525, 626, 0.839, 433, 469, 106, 25, 287, 173, 2133, 1921);
        Player carmelo = new Player("Carmelo Anthony", "NYK", 67, 2482, 669, 1489, 0.449, 414, 0.379, 425, 512, 0.830, 460, 171, 52, 32, 175, 205, 1920, 1553);
        playerRepository.save(kobe);
        playerRepository.save(carmelo);

        List<Player> result = playerService.getPlayersByName("Kobe");

        assertEquals(1, result.size());
        assertTrue(result.get(0).getName().contains("Kobe"));
    }

    @Test
    void testGetPlayersByPoints() {
        Player lebron = new Player("LeBron James", "MIA", 76, 2877, 765, 1354, 0.565, 254, 0.406, 403, 535, 0.753, 610, 551, 129, 67, 226, 110, 2036, 2446);
        Player harden = new Player("James Harden", "HOU", 78, 2985, 585, 1337, 0.438, 486, 0.368, 674, 792, 0.851, 379, 455, 142, 38, 295, 178, 2023, 1872);
        playerRepository.save(lebron);
        playerRepository.save(harden);

        List<Player> result = playerService.getPlayersByPoints(2036);

        assertEquals(1, result.size());
        assertEquals(2036, result.get(0).getPoints());
    }

    @Test
    void testAddPlayer() {
        Player newPlayer = new Player("Stephen Curry", "GSW", 78, 2800, 700, 1500, 0.467, 600, 0.421, 400, 450, 0.889, 450, 550, 120, 30, 250, 150, 2100, 2300);
        playerRepository.save(newPlayer);

        Player result = playerService.addPlayer(newPlayer);

        assertNotNull(result);
        assertEquals("Stephen Curry", result.getName());
    }

    @Test
    void testUpdatePlayer() {
        Player existingPlayer = new Player("Kevin Durant", "OKC", 81, 3119, 731, 1433, 0.510, 334, 0.416, 679, 750, 0.905, 640, 374, 116, 105, 280, 143, 2280, 2462);
        Player updatedPlayer = new Player("Kevin Durant", "BKN", 72, 2800, 700, 1400, 0.500, 300, 0.400, 650, 700, 0.929, 600, 350, 100, 90, 250, 130, 2200, 2400);
        playerRepository.save(existingPlayer);

        Player result = playerService.updatePlayer(updatedPlayer);

        assertNotNull(result);
        assertEquals("BKN", result.getTeam());
        assertEquals(2200, result.getPoints());
    }

    @Test
    void testDeletePlayer() {
        Player kobe = new Player("Kobe Bryant", "LAL", 78, 3013, 738, 1595, 0.463, 407, 0.324, 525, 626, 0.839, 433, 469, 106, 25, 287, 173, 2133, 1921);
        playerRepository.save(kobe);

        playerService.deletePlayer("Kobe Bryant");

        List<Player> result = playerService.getPlayersByName("Kobe Bryant");
        assertEquals(0, result.size());
    }
}
