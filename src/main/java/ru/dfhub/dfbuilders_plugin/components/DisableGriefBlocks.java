package ru.dfhub.dfbuilders_plugin.components;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.TNTPrimeEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.List;

@Deprecated
public class DisableGriefBlocks implements Listener {

    @EventHandler
    public void onBlockPlaced(BlockPlaceEvent event) {

        List<Material> preventedBlocks = List.of(Material.TNT, Material.RESPAWN_ANCHOR, Material.END_CRYSTAL, Material.TNT_MINECART);

        if (!(preventedBlocks.contains(event.getBlockPlaced().getType()))) return;

        event.setCancelled(true);

        event.getPlayer().sendMessage(
                Component.text("Данный блок запрещен на сервере! ", TextColor.color(255, 0 ,0))
        );
    }

    @EventHandler
    public void onEntitySpawned(EntitySpawnEvent event) {
        if (event.getEntity().getType() == EntityType.END_CRYSTAL) {
            event.setCancelled(true);
        } else if (event.getEntity().getType() == EntityType.TNT_MINECART) {
            event.setCancelled(true);
        }
    }

}
