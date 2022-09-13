package de.patnase.ppgaming.scoreboard;

import de.patnase.ppgaming.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;

public class Sidebar extends ScoreboardBuilder {

    private int twitchId;

    public Sidebar(Player player) {
        super(player, "§6§lP§c§lP§3§lG§baming");
        twitchId = 0;

        run();
    }

    @Override
    public void createScoreboard() {
        setScore(ChatColor.YELLOW.toString(), 9);
        setScore("§7Rank:", 8);
        setScore(ChatColor.DARK_GRAY.toString(), 6);
        setScore("§5Twitch:", 5);
        setScore("§dtwitch.tv/patnase_live", 4);
        setScore(ChatColor.AQUA.toString(), 3);
        setScore("§7Server Status:", 2);
        setScore("§bBeta", 1);
        setScore(ChatColor.BLACK.toString(), 0);
        if (getPermission(player.getName()).equalsIgnoreCase("admin")) {
            setScore("§cAdmin", 7);
        }else if (getPermission(player.getName()).equalsIgnoreCase("mod")) {
            setScore("§eModerator", 7);
        }else if (getPermission(player.getName()).equalsIgnoreCase("beta")) {
            setScore("§bBeta", 7);
        }else if (getPermission(player.getName()).equalsIgnoreCase("vip")) {
            setScore("§9VIP", 7);
        }else if (getPermission(player.getName()).equalsIgnoreCase("streamer")){
            setScore("§dStreamer", 7);
        }else {
            setScore("aPlayer", 7);
        }

    }

    public void run(){
        new BukkitRunnable(){
            @Override
            public void run(){
                switch (twitchId){
                    case 0:
                        setScore("§dtwitch.tv/patnase_live", 4);
                        break;
                    case 1:
                        setScore("§dtwitch.tv/philip_gaming__", 4);
                        break;
                }
                twitchId++;

                if (twitchId >= 2) {
                    twitchId = 0;
                }
            }
        }.runTaskTimer(Main.getInstance(), 100, 100);
    }

    public String getPermission(String name){
        File file = new File("plugins/PPGaming", "permissions.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        String permission = config.getString(name + ".permission");
        return permission;
    }
}
