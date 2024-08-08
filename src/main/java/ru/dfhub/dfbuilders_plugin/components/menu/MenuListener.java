package ru.dfhub.dfbuilders_plugin.components.menu;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import ru.dfhub.dfbuilders_plugin.DFBuilders_Plugin;

/**
 * Основная логика `/menu`
 */
public class MenuListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (!(player.hasMetadata("openedMenu"))) return;

        event.setCancelled(true);

        switch (event.getSlot()) {
            case 11:
                clear(player);
                break;
            case 13:
                spawn(player);
                break;
            case 15:
                playertp(player);
                break;
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if (player.hasMetadata("openedMenu")) {
            player.removeMetadata("openedMenu", DFBuilders_Plugin.getInstance());
        }
    }

    private static void clear(Player player) {
        player.getInventory().clear();
    }

    private static void spawn(Player player) {
        player.teleport(new Location(Bukkit.getWorld("world"),0, -60, 0));
    }

    private static void playertp(Player player) {
        player.closeInventory();
        player.chat("/playertp");
    }
}
