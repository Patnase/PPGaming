package de.patnase.ppgaming.commands;

import de.patnase.ppgaming.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ShopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = ((Player) sender).getPlayer();
            Inventory shop = Bukkit.createInventory(null, 5*9, "§aItem§6§lShop");

            shop.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(19, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(20, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(21, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(22, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(23, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(24, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(25, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(36, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(37, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(38, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(39, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(40, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(41, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(42, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(43, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            shop.setItem(44, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
            //Items
            shop.setItem(10, new ItemBuilder(Material.DRAGON_EGG).setDisplayname("§dDragon Egg §f-- §625.000.000§2$").setLocalizedName("dragon_egg").build());
            shop.setItem(11, new ItemBuilder(Material.SPAWNER).setDisplayname("§dSpawner §f-- §610.000.000§2$").setLocalizedName("spawner").build());
            shop.setItem(12, new ItemBuilder(Material.BEACON).setDisplayname("§bBeacon §f-- §61.000.000§2$").setLocalizedName("beacon").build());
            shop.setItem(13, new ItemBuilder(Material.END_PORTAL_FRAME).setDisplayname("§bPortal Frame §f-- §6100.000§2$").setLocalizedName("end_portal_frame").build());



            player.openInventory(shop);
        }else {
            sender.sendMessage("§7[§6§lP§c§lP§3§lG§baming§7] §cThis command has to be executed by a player");
        }
        return false;
    }
}
