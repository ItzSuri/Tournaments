package com.itzsuri.events;

import com.itzsuri.main.Tournaments;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class TournamentListener implements Listener {

    private final Tournaments plugin;

    public TournamentListener(Tournaments plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        List<Tournament> upcomingTournaments = TournamentManager.getUpcomingTournaments();
        for (Tournament tournament : upcomingTournaments) {
            tournament.notifyPlayers();
        }
    }
}
