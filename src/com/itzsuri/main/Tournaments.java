package com.itzsuri.main;

import com.itzsuri.commands.TournamentCommand;
import com.itzsuri.commands.UsePrebuiltMapCommand;
import com.itzsuri.events.TournamentListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Tournaments extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("GodSpunkyTournamentOfficialPlugin has been enabled.");
        // Register event listeners and commands
        getServer().getPluginManager().registerEvents(new TournamentListener(this), this);
        getCommand("tcreate").setExecutor(new TournamentCommand());
        getCommand("useprebuiltmap").setExecutor(new UsePrebuiltMapCommand());
        getCommand("upbm").setExecutor(new UsePrebuiltMapCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("Tournaments has been disabled.");
    }
}
