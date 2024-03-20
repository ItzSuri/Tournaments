package com.itzsuri.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TournamentManager {

    private static final List<Tournament> tournaments = new ArrayList<>();

    public static void createTournament(Player creator, String name, String description, String dateTime, String award) {
        Tournament tournament = new Tournament(creator, name, description, dateTime, award);
        tournaments.add(tournament);
    }

    public static void usePrebuiltMap(Player player) {
        // Get the tournament for the player
        Tournament tournament = getTournamentByCreator(player);
        if (tournament != null) {
            tournament.usePrebuiltMap();
        } else {
            player.sendMessage(ChatColor.RED + "You don't have an active tournament. Create one first.");
        }
    }

    private static Tournament getTournamentByCreator(Player creator) {
        for (Tournament tournament : tournaments) {
            if (tournament.getCreator().equals(creator)) {
                return tournament;
            }
        }
        return null;
    }

    public static List<Tournament> getUpcomingTournaments() {
        return tournaments;
    }
}

