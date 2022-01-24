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
    public static String ERROR_NO_PERMS;
    public static String ERROR_UNKNOWN_ARGS;
    public static String ERROR_INVALID_COLOUR;

    /**
     * Load/reload messages from file
     */
    public static void reloadMessages() {
        HELP = Formatter.format(messageConfig.getConfig().getString("HELP"));
        ERROR_NO_PERMS = Formatter.format(messageConfig.getConfig().getString("ERROR_NO_PERMS"));
        ERROR_UNKNOWN_ARGS = Formatter.format(messageConfig.getConfig().getString("ERROR_UNKNOWN_ARGS"));
        ERROR_INVALID_COLOUR = Formatter.format(messageConfig.getConfig().getString("ERROR_INVALID_COLOUR"));
    }

}
