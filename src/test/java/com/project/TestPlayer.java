package com.project;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.project.nba.player.Player;

public class TestPlayer {

    @Test
    void testPlayerConstructorAndGetters() {
        Player player = new Player("Kevin Durant", "OKC", 81, 3119, 731, 1433, 0.510, 334, 0.416, 679, 750, 0.905, 640, 374, 116, 105, 280, 143, 2280, 2462);

        assertEquals("Kevin Durant", player.getName());
        assertEquals("OKC", player.getTeam());
        assertEquals(81, player.getGamesPlayed());
        assertEquals(3119, player.getMinutes());
        assertEquals(731, player.getFgm());
        assertEquals(1433, player.getFa());
        assertEquals(0.510, player.getFgpt());
        assertEquals(334, player.getFgta());
        assertEquals(0.416, player.getFgtapt());
        assertEquals(679, player.getFtm());
        assertEquals(750, player.getFta());
        assertEquals(0.905, player.getFtpt());
        assertEquals(640, player.getReb());
        assertEquals(374, player.getAst());
        assertEquals(116, player.getStl());
        assertEquals(105, player.getBlk());
        assertEquals(280, player.getTov());
        assertEquals(143, player.getPf());
        assertEquals(2280, player.getPoints());
        assertEquals(2462, player.getEff());
    }

    @Test
    void testSetters() {
        Player player = new Player();
        player.setName("LeBron James");
        player.setTeam("MIA");
        player.setGamesPlayed(76);
        player.setMinutes(2877);
        player.setFgm(765);
        player.setFa(1354);
        player.setFgpt(0.565);
        player.setFgta(254);
        player.setFgtapt(0.406);
        player.setFtm(403);
        player.setFta(535);
        player.setFtpt(0.753);
        player.setReb(610);
        player.setAst(551);
        player.setStl(129);
        player.setBlk(67);
        player.setTov(226);
        player.setPf(110);
        player.setPoints(2036);
        player.setEff(2446);

        assertEquals("LeBron James", player.getName());
        assertEquals("MIA", player.getTeam());
        assertEquals(76, player.getGamesPlayed());
        assertEquals(2877, player.getMinutes());
        assertEquals(765, player.getFgm());
        assertEquals(1354, player.getFa());
        assertEquals(0.565, player.getFgpt());
        assertEquals(254, player.getFgta());
        assertEquals(0.406, player.getFgtapt());
        assertEquals(403, player.getFtm());
        assertEquals(535, player.getFta());
        assertEquals(0.753, player.getFtpt());
        assertEquals(610, player.getReb());
        assertEquals(551, player.getAst());
        assertEquals(129, player.getStl());
        assertEquals(67, player.getBlk());
        assertEquals(226, player.getTov());
        assertEquals(110, player.getPf());
        assertEquals(2036, player.getPoints());
        assertEquals(2446, player.getEff());
    }

    @Test
    void testToString() {
        Player player = new Player("James Harden", "HOU", 78, 2985, 585, 1337, 0.438, 486, 0.368, 674, 792, 0.851, 379, 455, 142, 38, 295, 178, 2023, 1872);
        String expectedString = "Player{name='James Harden', team='HOU', games_played=78, minutes=2985, fgm=585, fa=1337, fgpt=0.438, fgta=486, fgtapt=0.368, ftm=674, fta=792, ftpt=0.851, reb=379, ast=455, stl=142, blk=38, tov=295, pf=178, points=2023, eff=1872}";

        assertEquals(expectedString, player.toString());
    }
}

