package de.patnase.ppgaming.economy;

import com.sun.java.swing.action.OkAction;
import de.patnase.ppgaming.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import javax.sound.sampled.Line;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EconomySystem implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player){
                Player player = ((Player) sender).getPlayer();
                player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §fYour §amoney§f: §6" + getMoney(player.getName()) + "§2$");
            }else {
                sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cThis command has to be executed by a player");
            }
        }else if (args.length == 3) {
            if (sender.isOp()){
                if (args[0].equalsIgnoreCase("add")) {
                    String target = args[1];
                    Integer amount = Integer.valueOf(args[2]);
                    addMoney(target, amount);
                    sender.sendMessage("[§6§lP§c§lP§3§lG§baming§7] §2" + target + "'s §amoney §f has been inreased by §6" + amount + "§2$");
                } else if (args[0].equalsIgnoreCase("remove")) {
                    String target = args[1];
                    Integer amount = Integer.valueOf(args[2]);
                    removeMoney(target, amount);
                    sender.sendMessage("[§6§lP§c§lP§3§lG§baming§7] §2" + target + "'s §amoney §f has been decreased by §6" + amount + "§2$");
                } else if (args[0].equalsIgnoreCase("set")) {
                    String target = args[1];
                    Integer amount = Integer.valueOf(args[2]);
                    setMoney(target, amount);
                    sender.sendMessage("[§6§lP§c§lP§3§lG§baming§7] §2" + target + "'s §amoney §f has been changed by §6" + amount + "§2$");
                } else {
                    sender.sendMessage("§7[§6§P§c§lP§3§lG§baming§7] §cUsage: /money <get|set|add|remove> <player> <amount>");
                }
            }else {
                sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cNo permission");
            }
        }else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("get")) {
                String target = args[1];
                int money = getMoney(target);
                sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] " + ChatColor.DARK_GREEN + target + "'s §amoney§f: §6" + money + "§2$");
            } else {
                sender.sendMessage("§7[§6§P§c§lP§3§lG§baming§7] §cUsage: /money <get|set|add|remove> <player> <amount>");
            }
        }else {
            sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cUsage /money");
        }
        return false;
    }

    public Integer getMoney(String name){
        File file = new File("plugins/PPGaming", "money.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        int money = config.getInt(name + ".money");
        return money;
    }

    public void addMoney(String name, int amount) {
        File file = new File("plugins/PPGaming", "money.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        int money =  config.getInt(name + ".money");
        money = money + amount;

        config.set(name + ".money", money);
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeMoney(String name, int amount){
        File file = new File("plugins/PPGaming", "money.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        int money =  config.getInt(name + ".money");
        money = money - amount;

        config.set(name + ".money", money);
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMoney(String name, int amount){
        File file = new File("plugins/PPGaming", "money.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        config.set(name + ".money", amount);
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasEnoughMoney(String name, int amount){
        File file = new File("plugins/PPGaming", "money.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        int money  = config.getInt(name + ".money");
        return money >= amount;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if (args.length == 0) return list;
        if (args.length == 1){
            list.add("add");
            list.add("get");
            list.add("set");
            list.add("remove");
        }else if (args.length == 2){
            for (Player player : Bukkit.getOnlinePlayers()){
                list.add(player.getName());
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
