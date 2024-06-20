package ru.dfhub.dfbuilders_plugin.components.menu;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;
import ru.dfhub.dfbuilders_plugin.DFBuilders_Plugin;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        MenuInventory menu = new MenuInventory();

        player.setMetadata("openedMenu", new FixedMetadataValue(DFBuilders_Plugin.getInstance(), true));
        player.openInventory(menu.getInventory());


        return true;
    }
}
