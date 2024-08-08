package ru.dfhub.dfbuilders_plugin.components;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.util.CachedServerIcon;
import ru.dfhub.dfbuilders_plugin.DFBuilders_Plugin;
import ru.dfhub.dfbuilders_plugin.utils.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


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
