# NBA Basketball Hub
A Java Spring Boot application that manages NBA player statistics using RESTful APIs, JPA for data persistence.

# Features

* Manage player statistics including points, assists, rebounds, and more.
* RESTful API endpoints for adding, updating, retrieving, and deleting player data.
* Comprehensive JUnit tests for Player, PlayerService, Player Controller, PlayerRepository.
* Uses H2 in-memory database for testing.
  
# Installation

1. Clone the repository:
```
git clone https://github.com/dylspruill/nba-hub.git
cd nba-basketball-hub
```

2. Build the project using Maven:
```
mvn clean install
```

3. Run the application:
```
mvn spring-boot:run
```

# Usage
API Endpoints

* Get all players:
```
GET /api/v1/player
```
* Add a new player:
```
POST /api/v1/player

{
  "name": "Stephen Curry",
  "team": "GSW",
  "games_played": 78,
  "minutes": 2800,
  "fgm": 700,
  "fa": 1500,
  "fgpt": 0.467,
  "reb": 450,
  "ast": 550,
  "stl": 120,
  "blk": 30,
  "tov": 250,
  "pf": 150,
  "points": 2100,
  "eff": 2300
}
```
* Update an existing player:
```
PUT /api/v1/player
{
  "name": "Stephen Curry",
  "team": "Warriors",
  "points": 2200
}
```
* Delete a player:
```
DELETE /api/v1/player/{playerName}
```

# Testing
JUnit tests are provided for the Player, PlayerService, and PlayerRepository classes.
  
* Run all tests using Maven:
```
mvn test
```

* Example Test Case
Test saving a player to the repository:
```
@Test
void testSavePlayer() {
    Player player = new Player("Kevin Durant", "OKC", 81, 3119, 731, 1433, 0.510, 334, 0.416, 679, 750, 0.905, 640, 374, 116, 105, 280, 143, 2280, 2462);
    playerRepository.save(player);
  
    Optional<Player> retrievedPlayer = playerRepository.findByName("Kevin Durant");
    assertTrue(retrievedPlayer.isPresent());
    assertEquals("OKC", retrievedPlayer.get().getTeam());
}
```

# Technologies Used

* Java 11
* Spring Boot
* Spring Data JPA
* PostgreSQL
* H2 Database
* JUnit 5
* Mockito
* Maven
