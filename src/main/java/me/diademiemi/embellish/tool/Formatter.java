package me.diademiemi.embellish.tool;
import me.diademiemi.embellish.Config;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class Formatter {

    private static final Config config = Config.getPluginConfig();

    /**
     * Apply colour codes and line breaks
     * This is used for messages.yml, NOT the tool itself
     *
     * @param msg   Message to format
     * @return  Formatted message with colours
     */
    public static String format(String msg) {
        return translateHexColorCodes(ChatColor.translateAlternateColorCodes('&', msg));
    }

    /**
     * Apply hex colours to message
     * 
     * @param message   The message to format
     * @return  Formatted message with hex colours
     */
    public static String translateHexColorCodes(String message) {
        final Pattern hexPattern = Pattern.compile("&#([A-Fa-f0-9]{6})");
        Matcher matcher = hexPattern.matcher(message);
        while (matcher.find()) {
            String colour = message.substring(matcher.start(), matcher.end());
            message = message.replace(colour, ChatColor.of(colour.replace("&", "")) + "");
            matcher = hexPattern.matcher(message);
        }
        return ChatColor.translateAlternateColorCodes('&', message);
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
        if (config.getConfig().getString("nick-command") != "") {
            // Check if this would count as a nickname
            if (!colouredText.contains(" ") && 
            colouredText.replaceAll("&([a-fr0-9]|#[0-9a-f]{6})", "").length() <= config.getConfig().getInt("nick-length")) {
                builder.append(
                    new ComponentBuilder(format("&7[&9Nick&7]&r"))
                    .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(
                        format(String.format("&rSet this as a nickname with &7%s", 
                        config.getConfig().getString("nick-command"))))))
                    .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, 
                        String.format("%1$s %2$s", config.getConfig().getString("nick-command"), colouredText)))
                    .create()
                );
            }    
        }

        builder.append(
            new ComponentBuilder(format("&7[&6Copy&7]&r"))
            .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Copy this text to your clipboard")))
            .event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, colouredText))
            .create()
        );

        return builder.create();
    }

    public static void sendMessage(CommandSender sender, String colouredText) {
        sender.sendMessage(format(String.format("&7&l--- %s &7&l---\n", colouredText)));
        sender.spigot().sendMessage(getMessageButtons(colouredText));
    }

    /**
     * Add components for the presets list message
     * 
     * @param text  Text with colour codes to turn into components
     * @param preset    Name of the preset
     * @param label Label for the hover text
     * @return  Return a list of base components
     */
    public static BaseComponent[] presetComponents(String text, String preset, String label) {
        // Prepare component builder
        ComponentBuilder builder = new ComponentBuilder();
        // Create regex match for hex codes
        final Pattern hexPattern = Pattern.compile("&#([A-Fa-f0-9]{6})");
        Matcher matcher = hexPattern.matcher(text);

        // Split text into pieces which will be separate text components (thanks, bungee)
        String[] textList = text.split("&#([A-Fa-f0-9]{6})");

        // Start at SECOND string in list, the first will always be blank
        int counter = 1;

        while (matcher.find()) {
            // Get hex colour
            String colour = text.substring(matcher.start(), matcher.end()).replace("&", "");
            // Create component from text from list
            TextComponent component = new TextComponent(textList[counter]);
            // Set components colour
            component.setColor(ChatColor.of(colour));
            // Add event on hover
            component.setHoverEvent(
                new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(
                        format(String.format("&rUse the &7%s &rpreset", preset)))));
            // Add event on click
            component.setClickEvent(
                new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, 
                        String.format("/%1$s preset %2$s ", label, preset)));
            // Append component to builder
            builder.append(component);
            counter++;
        }
        // Return components
        return builder.create();
    }

    /**
     * Send a list of availabel presets, with hover and click actions
     * 
     * @param sender    Player to send the message to
     * @param presets   List of presets
     * @param label Label used to call the command
     */
    public static void sendPresetsList(CommandSender sender, ArrayList<String> presets, String label) {
        ComponentBuilder builder = new ComponentBuilder();
        // If there's any presets defined
        if (presets.size() > 0 ){
            for (String p : presets) {
                // Only list valid presets
                if (Preset.isValidPreset(p)) {
                    String colouredText = Preset.applyPreset(p, p);
                    // Create clickable text for every preset
                    builder.append(presetComponents(colouredText, p, label));
                    // Add the comma
                    builder.append(
                        new ComponentBuilder(format("&7, "))
                        .create()
                    );
    
                }
            }
        }
        sender.sendMessage(format("&7&l--- &rPresets &7&l---\n"));
        sender.spigot().sendMessage(builder.create());
    }

}
