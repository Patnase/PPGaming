package de.patnase.ppgaming.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = ((Player) sender).getPlayer();
            player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §fYour Ping: §2" + player.getPing() + "§ams");
        }else {
            sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7]§c This command has to be executed by a player");
        }
        return false;
    }
}
