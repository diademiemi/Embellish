package me.diademiemi.embellish;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.permissions.Permission;

import me.diademiemi.embellish.command.CommandExec;
import me.diademiemi.embellish.tool.Tool;

/**
 * Embellish plugin
 *
 * @author diademiemi
 */
public class Embellish extends JavaPlugin { 

    /**
     * Plugin instance
     */
    private static Embellish plugin;

    /**
     * Plugin manager
     */
    private static PluginManager pm;


    /**
     * Run on startup, load files, create permissions and start
     */
    @Override
    public void onEnable() {
        plugin = this;

        Config.getPluginConfig().saveDefaultConfig();
        Config.getMessageConfig().saveDefaultConfig();

        Message.reloadMessages();
        
        pm = getServer().getPluginManager();

        pm.addPermission(new Permission("embellish.help"));
        pm.addPermission(new Permission("embellish.reload"));
        pm.addPermission(new Permission("embellish.use"));
        pm.addPermission(new Permission("embellish.use.solid"));
        pm.addPermission(new Permission("embellish.use.pattern"));
        pm.addPermission(new Permission("embellish.use.gradient"));
        pm.addPermission(new Permission("embellish.use.preset"));
        pm.addPermission(new Permission("embellish.listpresets"));
        pm.addPermission(new Permission("embellish.showcodes"));

        getCommand("embellish").setExecutor(new CommandExec());

        Tool.populateColours();

    }

    /**
     * Disable plugin
     */
    @Override
    public void onDisable() {
        plugin = null;
    }

    /**
     * Get plugin instance
     *
     * @return Plugin instance
     */
    public static Embellish getInstance() {
        return plugin;
    }

}