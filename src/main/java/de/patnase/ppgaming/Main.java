package de.patnase.ppgaming;

import de.patnase.ppgaming.commands.*;
import de.patnase.ppgaming.economy.EconomySystem;
import de.patnase.ppgaming.home.DeleteHomeCommand;
import de.patnase.ppgaming.home.HomeManager;
import de.patnase.ppgaming.home.SetHomeCommand;
import de.patnase.ppgaming.jobsystem.FishingListener;
import de.patnase.ppgaming.jobsystem.JobManager;
import de.patnase.ppgaming.jobsystem.BlockBreakListeners;
import de.patnase.ppgaming.jobsystem.MobKillListeners;
import de.patnase.ppgaming.listeners.ConnectionListeners;
import de.patnase.ppgaming.listeners.FirstJoinListener;
import de.patnase.ppgaming.listeners.InventoryListeners;
import de.patnase.ppgaming.modCommands.KickCommand;
import de.patnase.ppgaming.permission.PermissionManager;
import de.patnase.ppgaming.scoreboard.TabListManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main plugin;

    private static Main instance;

    private TabListManager tabListManager;

    @Override
    public void onLoad(){
        instance = this;
    }

    @Override
    public void onEnable() {
        getCommand("money").setExecutor(new EconomySystem());
        getCommand("shop").setExecutor(new ShopCommand());
        getCommand("pay").setExecutor(new PayCommand());
        getCommand("job").setExecutor(new JobManager());
        getCommand("permission").setExecutor(new PermissionManager());
        getCommand("jobs").setExecutor(new JobMenuCommand());
        getCommand("ping").setExecutor(new PingCommand());
        getCommand("invsee").setExecutor(new InventorySeeCommand());
        getCommand("nick").setExecutor(new NickCommand());
        //HomeCommands
        getCommand("sethome").setExecutor(new SetHomeCommand());
        getCommand("delhome").setExecutor(new DeleteHomeCommand());
        getCommand("homes").setExecutor(new HomeManager());
        //ModCommands
        getCommand("kick").setExecutor(new KickCommand());

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ConnectionListeners(), this);
        pluginManager.registerEvents(new InventoryListeners(), this);
        pluginManager.registerEvents(new BlockBreakListeners(), this);
        pluginManager.registerEvents(new FishingListener(), this);
        pluginManager.registerEvents(new MobKillListeners(), this);
        pluginManager.registerEvents(new FirstJoinListener(), this);

        tabListManager = new TabListManager();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return instance;
    }

    public static Main getPlugin() {
        return plugin;
    }

    public TabListManager getTabListManager() {
        return tabListManager;
    }
}