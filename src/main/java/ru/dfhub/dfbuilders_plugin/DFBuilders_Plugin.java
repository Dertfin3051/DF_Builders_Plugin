package ru.dfhub.dfbuilders_plugin;

import org.bukkit.plugin.java.JavaPlugin;
import ru.dfhub.dfbuilders_plugin.components.*;
import ru.dfhub.dfbuilders_plugin.components.*;
import ru.dfhub.dfbuilders_plugin.components.menu.MenuCommand;
import ru.dfhub.dfbuilders_plugin.components.menu.MenuListener;

public final class DFBuilders_Plugin extends JavaPlugin {

    private static DFBuilders_Plugin instance;

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        saveDefaultConfig();

        getCommand("menu").setExecutor(new MenuCommand());

        getServer().getPluginManager().registerEvents(new NewPlayerBlockHandler(), this);
        getServer().getPluginManager().registerEvents(new MotdListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinQuitMessage(), this);
        getServer().getPluginManager().registerEvents(new DisableOtherWorlds(), this);
        getServer().getPluginManager().registerEvents(new DisableAdvs(), this);
        getServer().getPluginManager().registerEvents(new DisableGriefBlocks(), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public  static DFBuilders_Plugin getInstance() {
        return instance;
    }
}
