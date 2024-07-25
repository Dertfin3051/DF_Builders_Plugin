package ru.dfhub.dfbuilders_plugin.components;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import ru.dfhub.dfbuilders_plugin.utils.logger.Logger;
import ru.dfhub.dfbuilders_plugin.utils.logger.LoggerType;

import java.net.http.WebSocket;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DisableGrief implements Listener {

    private static final List<Material> preventedItems = List.of(
            Material.TNT,
            Material.TNT_MINECART,
            Material.END_CRYSTAL,
            Material.RESPAWN_ANCHOR,
            Material.FLINT_AND_STEEL,
            Material.OAK_BOAT, Material.OAK_CHEST_BOAT,
            Material.SPRUCE_BOAT, Material.SPRUCE_CHEST_BOAT,
            Material.BIRCH_BOAT, Material.BIRCH_CHEST_BOAT,
            Material.JUNGLE_BOAT, Material.JUNGLE_CHEST_BOAT,
            Material.ACACIA_BOAT, Material.ACACIA_CHEST_BOAT,
            Material.DARK_OAK_BOAT, Material.DARK_OAK_CHEST_BOAT,
            Material.MANGROVE_BOAT, Material.MANGROVE_CHEST_BOAT,
            Material.CHERRY_BOAT, Material.CHERRY_CHEST_BOAT,
            Material.BAMBOO_RAFT, Material.BAMBOO_CHEST_RAFT
    );


    private static final Component PREVENTED_ITEM_MESSAGE = Component.text(
            "Данный предмет запрещён на сервере!",
            TextColor.color(255, 0, 0)
    );

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (player.hasPermission("dfbuiders.anti-prevent")) return;

        for (Material el: preventedItems) {
            if (player.getInventory().contains(el)) {
                e.setCancelled(true);
                player.getInventory().remove(el);
                player.sendMessage(PREVENTED_ITEM_MESSAGE);
                log(player, el);
            }
        }
    }

    @EventHandler
    public void onDropItem(PlayerDropItemEvent e) {
        Player player = (Player) e.getPlayer();

        if (player.hasPermission("dfbuiders.anti-prevent")) return;

        for (Material el: preventedItems) {
            if (e.getItemDrop().getItemStack().getType() == el) {
                e.setCancelled(true);
                player.getInventory().remove(el);
                player.sendMessage(PREVENTED_ITEM_MESSAGE);
                log(player, el);
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = (Player) e.getPlayer();

        if (player.hasPermission("dfbuiders.anti-prevent")) return;

        for (Material el: preventedItems) {
            if (e.getPlayer().getInventory().contains(el)) {
                e.setCancelled(true);
                e.getPlayer().getInventory().remove(el);
                player.sendMessage(PREVENTED_ITEM_MESSAGE);
                log(player, el);
            }
        }
    }

    @EventHandler
    public void onItemHold(InventoryMoveItemEvent e) {
        Player player = (Player) e.getDestination().getViewers().getFirst();

        for (Material el: preventedItems) {
            if (e.getItem().getType() == el) {
                e.setCancelled(true);
                player.sendMessage(PREVENTED_ITEM_MESSAGE);
                log(player, el);
            }
        }
    }

    private static void log(Player player, Material material) {
        String message = "%s interact with %s".formatted(
                ((TextComponent) player.displayName()).content(),
                material.toString()
        );
        Logger.log(LoggerType.ALERTS, message);
    }

    // TODO: Добавить полный список запрещенных предметов и обработать выкидывание их из инветаря.
    // TODO: Зарегистировать этот класс в плагине
}
