package ru.dfhub.dfbuilders_plugin.utils;

import org.bukkit.Bukkit;
import org.json.JSONObject;
import ru.dfhub.dfbuilders_plugin.utils.logger.LoggerType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Config {

    private static final String CONFIG_PATH = "plugins/DFBuilders_Plugin/config.json";

    public static JSONObject getConfig() {
        String config = "";
        try {
            config = Files.readString(Paths.get(CONFIG_PATH));
        } catch (IOException e) {
            Bukkit.getLogger().throwing("Config", "getConfig", new IOException("Error occurred in Config.getConfig(): %s".formatted(e.getMessage())));
        }
        return new JSONObject(config);
    }

}
