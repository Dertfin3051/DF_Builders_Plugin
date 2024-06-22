package ru.dfhub.dfbuilders_plugin.components.menu.player_teleport;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

public class PlayerTeleportInventory {
    private Inventory inventory;

    public PlayerTeleportInventory() {
        inventory = Bukkit.createInventory(null, 27, "Телепортироваться к игроку...");
    }

    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Отрисовывает в инвентаре головы игроков
     * @param onlinePlayers Список игроков в сети
     */
    public void render(List<Player> onlinePlayers) {
        inventory.clear(); // Очистка перед повторным заполнением
        for (Player player : onlinePlayers) {
            ItemStack playerHead = getPlayerHead(player);
            inventory.addItem(playerHead);
        }
    }

    /**
     * Создает голову игрока
     * @param player Игрок, голову которого нужно получить
     * @return Голова указанного игрока
     */
    private ItemStack getPlayerHead(Player player) {
        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta playerHeadMeta = (SkullMeta) playerHead.getItemMeta();
        playerHeadMeta.displayName(
                player.displayName().asComponent().style(Style.style(TextColor.fromHexString("#C913FE"), TextDecoration.BOLD))
        );
        playerHeadMeta.setOwningPlayer(player);
        playerHead.setItemMeta(playerHeadMeta);

        return playerHead;
    }
}
