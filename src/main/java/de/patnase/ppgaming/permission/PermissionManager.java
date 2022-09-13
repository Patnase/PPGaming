package de.patnase.ppgaming.permission;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PermissionManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("get")) {
                String target = args[1];
                sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §2" + target + "'s §apermission§f: §6" + getPermission(target));
            } else {
                sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cUsage: /permission <get|set> <player> <permission>");
            }
        } else if (args.length == 3) {
            if (args[0].equalsIgnoreCase("set")) {
                if (sender.isOp()) {
                    String target = args[1];
                    if (args[2].equalsIgnoreCase("admin")) {
                        setPermission(target, "admin");
                        sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §2" + target + "'s §apermission §f has been updated to: §6" + getPermission(target));
                    } else if (args[2].equalsIgnoreCase("mod")) {
                        setPermission(target, "mod");
                        sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §2" + target + "'s §apermission §f has been updated to: §6" + getPermission(target));
                    } else if (args[2].equalsIgnoreCase("beta")) {
                        setPermission(target, "beta");
                        sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §2" + target + "'s §apermission §f has been updated to: §6" + getPermission(target));
                    } else if (args[2].equalsIgnoreCase("vip")) {
                        setPermission(target, "vip");
                        sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §2" + target + "'s §apermission §f has been updated to: §6" + getPermission(target));
                    } else if (args[2].equalsIgnoreCase("streamer")) {
                        setPermission(target, "streamer");
                        sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §2" + target + "'s §apermission §f has been updated to: §6" + getPermission(target));
                    } else {
                        sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cThis permission doesn't exist");
                    }
                } else {
                    sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cNo permission");
                }
            } else {
                sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cUsage: /permission <set|get> <player> <permission>");
            }
        }else {
            sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cUsage: /permission <set|get> <player> <permission>");
        }
        return false;
    }

    public String getPermission(String name){
        File file = new File("plugins/PPGaming", "permissions.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        String permission = config.getString(name + ".permission");
        return permission;
    }

    public void setPermission(String name ,String permission){
        File file = new File("plugins/PPGaming", "permissions.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        config.set(name + ".permission", permission);
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasPermission(String name, String permission){
        File file = new File("plugins/PPgaming", "permissions.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        String actualpermission = config.getString(name + ".permission", permission);
        return actualpermission.equals(permission);
    }
}
