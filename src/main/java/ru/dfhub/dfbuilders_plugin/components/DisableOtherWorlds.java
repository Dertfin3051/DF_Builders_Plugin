package ru.dfhub.dfbuilders_plugin.components;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class DisableOtherWorlds implements Listener {

    @EventHandler
    public void onPlayerChangeWorld(PlayerTeleportEvent event) {
        if (event.getCause() == PlayerTeleportEvent.TeleportCause.END_PORTAL) {
            event.getPlayer().sendMessage(
                    Component.text("На этом сервере отключен енд", TextColor.color(255, 0, 0))
            );
            event.setCancelled(true);
        } else if (event.getCause() == PlayerTeleportEvent.TeleportCause.NETHER_PORTAL) {
            event.getPlayer().sendMessage(
                    Component.text("На этом сервере отключен ад", TextColor.color(255, 0, 0))
            );
            event.setCancelled(true);
        }
    }
}
