package de.patnase.ppgaming.jobsystem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class JobManager implements CommandExecutor {
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
}
