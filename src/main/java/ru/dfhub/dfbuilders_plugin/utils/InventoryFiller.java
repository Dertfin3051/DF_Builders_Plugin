package ru.dfhub.dfbuilders_plugin.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

/**
 * Класс, отвечающий за заполнение пустых слотов в меню
 */
public class InventoryFiller {
    private final ItemStack inventoryFiller;

    public InventoryFiller() {
        inventoryFiller = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta itemMeta = inventoryFiller.getItemMeta();
        itemMeta.displayName(Component.text(""));
        inventoryFiller.setItemMeta(itemMeta);
    }

    /**
     * @return Возвращает предмет, которым заполняется инвентарь
     */
    public ItemStack getInventoryFiller() {
        return inventoryFiller;
    }

    /**
     * Заполняет свободные слоты инвенторя
     * @param inventory Инвентарь, который нужно заполнить
     * @return Возвращает инвентарь с заполненными пустыми слотами
     */
    public Inventory getFilledInventory(Inventory inventory) {
        for (int i = 0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, this.inventoryFiller);
            }
        }
        return inventory;
    }
}
