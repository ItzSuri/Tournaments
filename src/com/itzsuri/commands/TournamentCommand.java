package com.itzsuri.commands;

import com.itzsuri.events.TournamentManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TournamentCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by players.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length < 4) {
            player.sendMessage("Usage: /tcreate <Name> <Description> <Date and Time> <Award>");
            return true;
        }

        String name = args[0];
        String description = args[1];
        String dateTime = args[2];
        String award = args[3];

        // Create the tournament
        TournamentManager.createTournament(player, name, description, dateTime, award);
        player.sendMessage("Tournament created successfully!");
        return true;
    }
}
