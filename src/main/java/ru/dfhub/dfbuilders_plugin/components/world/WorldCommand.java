package ru.dfhub.dfbuilders_plugin.components.world;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WorldCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage(
                    Component.text("Вы не указали мир! ")
                            .color(TextColor.color(255,0,0))
            );
        }
        switch (args[0]) {
            case "main":
                player.teleport(new Location(
                        Bukkit.getWorld("world"),
                        0, 0, 0
                ));
                break;
            case "build":
                player.teleport(new Location(
                        Bukkit.getWorld("world_build"),
                        0, 0, 0
                ));
                break;
        }
        return true;
    }
}
