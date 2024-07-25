package ru.dfhub.dfbuilders_plugin;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ru.dfhub.dfbuilders_plugin.components.*;
import ru.dfhub.dfbuilders_plugin.components.menu.MenuCommand;
import ru.dfhub.dfbuilders_plugin.components.menu.MenuListener;
import ru.dfhub.dfbuilders_plugin.components.menu.player_teleport.PlayerTeleportCommand;
import ru.dfhub.dfbuilders_plugin.components.menu.player_teleport.PlayerTeleportListener;

import java.util.List;

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
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public  static DFBuilders_Plugin getInstance() {
        return instance;
    }
}
