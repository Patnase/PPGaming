package de.patnase.ppgaming.commands;

import de.patnase.ppgaming.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.io.File;

public class JobMenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = ((Player) sender).getPlayer();
            Inventory jobs = Bukkit.createInventory(null, 5*9, "§bJobs");
            //deko
            jobs.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(19, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(20, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(21, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(22, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(23, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(24, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(25, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(36, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(37, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(38, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(39, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(40, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(41, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(42, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(43, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(44, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            jobs.setItem(15, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            //leveling
            if (getJob(player.getName()) != null){
                if (getJob(player.getName()).equalsIgnoreCase("timber")){
                    jobs.setItem(28, new ItemBuilder(Material.IRON_AXE).setDisplayname("Current Job: §aTimber").build());
                }else if (getJob(player.getName()).equalsIgnoreCase("miner")){
                    jobs.setItem(28, new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("Current Job: §6Miner").build());
                }else if (getJob(player.getName()).equalsIgnoreCase("farmer")){
                    jobs.setItem(28, new ItemBuilder(Material.IRON_HOE).setDisplayname("Curent Job: §2Farmer").build());
                }else if (getJob(player.getName()).equalsIgnoreCase("butcher")){
                    jobs.setItem(28, new ItemBuilder(Material.STONE_SWORD).setDisplayname("Current Job: §5Butcher").build());
                }else if (getJob(player.getName()).equalsIgnoreCase("fisher")) {
                    jobs.setItem(28, new ItemBuilder(Material.FISHING_ROD).setDisplayname("Current Job: §9Fisher").build());
                }
            }else {
                jobs.setItem(28, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayname("§cNo Job").build());
            }

            if (getJobLevel(player.getName(), getJob(player.getName())) != null && getJobXp(player.getName(), getJob(player.getName())) != null) {
                if (getJobLevel(player.getName(), getJob(player.getName())) == 0) {
                    if (getJobXp(player.getName(), getJob(player.getName())) >= 0 && getJobXp(player.getName(), getJob(player.getName())) < 20) {
                        jobs.setItem(30, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(31, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(32, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(33, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(34, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                    } else if (getJobXp(player.getName(), getJob(player.getName())) == null) {
                        jobs.setItem(30, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(31, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(32, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(33, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(34, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                    } else if (getJobXp(player.getName(), getJob(player.getName())) >= 20 && getJobXp(player.getName(), getJob(player.getName())) < 40) {
                        jobs.setItem(30, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(31, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(32, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(33, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(34, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                    } else if (getJobXp(player.getName(), getJob(player.getName())) >= 40 && getJobXp(player.getName(), getJob(player.getName())) < 60) {
                        jobs.setItem(30, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(31, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(32, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(33, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(34, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                    } else if (getJobXp(player.getName(), getJob(player.getName())) >= 60 && getJobXp(player.getName(), getJob(player.getName())) < 80) {
                        jobs.setItem(30, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(31, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(32, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(33, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(34, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                    } else if (getJobXp(player.getName(), getJob(player.getName())) >= 80 && getJobXp(player.getName(), getJob(player.getName())) < 100) {
                        jobs.setItem(30, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(31, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(32, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(33, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                        jobs.setItem(34, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").build());
                    } else if (getJobXp(player.getName(), getJob(player.getName())) >= 100) {
                        jobs.setItem(30, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: 100/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(31, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: 100/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(32, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: 100/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(33, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: 100/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(34, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: 100/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                    }
                } else {
                    if (getJobXp(player.getName(), getJob(player.getName())) >= 0 && getJobXp(player.getName(), getJob(player.getName())) < 20) {
                        jobs.setItem(30, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(31, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(32, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(33, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(34, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                    } else if (getJobXp(player.getName(), getJob(player.getName())) == null) {
                        jobs.setItem(30, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(31, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(32, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(33, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(34, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                    } else if (getJobXp(player.getName(), getJob(player.getName())) >= 20 && getJobXp(player.getName(), getJob(player.getName())) < 40) {
                        jobs.setItem(30, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(31, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(32, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(33, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(34, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                    } else if (getJobXp(player.getName(), getJob(player.getName())) >= 40 && getJobXp(player.getName(), getJob(player.getName())) < 60) {
                        jobs.setItem(30, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(31, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(32, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(33, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(34, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                    } else if (getJobXp(player.getName(), getJob(player.getName())) >= 60 && getJobXp(player.getName(), getJob(player.getName())) < 80) {
                        jobs.setItem(30, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(31, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(32, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(33, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(34, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                    } else if (getJobXp(player.getName(), getJob(player.getName())) >= 80 && getJobXp(player.getName(), getJob(player.getName())) < 100) {
                        jobs.setItem(30, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(31, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(32, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(33, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(34, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§7XP: " + getJobXp(player.getName(), getJob(player.getName())) + "/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                    } else if (getJobXp(player.getName(), getJob(player.getName())) >= 100) {
                        jobs.setItem(30, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: 100/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(31, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: 100/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(32, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: 100/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(33, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: 100/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                        jobs.setItem(34, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7XP: 100/§a100").setLore("§5Level: §d" + getJobLevel(player.getName(), getJob(player.getName()))).build());
                    }
                }
            }
            //jobs
            jobs.setItem(10, new ItemBuilder(Material.IRON_AXE).setDisplayname("§aTimber").setLocalizedName("timber").build());
            jobs.setItem(11, new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§6Miner").setLocalizedName("miner").build());
            jobs.setItem(12, new ItemBuilder(Material.IRON_HOE).setDisplayname("§2Farmer").setLocalizedName("farmer").build());
            jobs.setItem(13, new ItemBuilder(Material.STONE_SWORD).setDisplayname("§5Butcher").setLocalizedName("butcher").build());
            jobs.setItem(14, new ItemBuilder(Material.FISHING_ROD).setDisplayname("§9Fisher").setLocalizedName("fisher").build());

            //util
            jobs.setItem(16, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayname("§cCancel current job").setLocalizedName("cancel").build());

            player.openInventory(jobs);
        }else {
            sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7]§c This command has to be executed by a player");
        }
        return false;
    }

    public String getJob(String name){
        File file = new File("plugins/PPGaming", "jobs.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        String job = (String) config.get(name + ".job");
        return job;
    }

    public Integer getJobXp(String name, String job){
        File file = new File("plugins/PPGaming", "jobs.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        Integer jobxp;
        if (config.get(name + "." + job + ".xp") != null){
            jobxp = (Integer) config.get(name + "." + job + ".xp");
        }else {
            jobxp = 0;
        }
        return jobxp;
    }

    public Integer getJobLevel(String name, String job){
        File file = new File("plugins/PPGaming", "jobs.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        Integer JobLevel = config.getInt(name + "." + job + ".lvl");
        return JobLevel;
    }
}
