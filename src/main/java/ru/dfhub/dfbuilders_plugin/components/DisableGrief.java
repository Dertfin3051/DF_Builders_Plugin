package ru.dfhub.dfbuilders_plugin.components;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.net.http.WebSocket;
import java.util.List;

public class DisableGrief implements Listener {

    private static final List<Material> preventedItems = List.of(
            Material.TNT,
            Material.TNT_MINECART,
            Material.END_CRYSTAL,
            Material.RESPAWN_ANCHOR
    );

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        // TODO: Добавить обход ограничений по пермишену dfbuilders.anti-prevent.block
        for (Material el: preventedItems) {
            if (player.getInventory().contains(el)) {
                player.getInventory().remove(el);
                player.sendMessage(Component.text(
                        "Данный предмет запрещён на сервере!",
                        TextColor.color(255, 0, 0)
                ));
            }
        }
    }

    // TODO: Добавить полный список запрещенных предметов и обработать выкидывание их из инветаря.

}
