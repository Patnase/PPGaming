package de.patnase.ppgaming.jobsystem;

import org.bukkit.Bukkit;
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

public class JobManager implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2){
            if (args[0].equalsIgnoreCase("get")){
                String target = args[1];
                sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §2" + target + "'s §ajob§f: §6" + getJob(target));
            }
        }else if (args.length == 3){
            if (sender.isOp()){
                if (args[0].equalsIgnoreCase("set")){
                    String target = args[1];
                    if (args[2].equalsIgnoreCase("timber")){
                        setJob(target, "timber");
                        sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §2" + target +"'s §ajob§f has been updated to: §6" + getJob(target));
                    }else if (args[2].equalsIgnoreCase("miner")) {
                        setJob(target, "miner");
                        sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §2" + target + "'s §ajob§f has been updated to: §6" + getJob(target));
                    }else if (args[2].equalsIgnoreCase("farmer")){
                        setJob(target, "farmer");
                        sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §2" + target + "'s §ajob§f has been updated to: §6" + getJob(target));
                    }else if (args[2].equalsIgnoreCase("butcher")) {
                        setJob(target, "butcher");
                        sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §2" + target + "'s §ajob§f has been updated to: §6" + getJob(target));
                    }else if (args[2].equalsIgnoreCase("fisher")){
                        setJob(target, "fisher");
                        sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §2" + target + "'s §ajob§f has been updated to: §6" + getJob(target));
                    }else {
                        sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cThis job doesn't exist");
                    }
                }else {
                    sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cUsage: /job <get|set> <player> <job>");
                }
            }
        }else {
            sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cUsage: /job <get|set> <player> <job>");
        }
        return false;
    }

    public String getJob(String name){
        File file = new File("plugins/PPGaming", "jobs.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        String job = (String) config.get(name + ".job");
        return job;
    }

    public void setJob(String name, String job){
        File file = new File("plugins/PPGaming", "jobs.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        config.set(name + ".job", job);
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if (args.length == 0) return list;
        if (args.length == 1) {
            list.add("set");
            list.add("get");
        }else if (args.length == 2){
            for (Player player : Bukkit.getOnlinePlayers()){
                list.add(player.getName());
            }
        }else if (args.length == 3){
            list.add("timber");
            list.add("miner");
            list.add("fisher");
            list.add("butcher");
            list.add("beta");
            list.add("farmer");
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
