package me.diademiemi.embellish.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.diademiemi.embellish.Message;
import me.diademiemi.embellish.tool.Tool;

import java.util.List;
import java.util.Arrays;

/**
 * Command class for listening for embellish command
 *
 * @author diademiemi
 */
public class CommandExec implements CommandExecutor {

    /**
     * Method to handle commands
     *
     * @param sender    Entity sending the command
     * @param command   Command
     * @param label Command label used
     * @param args  List of arguments
     * @return  Boolean of if command was successful
     */
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("embellish") || label.equalsIgnoreCase("colour") || label.equalsIgnoreCase("color")) {
            if (args.length > 0) {
                switch (args[0].toLowerCase()) {
                    case "help":
                        if (sender.hasPermission("embellish.help")) {
                            sender.sendMessage(Message.HELP);
                        } else sender.sendMessage(Message.ERROR_NO_PERMS);
                        break;
                    case "solid":
                        if (sender.hasPermission("embellish.solid")) {
                            if (args.length > 1) {
                                if (Tool.isColour(args[1])) {
                                   if (args.length > 2) {
                                       List<String> textList = Arrays.asList(args);
                                       String text = String.join(" ", textList.subList(2, textList.size()));
                                       sender.sendMessage(Message.format(String.format("&7&l--- %s &7&l---\n", Tool.setSolidColour(args[1], text))));
                                       sender.spigot().sendMessage(Message.getMessageButtons(Tool.setSolidColour(args[1], text)));
                                   } else sender.sendMessage(Message.ERROR_UNKNOWN_ARGS);
                               } else sender.sendMessage(Message.ERROR_INVALID_COLOUR);
                            } else sender.sendMessage(Message.ERROR_UNKNOWN_ARGS);
                        } else sender.sendMessage(Message.ERROR_NO_PERMS);
                        break;
                    case "preview":
                        if (sender.hasPermission("embellish.preview")) {
                            if (args.length > 1) {
                                List<String> textList = Arrays.asList(args);
                                String text = String.join(" ", textList.subList(1, textList.size()));
                                sender.sendMessage(Message.format(String.format("&7&l--- %s &7&l---\n", Message.format(text))));
                                sender.spigot().sendMessage(Message.getMessageButtons(text));
                            } else sender.sendMessage(Message.ERROR_UNKNOWN_ARGS);
                        } else sender.sendMessage(Message.ERROR_NO_PERMS);
                        break;
                    default:
                        sender.sendMessage(Message.ERROR_UNKNOWN_ARGS);
                        break;
                }
            } else if (sender.hasPermission("embellish.help")) sender.sendMessage(Message.HELP);
                else sender.sendMessage(Message.ERROR_NO_PERMS);
        }
        return true;
    }
}
