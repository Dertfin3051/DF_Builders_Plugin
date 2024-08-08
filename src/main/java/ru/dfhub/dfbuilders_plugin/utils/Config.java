package ru.dfhub.dfbuilders_plugin.utils;

import org.bukkit.Bukkit;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Класс для работы с конфигом
 */
public class Config {

    // Путь к конфигу относительно корня
    private static final String CONFIG_PATH = "plugins/DFBuilders_Plugin/config.json";

    /**
     * Метод для получения конфига
     * @return Возвращает конфиг в формате `org.json.JSONObject`
     */
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
