package de.patnase.ppgaming.listeners;

import de.patnase.ppgaming.Main;
import de.patnase.ppgaming.scoreboard.Sidebar;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;

public class ConnectionListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage("§7[§6§lP§c§lP§3§lG§baming§7] §2>> §a" + player.getName());
        new Sidebar(player);
        Main.getInstance().getTabListManager().setPlayerList(player);
        Main.getInstance().getTabListManager().setAllPlayerTeams();
        if (getPermission(player.getName()) == null){
            setPermission(player.getName(), "player");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        event.setQuitMessage("§7[§6§lP§c§lP§3§lG§baming§7] §c<< §4" + player.getName());
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

    public String getPermission(String name){
        File file = new File("plugins/PPGaming", "permissions.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        String permission = config.getString(name + ".permission");
        return permission;
    }
}
