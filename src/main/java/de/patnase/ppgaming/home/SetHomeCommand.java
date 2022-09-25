package de.patnase.ppgaming.home;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SetHomeCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = ((Player) sender).getPlayer();
            if (hasPermission(player.getName(), "admin")){
                if (args.length == 2){
                    if (Integer.valueOf(args[0]) <= 4){
                        setHome(player.getName(), Integer.valueOf(args[0]), args[1], player.getLocation());
                        player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §fYour home has been set");
                    }else {
                        player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cYou can't have more than §44 §chomes");
                    }
                }else {
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cUsage: /sethome <id> <name>");
                }
            }else if (hasPermission(player.getName(), "mod")){
                if (args.length == 2){
                    if (Integer.valueOf(args[0]) <= 4){
                        setHome(player.getName(), Integer.valueOf(args[0]), args[1], player.getLocation());
                        player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §fYour home has been set");
                    }else {
                        player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cYou can't have more than §44 §chomes");
                    }
                }else {
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cUsage: /sethome <id> <name>");
                }
            }else if (hasPermission(player.getName(), "vip")){
                if (args.length == 2){
                    if (Integer.valueOf(args[0]) <= 4){
                        setHome(player.getName(), Integer.valueOf(args[0]), args[1], player.getLocation());
                        player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §fYour home has been set");
                    }else {
                        player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cYou can't have more than §44 §chomes");
                    }
                }else {
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cUsage: /sethome <id> <name>");
                }
            }else {
                player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cNo permission");
            }
        }else {
            sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cThis command has to be executed by a player");
        }
        return false;
    }

    public void setHome(String player, Integer id, String name, Location location){
        File file = new File("plugins/PPGaming", "homes.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        config.set(player + ".home" + id + ".location", location);
        config.set(player + ".home" + id + ".name", name);
        try {
            config.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean hasPermission(String name, String permission){
        File file = new File("plugins/PPgaming", "permissions.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        String actualpermission = config.getString(name + ".permission", permission);
        return actualpermission.equals(permission);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if (args.length == 0) return list;
        if (args.length == 1){
            for (int i = 1; i<5; i++){
                list.add(String.valueOf(i));
            }
        }
        ArrayList<String> completerList = new ArrayList<>();
        String currentarg = args[args.length - 1].toLowerCase();
        for (String s : list){
            String s1 = s.toLowerCase();
            if (s1.startsWith(currentarg)){
                completerList.add(s);
            }
        }
        return completerList;
    }
}
