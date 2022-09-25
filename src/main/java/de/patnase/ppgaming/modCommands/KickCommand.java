package de.patnase.ppgaming.modCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class KickCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if (player.isOp()) {
                if (args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    target.kickPlayer("§6§lP§c§lP§3§lG§baming\n§cYou've been kicked from the Server!\n\n§fReason: §c§lnone");
                }else if (args.length == 2){
                    Player target = Bukkit.getPlayer(args[0]);
                    target.kickPlayer("§6§lP§c§lP§3§lG§baming\n§cYou've been kicked from the Server!\n\n§fReason: §c§l" + args[1]);
                }
            }else if (hasPermission(player.getName(), "admin")){
                if (args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    target.kickPlayer("§6§lP§c§lP§3§lG§baming\n§cYou've been kicked from the Server!\n\n§fReason: §c§lnone");
                }else if (args.length == 2){
                    Player target = Bukkit.getPlayer(args[0]);
                    target.kickPlayer("§6§lP§c§lP§3§lG§baming\n§cYou've been kicked from the Server!\n\n§fReason: §c§l" + args[1]);
                }
            }else if (hasPermission(player.getName(), "mod")){
                if (args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    target.kickPlayer("§6§lP§c§lP§3§lG§baming\n§cYou've been kicked from the Server!\n\n§fReason: §c§lnone");
                }else if (args.length == 2){
                    Player target = Bukkit.getPlayer(args[0]);
                    target.kickPlayer("§6§lP§c§lP§3§lG§baming\n§cYou've been kicked from the Server!\n\n§fReason: §c§l" + args[1]);
                }
            }else {
                player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cNo permission");
            }
        }else {
            if (sender.isOp()){
                if (args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    target.kickPlayer("§6§lP§c§lP§3§lG§baming\n§cYou've been kicked from the Server!\n\n§fReason: §c§lnone");
                }else if (args.length == 2){
                    Player target = Bukkit.getPlayer(args[0]);
                    target.kickPlayer("§6§lP§c§lP§3§lG§baming\n§cYou've been kicked from the Server!\n\n§fReason: §c§l" + args[1]);
                }else if (args.length >2){
                    sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7]");
                }
            }else {
                sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cNo permission");
            }
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
