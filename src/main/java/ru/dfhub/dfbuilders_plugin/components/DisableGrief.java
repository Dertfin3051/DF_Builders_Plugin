package ru.dfhub.dfbuilders_plugin.components;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import java.net.http.WebSocket;
import java.util.List;

public class DisableGrief implements Listener {

    private static final List<Material> preventedItems = List.of(
            Material.TNT,
            Material.TNT_MINECART,
            Material.END_CRYSTAL,
            Material.RESPAWN_ANCHOR,
            Material.FLINT_AND_STEEL
    );

    private static final Component PREVENTED_ITEM_MESSAGE = Component.text(
            "Данный предмет запрещён на сервере!",
            TextColor.color(255, 0, 0)
    );

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        // TODO: Добавить обход ограничений по пермишену dfbuilders.anti-prevent.block
        for (Material el: preventedItems) {
            if (player.getInventory().contains(el)) {
                e.setCancelled(true);
                player.getInventory().remove(el);
                player.sendMessage(PREVENTED_ITEM_MESSAGE);
            }
        }
    }

    @EventHandler
    public void onDropItem(PlayerDropItemEvent e) {
        Player player = (Player) e.getPlayer();

        for (Material el: preventedItems) {
            if (e.getItemDrop().getItemStack().getType() == el) {
                e.setCancelled(true);
                player.sendMessage(PREVENTED_ITEM_MESSAGE);
            }
        }
    }

    // TODO: Добавить полный список запрещенных предметов и обработать выкидывание их из инветаря.
    // TODO: Зарегистировать этот класс в плагине
}
