package com.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;

import com.project.nba.player.Player;
import com.project.nba.player.PlayerController;
import com.project.nba.player.PlayerService;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(PlayerController.class)
public class TestPlayerController {

    @Autowired
    private MockMvc mockMvc;

    private PlayerService playerService;

    @Test
    void testGetPlayers() throws Exception {
        Player kd = new Player("Kevin Durant", "OKC", 81, 3119, 731, 1433, 0.510, 334, 0.416, 679, 750, 0.905, 640, 374, 116, 105, 280, 143, 2280, 2462);
        Player kobe = new Player("Kobe Bryant", "LAL", 78, 3013, 738, 1595, 0.463, 407, 0.324, 525, 626, 0.839, 433, 469, 106, 25, 287, 173, 2133, 1921);
        List<Player> players = Arrays.asList(kd, kobe);

        when(playerService.getPlayers()).thenReturn(players);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/player")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Kevin Durant"))
                .andExpect(jsonPath("$[1].name").value("Kobe Bryant"));
    }

    @Test
    void testAddPlayer() throws Exception {
        Player newPlayer = new Player("Stephen Curry", "GSW", 78, 2800, 700, 1500, 0.467, 600, 0.421, 400, 450, 0.889, 450, 550, 120, 30, 250, 150, 2100, 2300);
        when(playerService.addPlayer(any(Player.class))).thenReturn(newPlayer);

        String playerJson = "{\"name\":\"Stephen Curry\",\"team\":\"GSW\",\"games_played\":78,\"minutes\":2800,\"fgm\":700,\"fa\":1500,\"fgpt\":0.467,\"fgta\":600,\"fgtapt\":0.421,\"ftm\":400,\"fta\":450,\"ftpt\":0.889,\"reb\":450,\"ast\":550,\"stl\":120,\"blk\":30,\"tov\":250,\"pf\":150,\"points\":2100,\"eff\":2300}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/player")
                .contentType(MediaType.APPLICATION_JSON)
                .content(playerJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Stephen Curry"))
                .andExpect(jsonPath("$.team").value("GSW"));
    }

    @Test
    void testDeletePlayer() throws Exception {
        doNothing().when(playerService).deletePlayer("Kobe Bryant");

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/player/Kobe Bryant")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Player deleted successfully"));
    }

    @Test
    void testUpdatePlayer() throws Exception {
        Player updatedPlayer = new Player("Kevin Durant", "BKN", 72, 2800, 700, 1400, 0.500, 300, 0.400, 650, 700, 0.929, 600, 350, 100, 90, 250, 130, 2200, 2400);
        when(playerService.updatePlayer(any(Player.class))).thenReturn(updatedPlayer);

        String playerJson = "{\"name\":\"Kevin Durant\",\"team\":\"BKN\",\"games_played\":72,\"minutes\":2800,\"fgm\":700,\"fa\":1400,\"fgpt\":0.5,\"fgta\":300,\"fgtapt\":0.4,\"ftm\":650,\"fta\":700,\"ftpt\":0.929,\"reb\":600,\"ast\":350,\"stl\":100,\"blk\":90,\"tov\":250,\"pf\":130,\"points\":2200,\"eff\":2400}";

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/player")
                .contentType(MediaType.APPLICATION_JSON)
                .content(playerJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Kevin Durant"))
                .andExpect(jsonPath("$.team").value("BKN"));
    }
}
