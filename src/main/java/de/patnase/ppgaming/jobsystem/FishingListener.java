package de.patnase.ppgaming.jobsystem;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import java.io.File;
import java.io.IOException;

public class FishingListener implements Listener {
    @EventHandler
    public void onFishing(PlayerFishEvent event) {
        Player player = event.getPlayer();
        switch (getJob(player.getName())) {
            case "fisher":
                addMoney(player.getName(), 25);
                player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                break;
        }
    }

    public String getJob(String name) {
        File file = new File("plugins/PPGaming", "jobs.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        String job = (String) config.get(name + ".job");
        return job;
    }

    public void addMoney(String name, int amount) {
        File file = new File("plugins/PPGaming", "money.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        int money = config.getInt(name + ".money");
        money = money + amount;

        config.set(name + ".money", money);
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
