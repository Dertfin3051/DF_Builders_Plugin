package ru.dfhub.dfbuilders_plugin.components;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.dfhub.dfbuilders_plugin.utils.logger.Logger;
import ru.dfhub.dfbuilders_plugin.utils.logger.LoggerType;

import java.net.http.WebSocket;

/**
 * Изменение сообщений о заходе игрока
 */
public class PlayerJoinQuitMessage implements Listener {

    private static final String MESSAGE_COLOR = "#FED713";

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Component playerName = event.getPlayer().displayName().color(TextColor.color(255, 255, 255));
        event.joinMessage(
                Component.text("[+] ", TextColor.color(0, 255, 0))
                        .append(Component.text(
                                "Игрок ", TextColor.fromHexString(MESSAGE_COLOR)
                        ))
                        .append(playerName)
                        .append(Component.text(
                                " присоединился", TextColor.fromHexString(MESSAGE_COLOR)
                        ))
        );
        Logger.log(LoggerType.SESSIONS, "[+] %s".formatted(((TextComponent)event.getPlayer().displayName()).content()));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Component playerName = event.getPlayer().displayName().color(TextColor.color(255, 255, 255));
        event.quitMessage(
                Component.text("[-] ", TextColor.color(255, 0, 0))
                        .append(Component.text(
                                "Игрок ", TextColor.fromHexString(MESSAGE_COLOR)
                        ))
                        .append(playerName)
                        .append(Component.text(
                                " вышел", TextColor.fromHexString(MESSAGE_COLOR)
                        ))
        );
        Logger.log(LoggerType.SESSIONS, "[-] %s".formatted(((TextComponent)event.getPlayer().displayName()).content()));
    }
}
