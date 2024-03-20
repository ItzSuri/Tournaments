package com.itzsuri.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

public class Tournament {
    private final Player creator;
    private final String name;
    private final String description;
    private final String dateTime;
    private final String award;
    private World tournamentWorld;

    public Tournament(Player creator, String name, String description, String dateTime, String award) {
        this.creator = creator;
        this.name = name;
        this.description = description;
        this.dateTime = dateTime;
        this.award = award;

        // Teleport creator to tournament world
        teleportCreator();
    }

    public void notifyPlayers() {
        // Send notification message to all players
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(ChatColor.RED + "ATTENTION PLAYERS!");
            player.sendMessage(ChatColor.AQUA + "A tournament called -");
            player.sendMessage(ChatColor.BLACK + name);
            player.sendMessage(ChatColor.AQUA + "In this tournament you basically have to do - " + description + " on " + ChatColor.RED + dateTime + ChatColor.AQUA + " and the award is " + ChatColor.GOLD + award + "!");
        }
    }

    private void teleportCreator() {
        // Create a new world for the tournament
        WorldCreator worldCreator = new WorldCreator("tournament_world_" + name.toLowerCase().replace(" ", "_"));
        tournamentWorld = Bukkit.createWorld(worldCreator);

        // Teleport creator to the tournament world
        creator.teleport(tournamentWorld.getSpawnLocation());

        // Set creator's game mode to creative
        creator.setGameMode(GameMode.CREATIVE);

        // Inform creator about teleportation
        creator.sendMessage(ChatColor.GREEN + "You have been teleported to the tournament world. You can start building for your tournament!");
        creator.sendMessage(ChatColor.GREEN + "If you want to use a pre-built map, type '/useprebuiltmap' or '/upbm'!");
    }

    public void usePrebuiltMap() {
        // Teleport creator to the pre-built map
        creator.teleport(tournamentWorld.getSpawnLocation());
        creator.sendMessage(ChatColor.GREEN + "You have been teleported to the pre-built map for your tournament!");
    }

    // Getter method for the creator
    public Player getCreator() {
        return creator;
    }
}
