package ru.dfhub.dfbuilders_plugin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import ru.dfhub.dfbuilders_plugin.components.*;
import ru.dfhub.dfbuilders_plugin.components.DisableSpamKick;
import ru.dfhub.dfbuilders_plugin.components.menu.MenuCommand;
import ru.dfhub.dfbuilders_plugin.components.menu.MenuListener;
import ru.dfhub.dfbuilders_plugin.components.menu.player_teleport.PlayerTeleportCommand;
import ru.dfhub.dfbuilders_plugin.components.menu.player_teleport.PlayerTeleportListener;
import ru.dfhub.dfbuilders_plugin.utils.logger.Logger;
import ru.dfhub.dfbuilders_plugin.utils.logger.LoggerType;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

/**
 * Основной класс
 */
public final class DFBuilders_Plugin extends JavaPlugin {

    private static DFBuilders_Plugin instance;

    /**
     * Метод, с логикой включения плагина
     */
    @Override
    public void onEnable() {
        instance = this;

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
           new DisableGrief(),
           new DisableSpamKick()
        ); // Список всех ивентов

        for (Listener listener: listeners) {
            getServer().getPluginManager().registerEvents(listener, this);
        } // Включение ивентов из listeners

        try {
            Logger.init();
        } // Инициализация логов
        catch (IOException e) {
            Bukkit.getLogger().log(Level.WARNING, "THERE IS ERROR OCCURRED IN LOGGER INIT");
            Bukkit.getLogger().log(Level.WARNING, e.getMessage());
        }

        Logger.log(LoggerType.SESSIONS, "Server started!");
        Logger.log(LoggerType.ALERTS, "Server started!");

    }

    /**
     * Метод, с логикой выключения плагина
     */
    @Override
    public void onDisable() {
        Logger.log(LoggerType.SESSIONS, "Server disabled!");
        Logger.log(LoggerType.ALERTS, "Server disabled!");
    }

    public  static DFBuilders_Plugin getInstance() {
        return instance;
    }

}
