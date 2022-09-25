package de.patnase.ppgaming.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.io.File;

public class InventorySeeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = ((Player) sender).getPlayer();
            if (getPermission(player.getName()).equalsIgnoreCase("admin")){
                if (args.length == 1){
                    Inventory inventory = Bukkit.getPlayer(args[0]).getInventory();
                    player.openInventory(inventory);
                }else {
                    sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cUsage: /invsee <player>");
                }
            }else {
                sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cNo permission");
            }
        }else{
            sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cThis command has to bee executed by a player");
        }
        return false;
    }

    public String getPermission(String name){
        File file = new File("plugins/PPGaming", "permissions.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        String permission = config.getString(name + ".permission");
        return permission;
    }
}
