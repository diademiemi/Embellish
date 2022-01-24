package me.diademiemi.embellish.tool;
import me.diademiemi.embellish.Config;

import java.util.ArrayList;

public class Preset {

    private static final Config config = Config.getPluginConfig();

    /**
     * Gets list of all available presets
     * 
     * @return  List of preset names
     */
    public static ArrayList<String> listPresets() {
        ArrayList<String> list = new ArrayList<String>(
            config.getConfig().getConfigurationSection("presets").getKeys(false)
        );
        return list;
    }

    /**
     * Check if a preset exists and is valid
     * 
     * @param preset    Preset name to check
     * @return  Whether preset exists and is valid
     */
    public static Boolean isValidPreset(String preset) {
        // If the preset exists
        if (config.getConfig().getConfigurationSection("presets").getKeys(false).contains(preset)) {
            // If the type is valid
            String type = config.getConfig().getConfigurationSection("presets").getString(String.format("%s.type", preset));
            if (type.equals("stretch") || type.equals("repeat") || type.equals("gradient")) {
                // If the colours are set
                String[] colours = config.getConfig().getConfigurationSection("presets").getStringList(String.format("%s.colours", preset)).toArray(new String[0]);
                if (colours.length > 0) {
                    // Validate colours
                    if (Colour.validateColours(colours)) {
                        return true;
                    }
                }
            }
        }
        // If one check failed
        return false;
        
    }

    /**
     * Apply preset to text
     * 
     * @param preset    Name of preset to apply
     * @param text  Text to apply preset to
     * @return  Text with colour codes injected
     */
    public static String applyPreset(String preset, String text) {
        // Get the colour pattern
        String[] pattern = config.getConfig().getConfigurationSection("presets").getStringList(String.format("%s.colours", preset)).toArray(new String[0]);
        // Call the appropriate pattern function
        switch (config.getConfig().getConfigurationSection("presets").getString(String.format("%s.type", preset))) {
            case "stretch":
                return Pattern.stretchPattern(pattern, text);
            case "repeat":
                return Pattern.repeatPattern(pattern, text);
            case "gradient":
                return Pattern.gradientPattern(pattern, text);
            default:
                return "Uh oh, this should never be reached";
        }

    }
}
