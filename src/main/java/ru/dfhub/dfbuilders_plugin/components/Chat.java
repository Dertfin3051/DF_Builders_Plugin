package ru.dfhub.dfbuilders_plugin.components;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.net.http.WebSocket;

public class Chat implements Listener {

    @EventHandler
    public void onChat(AsyncChatEvent event) {
        Component newMessage = MiniMessage.miniMessage().deserialize(
                "<white><player> - <message></white>",
                Placeholder.unparsed("player", ((TextComponent)event.getPlayer().displayName()).content()),
                Placeholder.unparsed("message", ((TextComponent) event.message()).content())
        );
        /*
        event.message(
                MiniMessage.miniMessage().deserialize(
                        "<white><player> -> <message></white>",
                        Placeholder.unparsed("player", ((TextComponent)event.getPlayer().displayName()).content()),
                        Placeholder.unparsed("message", ((TextComponent) event.message()).content())
                )
        );

         */
        event.renderer((source, sourceDisplayName, message1, viewer) -> newMessage);
    }
}
