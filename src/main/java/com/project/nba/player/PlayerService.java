package com.project.nba.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Component
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    // Retrieve all players from the database
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    // Get players from a specific team
    public List<Player> getPlayersFromTeam(String teamName) {
        return playerRepository.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam()))
                .collect(Collectors.toList());
    }

    // Search players by name (case insensitive)
    public List<Player> getPlayersByName(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Get players by exact points scored
    public List<Player> getPlayersByPoints(int searchValue) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getPoints() == searchValue) 
                .collect(Collectors.toList());
    }

    // Get players by exact field goals made (FGM)
    public List<Player> getPlayersByFgm(int searchValue) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getFgm() == searchValue)
                .collect(Collectors.toList());
    }

    // Get players by team and points scored
    public List<Player> getPlayersByTeamAndPoints(String team, int points) {
        return playerRepository.findAll().stream()
                .filter(player -> team.equals(player.getTeam()) && player.getPoints() == points) 
                .collect(Collectors.toList());
    }

    // Add a new player to the database
    public Player addPlayer(Player player) {
        playerRepository.save(player);
        return player;
    }

    // Update an existing player's details
    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setTeam(updatedPlayer.getTeam());
            playerToUpdate.setPoints(updatedPlayer.getPoints());
            playerToUpdate.setFgm(updatedPlayer.getFgm());
            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }

    // Delete a player by name
    @Transactional
    public void deletePlayer(String playerName) {
        playerRepository.deleteByName(playerName);
    }
}
