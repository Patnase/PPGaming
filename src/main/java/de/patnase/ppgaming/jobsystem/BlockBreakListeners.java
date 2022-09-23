package de.patnase.ppgaming.jobsystem;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.io.File;
import java.io.IOException;

public class BlockBreakListeners implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Block block = event.getBlock();
        Material material = block.getType();
        Player player = event.getPlayer();
        switch (getJob(player.getName())){
            case "timber":
                if (material == Material.OAK_LOG){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.JUNGLE_LOG){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.ACACIA_LOG){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.SPRUCE_LOG){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.DARK_OAK_LOG){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.BIRCH_LOG){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.MANGROVE_LOG){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }
                break;
            case "miner":
                if (material == Material.COAL_ORE){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.COPPER_ORE){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.DEEPSLATE_COAL_ORE){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.DEEPSLATE_COPPER_ORE){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.DEEPSLATE_DIAMOND_ORE){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.DEEPSLATE_EMERALD_ORE){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.DEEPSLATE_GOLD_ORE){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.DEEPSLATE_IRON_ORE){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.DEEPSLATE_LAPIS_ORE){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.DEEPSLATE_REDSTONE_ORE){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.DIAMOND_ORE){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.EMERALD_ORE){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.GOLD_ORE){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.IRON_ORE){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.LAPIS_ORE){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.REDSTONE_ORE){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.NETHER_GOLD_ORE){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.NETHER_QUARTZ_ORE){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }
                break;
            case "farmer":
                if (material == Material.WHEAT){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.CARROTS){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.BEETROOTS){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }else if (material == Material.POTATOES){
                    addMoney(player.getName(), 25);
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] You just did your job and got §625§a$ §ffor your work");
                    addJobXp(player.getName(), getJob(player.getName()), 1);
                }
                break;
        }
    }

    public String getJob(String name){
        File file = new File("plugins/PPGaming", "jobs.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        String job = (String) config.get(name + ".job");
        return job;
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

    public void addJobXp(String name, String job, Integer xp){
        File file = new File("plugins/PPGaming", "jobs.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        Integer oldxp = (Integer) config.get(name + "." + job + ".xp", xp);
        Integer newxp = oldxp + xp;
        config.set(name + "." + job + ".level", newxp);
        try {
            config.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
