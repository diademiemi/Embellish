package me.diademiemi.embellish.command;
import me.diademiemi.embellish.Message;
import me.diademiemi.embellish.tool.*;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

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
                                if (Colour.isColour(args[1])) {
                                   if (args.length > 2) {
                                       List<String> textList = Arrays.asList(args);
                                       String text = String.join(" ", textList.subList(2, textList.size()));
                                       Formatter.sendMessage(sender, Tool.setSolidColour(args[1], text));
                                    } else sender.sendMessage(Message.ERROR_UNKNOWN_ARGS); // TODO
                               } else sender.sendMessage(Message.ERROR_INVALID_COLOUR);
                            } else sender.sendMessage(Message.ERROR_UNKNOWN_ARGS); // TODO
                        } else sender.sendMessage(Message.ERROR_NO_PERMS);
                        break;
                    case "gradient":
                        if (sender.hasPermission("embellish.gradient")) {
                            if (args.length > 2) {
                                if (Colour.isColour(args[1]) && Colour.isColour(args[2])) {
                                    if (args.length > 3) {
                                        List<String> textList = Arrays.asList(args);
                                        String text = String.join(" ", textList.subList(3, textList.size()));
                                        Formatter.sendMessage(sender, Tool.setGradientColour(args[1], args[2], text));
                                    } else sender.sendMessage(Message.ERROR_UNKNOWN_ARGS); // TODO
                                } else sender.sendMessage(Message.ERROR_INVALID_COLOUR);
                            } else sender.sendMessage(Message.ERROR_UNKNOWN_ARGS); // TODO
                        } else sender.sendMessage(Message.ERROR_NO_PERMS);
                        break;
                    case "pattern":
                        if (sender.hasPermission("embellish.pattern")) {
                            if (args.length > 1 ) {
                                if (args.length > 2) {
                                    if (args.length > 3) {
                                        String[] pattern = args[2].split("\\s*,\\s*");
                                        if (Colour.validateColours(pattern)) {
                                            List<String> textList = Arrays.asList(args);
                                            String text = String.join(" ", textList.subList(3, textList.size()));
                                            switch (args[1].toLowerCase()) {
                                                case "stretch":
                                                    if (sender.hasPermission("embellish.use.pattern.stretch")) {
                                                        Formatter.sendMessage(sender, Pattern.stretchPattern(pattern, text));
                                                    } else sender.sendMessage(Message.ERROR_NO_PERMS);
                                                    break;
                                                case "repeat":
                                                    if (sender.hasPermission("embellish.use.pattern.repeat")) {
                                                        Formatter.sendMessage(sender, Pattern.repeatPattern(pattern, text));
                                                    } else sender.sendMessage(Message.ERROR_NO_PERMS);
                                                    break;
                                                case "gradient":
                                                    if (sender.hasPermission("embellish.use.pattern.gradient")) {
                                                        Formatter.sendMessage(sender, Pattern.gradientPattern(pattern, text));
                                                    } else sender.sendMessage(Message.ERROR_NO_PERMS);
                                                    break;
                                                default:
                                                    sender.sendMessage(Message.ERROR_UNKNOWN_ARGS);
                                                    break;
                                            }
                                        } else sender.sendMessage(Message.ERROR_INVALID_COLOUR);
                                    } else sender.sendMessage(Message.ERROR_UNKNOWN_ARGS); // TODO
                                } else sender.sendMessage(Message.ERROR_UNKNOWN_ARGS); // TODO
                            } else sender.sendMessage(Message.ERROR_UNKNOWN_ARGS); // TODO
                        } else sender.sendMessage(Message.ERROR_NO_PERMS);
                        break;
                    case "preview":
                        if (sender.hasPermission("embellish.preview")) {
                            if (args.length > 1) {
                                List<String> textList = Arrays.asList(args);
                                String text = String.join(" ", textList.subList(1, textList.size()));
                                Formatter.sendMessage(sender, text);
                            } else sender.sendMessage(Message.ERROR_UNKNOWN_ARGS); // TODO
                        } else sender.sendMessage(Message.ERROR_NO_PERMS);
                        break;
                    case "listpresets":
                        if (sender.hasPermission("embellish.listpresets")) {
                            Formatter.sendPresetsList(sender, Preset.listPresets(), label);
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
