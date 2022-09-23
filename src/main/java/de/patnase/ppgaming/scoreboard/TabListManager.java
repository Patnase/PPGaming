package de.patnase.ppgaming.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.io.File;
import java.nio.file.attribute.UserPrincipalNotFoundException;

public class TabListManager {

    public void setPlayerList(Player player){
        player.setPlayerListHeaderFooter(">>> §6§lP§c§lP§3§lG§baming §f<<<\n§7" + ChatColor.STRIKETHROUGH + "                            ", "§7" + ChatColor.STRIKETHROUGH + "                            ");
    }

    public void setAllPlayerTeams(){
        Bukkit.getOnlinePlayers().forEach(this::setPlayerTeams);
    }

    public void setPlayerTeams(Player player) {
        Scoreboard scoreboard = player.getScoreboard();

        Team players = scoreboard.getTeam("010players");
        if (players == null) {
            players = scoreboard.registerNewTeam("010players");
        }

        Team admins = scoreboard.getTeam("001admins");
        if (admins == null) {
            admins = scoreboard.registerNewTeam("001admins");
        }

        Team mods = scoreboard.getTeam("002mods");
        if (mods == null) {
            mods = scoreboard.registerNewTeam("002mods");
        }

        Team betas = scoreboard.getTeam("009betas");
        if (betas == null) {
            betas = scoreboard.registerNewTeam("009betas");
        }

        Team vips = scoreboard.getTeam("005vips");
        if (vips == null) {
            vips = scoreboard.registerNewTeam("005vips");
        }

        Team streamers = scoreboard.getTeam("008streamers");
        if (streamers == null) {
            streamers = scoreboard.registerNewTeam("008streamers");
        }

        players.setPrefix("§a Player §8| ");
        players.setColor(ChatColor.WHITE);

        admins.setPrefix("§c Admin §8| ");
        admins.setColor(ChatColor.WHITE);

        mods.setPrefix("§e Moderator §8| ");
        mods.setColor(ChatColor.WHITE);

        betas.setPrefix("§b Beta §8| ");
        betas.setColor(ChatColor.WHITE);

        vips.setPrefix("§9 VIP §8| ");
        vips.setColor(ChatColor.WHITE);

        streamers.setPrefix("§d Streamer §8| ");
        streamers.setColor(ChatColor.WHITE);


        for (Player target : Bukkit.getOnlinePlayers()) {
            if (getPermission(player.getName()) != null){
                if (getPermission(target.getName()).equalsIgnoreCase("admin")){
                    admins.addEntry(target.getName());
                }else if (getPermission(target.getName()).equalsIgnoreCase("mod")){
                    mods.addEntry(target.getName());
                }else if (getPermission(target.getName()).equalsIgnoreCase("beta")){
                    betas.addEntry(target.getName());
                }else if (getPermission(target.getName()).equalsIgnoreCase("vip")){
                    vips.addEntry(target.getName());
                }else if (getPermission(target.getName()).equalsIgnoreCase("streamer")){
                    streamers.addEntry(target.getName());
                }else if (getPermission(target.getName()).equalsIgnoreCase("player")){
                    players.addEntry(target.getName());
                }
            }else {
                players.addEntry(target.getName());
            }
        }
    }



    public String getPermission(String name){
        File file = new File("plugins/PPGaming", "permissions.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        String permission = config.getString(name + ".permission");
        return permission;
    }

}
