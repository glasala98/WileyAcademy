/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.team1.MMORPGDrops.service;

import com.mthree.team1.MMORPGDrops.dto.Hiscore;
import com.mthree.team1.MMORPGDrops.dto.Item;
import java.util.List;

import com.mthree.team1.MMORPGDrops.dto.Player;
import com.mthree.team1.MMORPGDrops.dto.Record;
import com.mthree.team1.MMORPGDrops.dto.Team;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucid
 */
@Service
public interface ServiceLayer {

    Player addPlayer(String playerName);
    String removePlayer(String playerName);
    Team addTeam(String teamName);
    String removeTeam(String teamName);
    Record addLoot(String playerName, String  itemName);
    String removeLoot(String playerName, String  itemName);
    Player joinTeam(String playerName, String  teamName);
    Player leaveTeam(String playerName);
    List<Hiscore> getPlayerHiscores();
    List<Hiscore> getTeamHiscores();
    List<Player> getAllPlayers();
    List<Record> getAllRecords();
    List<Team> getAllTeams();
    List<Item> getAllItems();
}
