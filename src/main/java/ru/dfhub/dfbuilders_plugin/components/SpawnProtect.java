package ru.dfhub.dfbuilders_plugin.components;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class SpawnProtect implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        int x = event.getBlock().getX();
        int z = event.getBlock().getZ();
        if (!(isOnSpawn(x,z))) return;

        if (!(event.getPlayer().hasPermission("dfbuilders.spawn"))) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(
                    Component.text("Вы не можете изменять пределы спавна! Обратитесь к администратору", TextColor.color(255, 0, 0))
            );
        }
    }

    @EventHandler
    public void onPlaceBreak(BlockPlaceEvent event) {
        int x = event.getBlock().getX();
        int z = event.getBlock().getZ();
        if (!(isOnSpawn(x,z))) return;

        if (!(event.getPlayer().hasPermission("dfbuilders.spawn"))) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(
                    Component.text("Вы не можете изменять пределы спавна! Обратитесь к администратору", TextColor.color(255, 0, 0))
            );
        }
    }

    /*
    Пределы спавна - 10 блоков в каждую сторону от нуля
     */
    private boolean isOnSpawn(int x, int z) {
        return x >= -10 && x <= 10 && z >= -10 && z <= 10;
    }
}
