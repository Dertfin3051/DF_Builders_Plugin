package ru.dfhub.dfbuilders_plugin.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;

public class InventoryFiller {
    private ItemStack inventoryFiller;

    public InventoryFiller() {
        inventoryFiller = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta itemMeta = inventoryFiller.getItemMeta();
        itemMeta.displayName(Component.text(""));
        inventoryFiller.setItemMeta(itemMeta);
    }

    public ItemStack getInventoryFiller() {
        return inventoryFiller;
    }

    public Inventory getFilledInventory(Inventory inventory) {
        for (int i = 0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, this.inventoryFiller);
            }
        }
        return inventory;
    }
}
