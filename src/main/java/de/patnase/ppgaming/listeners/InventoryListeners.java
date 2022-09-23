package de.patnase.ppgaming.listeners;

import de.patnase.ppgaming.util.ItemBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.File;
import java.io.IOException;

public class InventoryListeners implements Listener {
    @EventHandler
    public void onInvClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        int amount;
        if (event.getCurrentItem() == null) return;
        if (event.getView().getTitle().equals("§aItem§6§lShop")){
            event.setCancelled(true);
            switch (event.getCurrentItem().getItemMeta().getLocalizedName()){
                case "dragon_egg":
                    amount = 25000000;
                    if (hasEnoughMoney(player.getName(), amount)){
                        removeMoney(player.getName(), amount);
                        player.getInventory().addItem(new ItemBuilder(Material.DRAGON_EGG).setDisplayname("§dDragon Egg").build());
                    }else {
                        player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cNot enough money");
                    }
                    break;
                case "spawner":
                    amount = 10000000;
                    if (hasEnoughMoney(player.getName(), amount)){
                        removeMoney(player.getName(), amount);
                        player.getInventory().addItem(new ItemBuilder(Material.SPAWNER).setDisplayname("§dSpawner").build());
                    }else {
                        player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cNot enough money");
                    }
                    break;
                case "beacon":
                    amount = 1000000;
                    if (hasEnoughMoney(player.getName(), amount)){
                        removeMoney(player.getName(), amount);
                        player.getInventory().addItem(new ItemBuilder(Material.BEACON).setDisplayname("§bBeacon").build());
                    }else {
                        player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cNot enough money");
                    }
                    break;
                case "end_portal_frame":
                    amount = 100000;
                    if (hasEnoughMoney(player.getName(), amount)){
                        removeMoney(player.getName(), amount);
                        player.getInventory().addItem(new ItemBuilder(Material.END_PORTAL_FRAME).setDisplayname("§bPortal Frame").build());
                    }else {
                        player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cNot enough money");
                    }
            }
        }else if (event.getView().getTitle().equals("§bJobs")){
            event.setCancelled(true);
            switch (event.getCurrentItem().getItemMeta().getLocalizedName()){
                case "timber":
                    setJob(player.getName(), "timber");
                    player.closeInventory();
                    break;
                case "miner":
                    setJob(player.getName(), "miner");
                    player.closeInventory();
                    break;
                case "farmer":
                    setJob(player.getName(), "farmer");
                    player.closeInventory();
                    break;
                case "butcher":
                    setJob(player.getName(), "butcher");
                    player.closeInventory();
                    break;
                case "fisher":
                    setJob(player.getName(), "fisher");
                    player.closeInventory();
                    break;
                case "cancel":
                    setJob(player.getName(), null);
                    player.closeInventory();
                    break;
            }
        }else if (event.getView().getTitle().equals("§6§lHomes")){
            event.setCancelled(true);
            switch (event.getCurrentItem().getItemMeta().getLocalizedName()){
                case "1":
                    if (getHome(player.getName(), 1) != null){
                        player.teleport(getHome(player.getName(), 1));
                    }
                    player.closeInventory();
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7]§f You have been teleported");
                    break;
                case "2":
                    if (getHome(player.getName(), 2) != null){
                        player.teleport(getHome(player.getName(), 2));
                    }
                    player.closeInventory();
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7]§f You have been teleported");
                    break;
                case "3":
                    if (getHome(player.getName(), 3) != null){
                        player.teleport(getHome(player.getName(), 3));
                    }
                    player.closeInventory();
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7]§f You have been teleported");
                    break;
                case "4":
                    if (getHome(player.getName(), 4) != null){
                        player.teleport(getHome(player.getName(), 4));
                    }
                    player.closeInventory();
                    player.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7]§f You have been teleported");
                    break;
            }
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

    public void setJob(String name, String job){
        File file = new File("plugins/PPGaming", "jobs.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        config.set(name + ".job", job);
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Location getHome(String player, Integer id){
        File file = new File("plugins/PPGaming", "homes.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        return (Location) config.get(player + ".home" + id + ".location");
    }
}
