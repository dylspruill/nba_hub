package com.project.nba.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="player_stats")
public class Player {

   // Unique identifier for each player
   @Id
   @Column(name = "name", unique = true)
   private String name;

   // Player attributes
   private String team;
   private Integer games_played;
   private Integer minutes;
   private Integer fgm;  // Field Goals Made
   private Integer fa;   // Field Goal Attempts
   private Double fgpt;  // Field Goal Percentage
   private Integer fgta; // Three-Point Attempts
   private Double fgtapt; // Three-Point Percentage
   private Integer ftm;  // Free Throws Made
   private Integer fta;  // Free Throw Attempts
   private Double ftpt;  // Free Throw Percentage
   private Integer reb;  // Rebounds
   private Integer ast;  // Assists
   private Integer stl;  // Steals
   private Integer blk;  // Blocks
   private Integer tov;  // Turnovers
   private Integer pf;   // Personal Fouls
   private Integer points; // Total Points
   private Integer eff;  // Efficiency Rating

   // Constructors
   public Player(String name) {
       this.name = name;
   }

   public Player(String name, String team, Integer games_played, Integer minutes, Integer fgm, Integer fa, Double fgpt,
                 Integer fgta, Double fgtapt, Integer ftm, Integer fta, Double ftpt, Integer reb, Integer ast,
                 Integer stl, Integer blk, Integer tov, Integer pf, Integer points, Integer eff) {
       this.name = name;
       this.team = team;
       this.games_played = games_played;
       this.minutes = minutes;
       this.fgm = fgm;
       this.fa = fa;
       this.fgpt = fgpt;
       this.fgta = fgta;
       this.fgtapt = fgtapt;
       this.ftm = ftm;
       this.fta = fta;
       this.ftpt = ftpt;
       this.reb = reb;
       this.ast = ast;
       this.stl = stl;
       this.blk = blk;
       this.tov = tov;
       this.pf = pf;
       this.points = points;
       this.eff = eff;
   }

   public Player() {
   }

   // Getters and Setters
   public String getName() {
       return name;
   }
   public void setName(String name) {
       this.name = name;
   }

   public String getTeam() {
       return team;
   }
   public void setTeam(String team) {
       this.team = team;
   }

   public int getGamesPlayed() {
       return games_played;
   }
   public void setGamesPlayed(int games_played) {
       this.games_played = games_played;
   }

   public int getMinutes() {
       return minutes;
   }
   public void setMinutes(int minutes) {
       this.minutes = minutes;
   }

   public int getFgm() {
       return fgm;
   }
   public void setFgm(int fgm) {
       this.fgm = fgm;
   }

   public int getFa() {
       return fa;
   }
   public void setFa(int fa) {
       this.fa = fa;
   }

   public double getFgpt() {
       return fgpt;
   }
   public void setFgpt(double fgpt) {
       this.fgpt = fgpt;
   }

   public int getFgta() {
       return fgta;
   }
   public void setFgta(int fgta) {
       this.fgta = fgta;
   }

   public double getFgtapt() {
       return fgtapt;
   }
   public void setFgtapt(double fgtapt) {
       this.fgtapt = fgtapt;
   }

   public int getFtm() {
       return ftm;
   }
   public void setFtm(int ftm) {
       this.ftm = ftm;
   }

   public int getFta() {
       return fta;
   }
   public void setFta(int fta) {
       this.fta = fta;
   }

   public double getFtpt() {
       return ftpt;
   }
   public void setFtpt(double ftpt) {
       this.ftpt = ftpt;
   }

   public int getReb() {
       return reb;
   }
   public void setReb(int reb) {
       this.reb = reb;
   }

   public int getAst() {
       return ast;
   }
   public void setAst(int ast) {
       this.ast = ast;
   }

   public int getStl() {
       return stl;
   }
   public void setStl(int stl) {
       this.stl = stl;
   }

   public int getBlk() {
       return blk;
   }
   public void setBlk(int blk) {
       this.blk = blk;
   }

   public int getTov() {
       return tov;
   }
   public void setTov(int tov) {
       this.tov = tov;
   }

   public int getPf() {
       return pf;
   }
   public void setPf(int pf) {
       this.pf = pf;
   }

   public int getPoints() {
       return points;
   }
   public void setPoints(int points) {
       this.points = points;
   }

   public int getEff() {
       return eff;
   }
   public void setEff(int eff) {
       this.eff = eff;
   }

   // ToString method for debugging/logging
   @Override
   public String toString() {
       return "Player{" +
               "name='" + name + '\'' +
               ", team='" + team + '\'' +
               ", games_played=" + games_played +
               ", minutes=" + minutes +
               ", fgm=" + fgm +
               ", fa=" + fa +
               ", fgpt=" + fgpt +
               ", fgta=" + fgta +
               ", fgtapt=" + fgtapt +
               ", ftm=" + ftm +
               ", fta=" + fta +
               ", ftpt=" + ftpt +
               ", reb=" + reb +
               ", ast=" + ast +
               ", stl=" + stl +
               ", blk=" + blk +
               ", tov=" + tov +
               ", pf=" + pf +
               ", points=" + points +
               ", eff=" + eff +
               '}';
   }
}
