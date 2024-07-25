package ru.dfhub.dfbuilders_plugin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ru.dfhub.dfbuilders_plugin.components.*;
import ru.dfhub.dfbuilders_plugin.components.menu.MenuCommand;
import ru.dfhub.dfbuilders_plugin.components.menu.MenuListener;
import ru.dfhub.dfbuilders_plugin.components.menu.player_teleport.PlayerTeleportCommand;
import ru.dfhub.dfbuilders_plugin.components.menu.player_teleport.PlayerTeleportListener;
import ru.dfhub.dfbuilders_plugin.utils.logger.Logger;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public final class DFBuilders_Plugin extends JavaPlugin {

    private static DFBuilders_Plugin instance;

    // TODO Добавить в папку DFBuilders_Plugin папку logs с логами о заходе/выходе и о взятии запрещённых предметов
    // TODO Перенести возможные MOTD в DFBuilders_Plugin/config.json

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        //saveDefaultConfig();

        getCommand("menu").setExecutor(new MenuCommand());
        getCommand("playertp").setExecutor(new PlayerTeleportCommand());

        List<Listener> listeners = List.of(
           new NewPlayerBlockHandler(),
           new PlayerJoinQuitMessage(),
           new SpawnProtect(),
           new Chat(),
           new MotdListener(),
           new DisableOtherWorlds(),
           new DisableAdvs(),
           new MenuListener(),
           new PlayerTeleportListener(),
           new DisableGrief()
        );

        for (Listener listener: listeners) {
            getServer().getPluginManager().registerEvents(listener, this);
        }

        try {
            Logger.init();
        } catch (IOException e) {
            Bukkit.getLogger().log(Level.WARNING, "THERE IS ERROR OCCURRED IN LOGGER INIT");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public  static DFBuilders_Plugin getInstance() {
        return instance;
    }
}
