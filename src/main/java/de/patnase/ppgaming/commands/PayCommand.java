package de.patnase.ppgaming.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = ((Player) sender).getPlayer();
            if (args.length == 2){
                String target = args[0];
                int amount = Integer.parseInt(args[1]);
                if (hasEnoughMoney(player.getName(), amount)){
                    removeMoney(player.getName(), amount);
                    addMoney(target, amount);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §2" + player.getName() + " §fgifted §6" + amount +"§a$ §f to §a" + target);
                }else {
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cNot enough money");
                }
            }
        }else {
            sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cThis command has to be executed by a player");
        }
        return false;
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

    public boolean hasEnoughMoney(String name, int amount){
        File file = new File("plugins/PPGaming", "money.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        int money  = config.getInt(name + ".money");
        return money >= amount;
    }
}
