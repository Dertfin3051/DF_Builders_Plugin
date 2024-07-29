package ru.dfhub.dfbuilders_plugin.components;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.util.CachedServerIcon;
import ru.dfhub.dfbuilders_plugin.DFBuilders_Plugin;

import java.util.List;
import java.util.Random;


public class MotdListener implements Listener {

    @EventHandler
    public void onServerListed(ServerListPingEvent event) {

        //FileConfiguration config = DFBuilders_Plugin.getInstance().getConfig();

        //List<String> motdList = config.getStringList("motd.motd-values");

        List<String> motdList = List.of(
                "Говорят, тут хотели построить Вавилонскую башню",
                "Го к нам строить",
                "Нет доступа?) Гуляй",
                "Самый жоские постройки у нас",
                "ЭТО ПРИВАТНЫЙ СЕРВЕР! КАК ЕЩЁ ОБЪЯСНИТЬ?!?!?!?!",
                "DFBuilders - не слышали о таком...",
                "А ведь когда-то на хосте не хватит места",
                "Вайп на сервере без вайпов?",
                "dertfin1 следит за тобой..."
        );

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
