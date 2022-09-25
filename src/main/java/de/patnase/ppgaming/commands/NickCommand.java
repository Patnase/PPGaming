package de.patnase.ppgaming.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class NickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = ((Player) sender).getPlayer();
            if (hasPermission(player.getName(), "admin")){
                if (args.length == 1){
                    player.setDisplayName(args[0]);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §fYour nickname has been set to §a" + args[1]);
                }else {
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cUsage: /nick <nickname>");
                }
            }else if (hasPermission(player.getName(), "mod")){
                if (args.length == 1){
                    player.setDisplayName(args[0]);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §fYour nickname has been set to §a" + args[1]);
                }else {
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cUsage: /nick <nickname>");
                }
            }else if (hasPermission(player.getName(), "vip")){
                if (args.length == 1){
                    player.setDisplayName(args[0]);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §fYour nickname has been set to §a" + args[1]);
                }else {
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cUsage: /nick <nickname>");
                }
            }else {
                player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cNo permission");
            }
        }else {
            sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cThis command has to be executed by a player");
        }
        return false;
    }

    public boolean hasPermission(String name, String permission){
        File file = new File("plugins/PPgaming", "permissions.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        String actualpermission = config.getString(name + ".permission", permission);
        return actualpermission.equals(permission);
    }
}
