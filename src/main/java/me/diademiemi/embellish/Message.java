package me.diademiemi.embellish;

import me.diademiemi.embellish.tool.Formatter;

/**
 * Messages used within the plugin
 *
 * @author diademiemi
 */

public class Message { 
    
    private static final Config messageConfig = Config.getMessageConfig();

    public static String HELP;
    public static String CONFIG_RELOADED;
    public static String ERROR_NO_PERMS;
    public static String ERROR_UNKNOWN_ARGS;
    public static String ERROR_MISSING_ARG;
    public static String ERROR_INVALID_COLOUR;
    public static String ERROR_INVALID_COLOURS;
    public static String ERROR_INVALID_PRESET;

    /**
     * Load/reload messages from file
     */
    public static void reloadMessages() {
        HELP = Formatter.format(messageConfig.getConfig().getString("HELP"));
        CONFIG_RELOADED = Formatter.format(messageConfig.getConfig().getString("CONFIG_RELOADED"));
        ERROR_NO_PERMS = Formatter.format(messageConfig.getConfig().getString("ERROR_NO_PERMS"));
        ERROR_UNKNOWN_ARGS = Formatter.format(messageConfig.getConfig().getString("ERROR_UNKNOWN_ARGS"));
        ERROR_MISSING_ARG = Formatter.format(messageConfig.getConfig().getString("ERROR_MISSING_ARG"));
        ERROR_INVALID_COLOUR = Formatter.format(messageConfig.getConfig().getString("ERROR_INVALID_COLOUR"));
        ERROR_INVALID_COLOURS = Formatter.format(messageConfig.getConfig().getString("ERROR_INVALID_COLOURS"));
        ERROR_INVALID_PRESET = Formatter.format(messageConfig.getConfig().getString("ERROR_INVALID_PRESET"));
    }

}
