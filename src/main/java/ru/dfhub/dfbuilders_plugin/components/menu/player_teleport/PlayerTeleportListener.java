package ru.dfhub.dfbuilders_plugin.components.menu.player_teleport;

import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import ru.dfhub.dfbuilders_plugin.DFBuilders_Plugin;

public class PlayerTeleportListener implements Listener {

    private static final String MENU_METADATA = "openedPlayerTeleportMenu";

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (!(player.hasMetadata(MENU_METADATA))) return;
        if (player.hasMetadata("openedMenu")) return;

        event.setCancelled(true);

        String targetPlayerName = ((TextComponent) event.getCurrentItem().getItemMeta().displayName()).content();
        Player targetPlayer = Bukkit.getPlayer(targetPlayerName);

        if (targetPlayer != null) {
            teleportToPlayer(player, targetPlayer);
        }

    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if (player.hasMetadata(MENU_METADATA)) {
            player.removeMetadata(MENU_METADATA, DFBuilders_Plugin.getInstance());
        }
    }

    /**
     * Телепортирует одного игрока к другому
     * @param player Кого телепортировать
     * @param targetPlayer К кому телепортировать
     */
    private void teleportToPlayer(Player player, Player targetPlayer) {
        player.teleport(targetPlayer.getLocation());
    }
}
