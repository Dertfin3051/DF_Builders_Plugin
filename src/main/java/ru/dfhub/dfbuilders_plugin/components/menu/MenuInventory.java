package ru.dfhub.dfbuilders_plugin.components.menu;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.dfhub.dfbuilders_plugin.utils.InventoryFiller;

public class MenuInventory {
    private Inventory inventory;

    public MenuInventory(){
        inventory = Bukkit.createInventory(null, 27, "Меню");

        ItemStack clearButton = new ItemStack(Material.LAVA_BUCKET, 1);
        ItemMeta clearButtonMeta = clearButton.getItemMeta();
        clearButtonMeta.displayName(
                Component.text("Очистить инвентарь", TextColor.color(0, 255, 0), TextDecoration.BOLD)
        );
        clearButton.setItemMeta(clearButtonMeta);
        inventory.setItem(11, clearButton);

        ItemStack spawnTeleport = new ItemStack(Material.ENDER_EYE, 1);
        ItemMeta spawnTeleportMeta = spawnTeleport.getItemMeta();
        spawnTeleportMeta.displayName(
                Component.text("Телепорт на спавн", TextColor.color(0, 255, 0), TextDecoration.BOLD)
        );
        spawnTeleport.setItemMeta(spawnTeleportMeta);
        inventory.setItem(13, spawnTeleport);

        /*
        ItemStack soon = new ItemStack(Material.GRAY_STAINED_GLASS, 1);
        ItemMeta soonMeta = soon.getItemMeta();
        soonMeta.displayName(
                Component.text("Скоро...", TextColor.color(255, 255, 0), TextDecoration.BOLD)
        );
        soon.setItemMeta(soonMeta);
        inventory.setItem(15, soon);
        */


        ItemStack teleportToPlayer = new ItemStack(Material.ENDER_PEARL, 1);
        ItemMeta teleportToPlayerMeta = spawnTeleport.getItemMeta();
        teleportToPlayerMeta.displayName(
                Component.text("Телепорт к другому игроку", TextColor.color(0, 255, 0), TextDecoration.BOLD)
        );
        teleportToPlayer.setItemMeta(teleportToPlayerMeta);
        inventory.setItem(15, teleportToPlayer);


        InventoryFiller iv = new InventoryFiller();
        inventory = iv.getFilledInventory(inventory);
    }

    public Inventory getInventory() {
        return inventory;
    }
}
