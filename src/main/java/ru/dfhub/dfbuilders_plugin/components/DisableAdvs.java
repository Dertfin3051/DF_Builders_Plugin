package ru.dfhub.dfbuilders_plugin.components;

import com.destroystokyo.paper.event.player.PlayerAdvancementCriterionGrantEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

public class DisableAdvs implements Listener {

    @EventHandler
    public void onGetAdvancement(PlayerAdvancementCriterionGrantEvent event) {
        event.setCancelled(true);
    }
}
