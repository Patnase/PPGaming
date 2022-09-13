package de.patnase.ppgaming.listeners;

import de.patnase.ppgaming.Main;
import de.patnase.ppgaming.scoreboard.Sidebar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage("§7[§6§lP§c§lP§3§lG§baming§7] §2>> §a" + player.getName());
        new Sidebar(player);
        Main.getInstance().getTabListManager().setPlayerList(player);
        Main.getInstance().getTabListManager().setAllPlayerTeams();
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        event.setQuitMessage("§7[§6§lP§c§lP§3§lG§baming§7] §c<< §4" + player.getName());
    }
}
