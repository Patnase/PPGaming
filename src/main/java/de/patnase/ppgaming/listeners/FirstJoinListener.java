package de.patnase.ppgaming.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;

public class FirstJoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore()){
            addMoney(player.getName(), 5000);
        }
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

}
