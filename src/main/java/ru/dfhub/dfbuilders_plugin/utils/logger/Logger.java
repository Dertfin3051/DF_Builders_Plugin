package ru.dfhub.dfbuilders_plugin.utils.logger;

import org.bukkit.Bukkit;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;

public final class Logger {

    /*
    public static final String SESSION_FILE_PATH = "/plugins/DFBuilders_Plugin/logs/sessions.log.txt";
    public static final String ALERTS_FILE_PATH = "/plugins/DFBuilders_Plugin/logs/alerts.log.txt";


     */

    public static final String SESSION_FILE_PATH = "plugins/DFBuilders_Plugin/logs/sessions.log.txt";
    public static final String ALERTS_FILE_PATH = "plugins/DFBuilders_Plugin/logs/alerts.log.txt";

    private static final String LOG_FORMAT = "[{date}] {message}\n";

    public static void init() throws IOException {
        File sessionsFile = new File(SESSION_FILE_PATH);
        File alertsFile = new File(ALERTS_FILE_PATH);

        if (!sessionsFile.exists()) sessionsFile.createNewFile();
        if (!alertsFile.exists()) alertsFile.createNewFile();

    }

    public static void log(LoggerType loggerType, String message) {
        if (loggerType == LoggerType.SESSIONS) {
            try {
                Files.write(Paths.get(SESSION_FILE_PATH), getLogLine(message).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                Bukkit.getLogger().log(Level.WARNING, "Error occurred in session logger");
            }
        } else if (loggerType == LoggerType.ALERTS) {
            try {
                Files.write(Paths.get(ALERTS_FILE_PATH), getLogLine(message).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                Bukkit.getLogger().log(Level.WARNING, "Error occurred in alerts logger");
            }
        }
    }

    /**
     * Метод для автоматического получения готовой строки с логом и временем
     * @param message Сообщение
     * @return Строка с логов в формате: [Время] Сообщение
     */
    private static String getLogLine(String message) {
        return LOG_FORMAT
                .replace("{date}", getFormattedTime())
                .replace("{message}", message);
    }

    private static String getFormattedTime() {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm"); // Пример 30.10.2009 14:42
        return time.format(formatter);
    }
}

