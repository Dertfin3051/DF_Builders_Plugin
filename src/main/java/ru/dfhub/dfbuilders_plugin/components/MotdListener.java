package ru.dfhub.dfbuilders_plugin.components;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import ru.dfhub.dfbuilders_plugin.utils.Config;

import java.util.List;
import java.util.Random;

/**
 * Изменнение MOTD сервера на рандомные
 * варианты из конфига
 */
public class MotdListener implements Listener {

    @EventHandler
    public void onServerListed(ServerListPingEvent event) {
        List<String> motdList = Config.getConfig().getJSONArray("motd").toList()
                .stream()
                .map(val -> (String) val)
                .toList();

        Random random = new Random();
        int el = random.nextInt(motdList.size()); // Номер случайного элемента из motdList

        event.motd(
                Component.text(
                        motdList.get(el),
                        TextColor.fromHexString("#8A8A8A")
                )
        );
    }
}
