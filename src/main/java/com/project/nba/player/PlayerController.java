package com.project.nba.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // Get players with optional filters for team, name, points, or field goals made
    @GetMapping
    public List<Player> getPlayers(
        @RequestParam(required = false) String team,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Integer points,
        @RequestParam(required = false) Integer fgm) {

        if (team != null && points != null) {
            return playerService.getPlayersByTeamAndPoints(team, points);
        } else if (team != null) {
            return playerService.getPlayersFromTeam(team);
        } else if (name != null) {
            return playerService.getPlayersByName(name);
        } else if (points != null) {
            return playerService.getPlayersByPoints(points);
        } else if (fgm != null) {
            return playerService.getPlayersByFgm(fgm);
        } else {
            return playerService.getPlayers();
        }
    }

    // Add a new player to the database
    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    // Update an existing player’s details
    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player updatedPlayer) {
        Player resultPlayer = playerService.updatePlayer(updatedPlayer);
        if (resultPlayer != null) {
            return new ResponseEntity<>(resultPlayer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a player by name
    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName) {
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }
}
