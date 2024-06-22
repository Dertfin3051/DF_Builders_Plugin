package ru.dfhub.dfbuilders_plugin.components.menu.player_teleport;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;
import ru.dfhub.dfbuilders_plugin.DFBuilders_Plugin;

import java.util.ArrayList;
import java.util.List;

public class PlayerTeleportCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        PlayerTeleportInventory inventory = new PlayerTeleportInventory();

        List<Player> onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
        inventory.render(onlinePlayers);

        player.openInventory(inventory.getInventory());
        player.setMetadata("openedPlayerTeleportMenu", new FixedMetadataValue(DFBuilders_Plugin.getInstance(), true));

        return true;
    }
}
