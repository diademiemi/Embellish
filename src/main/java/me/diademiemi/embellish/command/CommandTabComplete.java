package me.diademiemi.embellish.command;

import me.diademiemi.embellish.tool.Colour;
import me.diademiemi.embellish.tool.Preset;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * Class for functionality for tab completion
 * 
 * @author diademiemi
 */
public class CommandTabComplete implements TabCompleter {
    
	/**
	 * Private boolean to determine whether this option should get completed
	 *
	 * @param option	Option to check
	 * @param current	Currently typed
	 *
	 * @return	Boolean of whether to complete
	 */
	private void shouldTab(String option, String current) {
		if (current.equals("")) {
			tabList.add(option);
		} else if (option.startsWith(current.toLowerCase())) {
			tabList.add(option);
		}
	}

	/**
	 * Private boolean to determine whether this option should get completed
	 *
	 * @param option	Option to check
	 * @param current	Currently typed
	 * @param player	Player to check for
	 * @param permission	String of the permission required
	 *
	 * @return	Boolean of whether to complete
	 */
	private void shouldTab(String option, String current, Player player, String permission) {
		if (player.hasPermission(permission)) {
			if (current.equals("")) {
				tabList.add(option);
			} else if (option.startsWith(current.toLowerCase())) {
				tabList.add(option);
			} 
		}
	}    
    public ArrayList<String> tabList;

    /**
     * Method to implement tab completion
     *
     * @param sender    Entity sending the command
     * @param command   Command
     * @param label Command label used
     * @param args  List of arguments
     * @return tab list
     */
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        tabList = new ArrayList<>();

        ArrayList<String> presets = Preset.listPresets();
        Set<String> colours = Colour.getColourNames();

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0 || args.length == 1) {

                shouldTab("help", args[0], player, "embellish.help");
                shouldTab("solid", args[0], player, "embellish.use.solid");
                shouldTab("gradient", args[0], player, "embellish.use.gradient");
                shouldTab("pattern", args[0], player, "embellish.use.pattern");
                shouldTab("preview", args[0], player, "embellish.use.preview");
                shouldTab("listpresets", args[0], player, "embellish.listpresets");
                shouldTab("preset", args[0], player, "embellish.help");

            } else if (args.length == 2) {

                if (args[0].equalsIgnoreCase("preset") && player.hasPermission("embellish.use.preset")) {

                    for (String p : presets) {
                        shouldTab(p, args[1]);
                    }

                } else if (args[0].equalsIgnoreCase("pattern") && player.hasPermission("embellish.use.pattern")) {

                    shouldTab("stretch", args[1], player, "embellish.use.pattern.stretch");
                    shouldTab("repeat", args[1], player, "embellish.use.pattern.repeat");
                    shouldTab("gradient", args[1], player, "embellish.use.pattern.gradient");

                } else if (args[0].equalsIgnoreCase("solid") && player.hasPermission("embellish.use.solid") ||
                    args[0].equalsIgnoreCase("gradient") && player.hasPermission("embellish.use.gradient")) {

                        for (String c : colours) {
                            shouldTab(c, args[1]);
                        }

                } 

            }

            return tabList;
        

        }

        return null;

    }

}
