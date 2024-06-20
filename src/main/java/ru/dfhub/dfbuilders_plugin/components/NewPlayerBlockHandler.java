package ru.dfhub.dfbuilders_plugin.components;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.net.http.WebSocket;

public class NewPlayerBlockHandler implements Listener {

    @EventHandler
    public void onBlockPlaced(BlockPlaceEvent event) {
        Player player = event.getPlayer();

        if (!(player.hasPermission("dfbuilders.level.2"))) {
            event.setCancelled(true);
            player.sendMessage(
                    Component.text(
                            "Вы не можете строить на данном сервере! Обратитесь к админу за получением доступа",
                            TextColor.color(255, 0, 0)
                    )
            );
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if (!(player.hasPermission("dfbuilders.level.2"))) {
            event.setCancelled(true);
            player.sendMessage(
                    Component.text(
                            "Вы не можете строить на данном сервере! Обратитесь к админу за получением доступа",
                            TextColor.color(255, 0, 0)
                    )
            );
        }
    }
}
