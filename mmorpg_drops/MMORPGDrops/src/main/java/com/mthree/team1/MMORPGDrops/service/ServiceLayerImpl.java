/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.team1.MMORPGDrops.service;

import com.mthree.team1.MMORPGDrops.dao.DatabaseDao;
import com.mthree.team1.MMORPGDrops.dto.Hiscore;
import com.mthree.team1.MMORPGDrops.dto.Item;
import java.util.List;

import com.mthree.team1.MMORPGDrops.dto.Player;
import com.mthree.team1.MMORPGDrops.dto.Record;
import com.mthree.team1.MMORPGDrops.dto.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucid
 */
@Service
public class ServiceLayerImpl implements ServiceLayer{
    
    @Autowired
    DatabaseDao dao;
    
    
    @Override
    public Player addPlayer(String playerName) {
        return dao.addPlayer(playerName);
    }

    @Override
    public String removePlayer(String playerName) {
        return dao.removePlayer(playerName);
    }

    @Override
    public Team addTeam(String teamName) {
        return dao.addTeam(teamName);
    }

    @Override
    public String removeTeam(String teamName) {
        return dao.removeTeam(teamName);
    }

    @Override
    public Record addLoot(String playerName, String  itemName) {
        return dao.addLoot(playerName, itemName);
    }

    @Override
    public String removeLoot(String playerName, String  itemName) {
        return dao.removeLoot(playerName, itemName);
    }

    @Override
    public Player joinTeam(String playerName, String  teamName) {
        return dao.joinTeam(playerName, teamName);
    }

    @Override
    public Player leaveTeam(String playerName) {
        return dao.leaveTeam(playerName);
    }

    @Override
    public List<Hiscore> getPlayerHiscores() {
        return dao.getPlayerHiscores();
    }

    @Override
    public List<Hiscore> getTeamHiscores() {
        return dao.getTeamHiscores();
    }

    @Override
    public List<Player> getAllPlayers() {
        return dao.getAllPlayers();
    }

    @Override
    public List<Record> getAllRecords() {
        return dao.getAllRecords();
    }
    
    @Override
    public List<Team> getAllTeams() {
        return dao.getAllTeams();
    }

    public List<Item> getAllItems() {
        return dao.getAllItems();
    }

}
