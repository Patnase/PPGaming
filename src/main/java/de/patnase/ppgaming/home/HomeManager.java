package de.patnase.ppgaming.home;

import de.patnase.ppgaming.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.io.File;
import java.io.IOException;

public class HomeManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = ((Player) sender).getPlayer();
            if (hasPermission(player.getName(), "admin")){
                Inventory homes = Bukkit.createInventory(null, 5*9, "§6§lHomes");
                //Deko
                homes.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(10, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(11, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(13, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(15, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(16, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(19, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(20, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(21, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(22, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(23, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(24, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(25, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(36, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(37, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(38, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(39, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(40, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(41, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(42, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(43, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(44, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                //Homes
                if (getHome(player.getName(), 1) != null){
                    homes.setItem(12, new ItemBuilder(Material.LIME_BED).setDisplayname(ChatColor.LIGHT_PURPLE + getHomeName(player.getName(), 1)).setLore("§2§l> §aTeleport").setLocalizedName("1").build());
                }else if (getHome(player.getName(), 1) == null){
                    homes.setItem(12, new ItemBuilder(Material.RED_BED).setDisplayname("§cNo home defined").build());
                }
                if (getHome(player.getName(), 2) != null){
                    homes.setItem(14, new ItemBuilder(Material.LIME_BED).setDisplayname(ChatColor.LIGHT_PURPLE + getHomeName(player.getName(), 2)).setLore("§2§l> §aTeleport").setLocalizedName("2").build());
                }else if (getHome(player.getName(), 2) == null){
                    homes.setItem(14, new ItemBuilder(Material.RED_BED).setDisplayname("§cNo home defined").build());
                }
                if (getHome(player.getName(), 3) != null){
                    homes.setItem(30, new ItemBuilder(Material.LIME_BED).setDisplayname(ChatColor.LIGHT_PURPLE + getHomeName(player.getName(), 3)).setLore("§2§l> §aTeleport").setLocalizedName("3").build());
                }else if (getHome(player.getName(), 3) == null){
                    homes.setItem(30, new ItemBuilder(Material.RED_BED).setDisplayname("§cNo home defined").build());
                }
                if (getHome(player.getName(), 4) != null){
                    homes.setItem(32, new ItemBuilder(Material.LIME_BED).setDisplayname(ChatColor.LIGHT_PURPLE + getHomeName(player.getName(), 4)).setLore("§2§l> §aTeleport").setLocalizedName("4").build());
                }else if (getHome(player.getName(), 4) == null){
                    homes.setItem(32, new ItemBuilder(Material.RED_BED).setDisplayname("§cNo home defined").build());
                }

                player.openInventory(homes);
            }else if (hasPermission(player.getName(), "mod")){
                Inventory homes = Bukkit.createInventory(null, 5*9, "§6§lHomes");
                //Deko
                homes.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(10, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(11, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(13, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(15, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(16, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(19, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(20, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(21, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(22, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(23, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(24, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(25, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(36, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(37, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(38, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(39, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(40, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(41, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(42, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(43, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(44, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                //Homes
                if (getHome(player.getName(), 1) != null){
                    homes.setItem(12, new ItemBuilder(Material.LIME_BED).setDisplayname(ChatColor.LIGHT_PURPLE + getHomeName(player.getName(), 1)).setLore("§2§l> §aTeleport").setLocalizedName("1").build());
                }else if (getHome(player.getName(), 1) == null){
                    homes.setItem(12, new ItemBuilder(Material.RED_BED).setDisplayname("§cNo home defined").build());
                }
                if (getHome(player.getName(), 2) != null){
                    homes.setItem(14, new ItemBuilder(Material.LIME_BED).setDisplayname(ChatColor.LIGHT_PURPLE + getHomeName(player.getName(), 2)).setLore("§2§l> §aTeleport").setLocalizedName("2").build());
                }else if (getHome(player.getName(), 2) == null){
                    homes.setItem(14, new ItemBuilder(Material.RED_BED).setDisplayname("§cNo home defined").build());
                }
                if (getHome(player.getName(), 3) != null){
                    homes.setItem(30, new ItemBuilder(Material.LIME_BED).setDisplayname(ChatColor.LIGHT_PURPLE + getHomeName(player.getName(), 3)).setLore("§2§l> §aTeleport").setLocalizedName("3").build());
                }else if (getHome(player.getName(), 3) == null){
                    homes.setItem(30, new ItemBuilder(Material.RED_BED).setDisplayname("§cNo home defined").build());
                }
                if (getHome(player.getName(), 4) != null){
                    homes.setItem(32, new ItemBuilder(Material.LIME_BED).setDisplayname(ChatColor.LIGHT_PURPLE + getHomeName(player.getName(), 4)).setLore("§2§l> §aTeleport").setLocalizedName("4").build());
                }else if (getHome(player.getName(), 4) == null){
                    homes.setItem(32, new ItemBuilder(Material.RED_BED).setDisplayname("§cNo home defined").build());
                }

                player.openInventory(homes);
            }else if (hasPermission(player.getName(), "vip")){
                Inventory homes = Bukkit.createInventory(null, 5*9, "§6§lHomes");
                //Deko
                homes.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(10, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(11, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(13, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(15, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(16, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(19, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(20, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(21, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(22, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(23, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(24, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(25, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(36, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(37, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(38, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(39, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(40, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(41, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(42, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(43, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                homes.setItem(44, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
                //Homes
                if (getHome(player.getName(), 1) != null){
                    homes.setItem(12, new ItemBuilder(Material.LIME_BED).setDisplayname(ChatColor.LIGHT_PURPLE + getHomeName(player.getName(), 1)).setLore("§2§l> §aTeleport").setLocalizedName("1").build());
                }else if (getHome(player.getName(), 1) == null){
                    homes.setItem(12, new ItemBuilder(Material.RED_BED).setDisplayname("§cNo home defined").build());
                }
                if (getHome(player.getName(), 2) != null){
                    homes.setItem(14, new ItemBuilder(Material.LIME_BED).setDisplayname(ChatColor.LIGHT_PURPLE + getHomeName(player.getName(), 2)).setLore("§2§l> §aTeleport").setLocalizedName("2").build());
                }else if (getHome(player.getName(), 2) == null){
                    homes.setItem(14, new ItemBuilder(Material.RED_BED).setDisplayname("§cNo home defined").build());
                }
                if (getHome(player.getName(), 3) != null){
                    homes.setItem(30, new ItemBuilder(Material.LIME_BED).setDisplayname(ChatColor.LIGHT_PURPLE + getHomeName(player.getName(), 3)).setLore("§2§l> §aTeleport").setLocalizedName("3").build());
                }else if (getHome(player.getName(), 3) == null){
                    homes.setItem(30, new ItemBuilder(Material.RED_BED).setDisplayname("§cNo home defined").build());
                }
                if (getHome(player.getName(), 4) != null){
                    homes.setItem(32, new ItemBuilder(Material.LIME_BED).setDisplayname(ChatColor.LIGHT_PURPLE + getHomeName(player.getName(), 4)).setLore("§2§l> §aTeleport").setLocalizedName("4").build());
                }else if (getHome(player.getName(), 4) == null){
                    homes.setItem(32, new ItemBuilder(Material.RED_BED).setDisplayname("§cNo home defined").build());
                }

                player.openInventory(homes);
            }else {
                player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cNo permission");
            }
        }else {
            sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cThis command has to be executed by a player");
        }
        return false;
    }

    public void setHome(String player, Integer id, String name, Location location){
        File file = new File("plugins/PPGaming", "homes.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        config.set(player + ".home" + id + "." + name, location);
        try {
            config.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getHomeName(String player, Integer id){
        File file = new File("plugins/PPGaming", "homes.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        return (String) config.get(player + ".home" + id + ".name");
    }

    public Location getHome(String player, Integer id){
        File file = new File("plugins/PPGaming", "homes.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        return (Location) config.get(player + ".home" + id + ".location");
    }

    public void delHome(String player, Integer id, String name){
        File file = new File("plugins/PPGaming", "homes.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        config.set(player + ".home" + id + ".location", null);
        config.set(player + ".home" + id + ".name", null);
        try {
            config.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean hasPermission(String name, String permission){
        File file = new File("plugins/PPgaming", "permissions.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        String actualpermission = config.getString(name + ".permission", permission);
        return actualpermission.equals(permission);
    }
}
