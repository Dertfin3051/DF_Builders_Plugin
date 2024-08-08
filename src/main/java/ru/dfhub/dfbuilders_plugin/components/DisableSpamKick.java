package ru.dfhub.dfbuilders_plugin.components;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

/**
 * Отключения выкидывания за спам командами
 */
public class DisableSpamKick implements Listener {

    /**
     * Метод, который убирает кик за спам командами
     * Это нужно, чтобы игроков не выкидывало при вставке схематики
     * @param e Ивент кика игрока
     */
    @EventHandler(priority = EventPriority.HIGH)
    public void onKick(PlayerKickEvent e){
        if (e.getCause() == PlayerKickEvent.Cause.SPAM) {
            e.setCancelled(true);
        }
    }
}
