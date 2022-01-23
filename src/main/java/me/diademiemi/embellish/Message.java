package me.diademiemi.embellish;

import org.bukkit.ChatColor;

import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.hover.content.Text;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Messages used within the plugin
 *
 * @author diademiemi
 */

public class Message { 
    
    private static final Config config = Config.getPluginConfig();

    private static final Config messageConfig = Config.getMessageConfig();

    public static String HELP;
    public static String ERROR_NO_PERMS;
    public static String ERROR_UNKNOWN_ARGS;
    public static String ERROR_INVALID_COLOUR;

    /**
     * Load/reload messages from file
     */
    public static void reloadMessages() {
        HELP = format(messageConfig.getConfig().getString("HELP"));
        ERROR_NO_PERMS = format(messageConfig.getConfig().getString("ERROR_NO_PERMS"));
        ERROR_UNKNOWN_ARGS = format(messageConfig.getConfig().getString("ERROR_UNKNOWN_ARGS"));
        ERROR_INVALID_COLOUR = format(messageConfig.getConfig().getString("ERROR_INVALID_COLOUR"));
    }

    /**
     * Apply colour codes and line breaks
     * This is used for messages.yml, NOT the tool itself
     *
     * @param msg   Message to format
     * @return  Formatted message with colours
     */
    public static String format(String msg) {
        return translateHexColorCodes("&#", ChatColor.translateAlternateColorCodes('&', msg));
    }

    public static final char COLOR_CHAR = ChatColor.COLOR_CHAR;

    /**
     * Apply hex colours
     * 
     * @param startTag  What identifies hex colours, usually the ampersand and hashtag
     * @param message   The message to format
     * @return  Formatted message with hex colours
     */
    public static String translateHexColorCodes(String startTag, String message) {
        final Pattern hexPattern = Pattern.compile(startTag + "([A-Fa-f0-9]{6})");
        Matcher matcher = hexPattern.matcher(message);
        StringBuffer buffer = new StringBuffer(message.length() + 4 * 8);
        while (matcher.find())
        {
            String group = matcher.group(1);
            matcher.appendReplacement(buffer, COLOR_CHAR + "x"
                    + COLOR_CHAR + group.charAt(0) + COLOR_CHAR + group.charAt(1)
                    + COLOR_CHAR + group.charAt(2) + COLOR_CHAR + group.charAt(3)
                    + COLOR_CHAR + group.charAt(4) + COLOR_CHAR + group.charAt(5)
                    );
        }
        return matcher.appendTail(buffer).toString();
    }

    /**
     * Adds the copy to clipboard and run command components
     * 
     * @param colouredText  Input text to use for the command or clipboard
     * @return  Message components to senc
     */
    public static BaseComponent[] getMessageButtons(String colouredText) {
        // Make a new component (Bungee API).
        ComponentBuilder builder = new ComponentBuilder();
        // Add a click event to the component.
        if (!colouredText.contains(" ")) {
            builder.append(
                new ComponentBuilder(format("&7[&9Nick&7]&r"))
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(
                    format(String.format("&fSet this as a nickname with &7%s", 
                    config.getConfig().getString("nick-command"))))))
                .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, 
                    String.format("%1$s %2$s", config.getConfig().getString("nick-command"), colouredText)))
                .create()
            );
        }    

        builder.append(
            new ComponentBuilder(format("&7[&6Copy&7]&r"))
            .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Copy this text to your clipboard")))
            .event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, colouredText))
            .create()
        );

        return builder.create();
    }
}
