package me.diademiemi.embellish.tool;
import me.diademiemi.embellish.Config;

import java.util.ArrayList;

public class Preset {

    private static final Config config = Config.getPluginConfig();

    public static ArrayList<String> listPresets() {
        ArrayList<String> list = new ArrayList<String>(
            config.getConfig().getConfigurationSection("presets").getKeys(false)
        );
        return list;
    }
}
