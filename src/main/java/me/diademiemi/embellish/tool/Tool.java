package me.diademiemi.embellish.tool;

import me.diademiemi.embellish.Config;

import java.util.HashMap;

/**
 * Embellish functions to apply colours
 *
 * @author diademiemi
 */

public class Tool {

    // Load patterns
    private static final Config config = Config.getPluginConfig();

    // Create colours hashmap
    private static HashMap<String, String> colourList = new HashMap<>();

    // Set colours from W3
    public static void populateColours() {
        colourList.clear();
        colourList.put("aliceblue", "f0f8ff");
        colourList.put("antiquewhite", "faebd7");
        colourList.put("aqua", "00ffff");
        colourList.put("aquamarine", "7fffd4");
        colourList.put("azure", "f0ffff");
        colourList.put("beige", "f5f5dc");
        colourList.put("bisque", "ffe4c4");
        colourList.put("black", "000000");
        colourList.put("blanchedalmond", "ffebcd");
        colourList.put("blue", "0000ff");
        colourList.put("blueviolet", "8a2be2");
        colourList.put("brown", "a52a2a");
        colourList.put("burlywood", "deb887");
        colourList.put("cadetblue", "5f9ea0");
        colourList.put("chartreuse", "7fff00");
        colourList.put("chocolate", "d2691e");
        colourList.put("coral", "ff7f50");
        colourList.put("cornflowerblue", "6495ed");
        colourList.put("cornsilk", "fff8dc");
        colourList.put("crimson", "dc143c");
        colourList.put("cyan", "00ffff");
        colourList.put("darkblue", "00008b");
        colourList.put("darkcyan", "008b8b");
        colourList.put("darkgoldenrod", "b8860b");
        colourList.put("darkgray", "a9a9a9");
        colourList.put("darkgrey", "a9a9a9");
        colourList.put("darkgreen", "006400");
        colourList.put("darkkhaki", "bdb76b");
        colourList.put("darkmagenta", "8b008b");
        colourList.put("darkolivegreen", "556b2f");
        colourList.put("darkorange", "ff8c00");
        colourList.put("darkorchid", "9932cc");
        colourList.put("darkred", "8b0000");
        colourList.put("darksalmon", "e9967a");
        colourList.put("darkseagreen", "8fbc8f");
        colourList.put("darkslateblue", "483d8b");
        colourList.put("darkslategray", "2f4f4f");
        colourList.put("darkslategrey", "2f4f4f");
        colourList.put("darkturquoise", "00ced1");
        colourList.put("darkviolet", "9400d3");
        colourList.put("deeppink", "ff1493");
        colourList.put("deepskyblue", "00bfff");
        colourList.put("dimgray", "696969");
        colourList.put("dimgrey", "696969");
        colourList.put("dodgerblue", "1e90ff");
        colourList.put("firebrick", "b22222");
        colourList.put("floralwhite", "fffaf0");
        colourList.put("forestgreen", "228b22");
        colourList.put("fuchsia", "ff00ff");
        colourList.put("gainsboro", "dcdcdc");
        colourList.put("ghostwhite", "f8f8ff");
        colourList.put("gold", "ffd700");
        colourList.put("goldenrod", "daa520");
        colourList.put("gray", "808080");
        colourList.put("grey", "808080");
        colourList.put("green", "008000");
        colourList.put("greenyellow", "adff2f");
        colourList.put("honeydew", "f0fff0");
        colourList.put("hotpink", "ff69b4");
        colourList.put("indianred", "cd5c5c");
        colourList.put("indigo", "4b0082");
        colourList.put("ivory", "fffff0");
        colourList.put("khaki", "f0e68c");
        colourList.put("lavender", "e6e6fa");
        colourList.put("lavenderblush", "fff0f5");
        colourList.put("lawngreen", "7cfc00");
        colourList.put("lemonchiffon", "fffacd");
        colourList.put("lightblue", "add8e6");
        colourList.put("lightcoral", "f08080");
        colourList.put("lightcyan", "e0ffff");
        colourList.put("lightgoldenrodyellow", "fafad2");
        colourList.put("lightgray", "d3d3d3");
        colourList.put("lightgrey", "d3d3d3");
        colourList.put("lightgreen", "90ee90");
        colourList.put("lightpink", "ffb6c1");
        colourList.put("lightsalmon", "ffa07a");
        colourList.put("lightseagreen", "20b2aa");
        colourList.put("lightskyblue", "87cefa");
        colourList.put("lightslategray", "778899");
        colourList.put("lightslategrey", "778899");
        colourList.put("lightsteelblue", "b0c4de");
        colourList.put("lightyellow", "ffffe0");
        colourList.put("lime", "00ff00");
        colourList.put("limegreen", "32cd32");
        colourList.put("linen", "faf0e6");
        colourList.put("magenta", "ff00ff");
        colourList.put("maroon", "800000");
        colourList.put("mediumaquamarine", "66cdaa");
        colourList.put("mediumblue", "0000cd");
        colourList.put("mediumorchid", "ba55d3");
        colourList.put("mediumpurple", "9370db");
        colourList.put("mediumseagreen", "3cb371");
        colourList.put("mediumslateblue", "7b68ee");
        colourList.put("mediumspringgreen", "00fa9a");
        colourList.put("mediumturquoise", "48d1cc");
        colourList.put("mediumvioletred", "c71585");
        colourList.put("midnightblue", "191970");
        colourList.put("mintcream", "f5fffa");
        colourList.put("mistyrose", "ffe4e1");
        colourList.put("moccasin", "ffe4b5");
        colourList.put("navajowhite", "ffdead");
        colourList.put("navy", "000080");
        colourList.put("oldlace", "fdf5e6");
        colourList.put("olive", "808000");
        colourList.put("olivedrab", "6b8e23");
        colourList.put("orange", "ffa500");
        colourList.put("orangered", "ff4500");
        colourList.put("orchid", "da70d6");
        colourList.put("palegoldenrod", "eee8aa");
        colourList.put("palegreen", "98fb98");
        colourList.put("paleturquoise", "afeeee");
        colourList.put("palevioletred", "db7093");
        colourList.put("papayawhip", "ffefd5");
        colourList.put("peachpuff", "ffdab9");
        colourList.put("peru", "cd853f");
        colourList.put("pink", "ffc0cb");
        colourList.put("plum", "dda0dd");
        colourList.put("powderblue", "b0e0e6");
        colourList.put("purple", "800080");
        colourList.put("rebeccapurple", "663399");
        colourList.put("red", "ff0000");
        colourList.put("rosybrown", "bc8f8f");
        colourList.put("royalblue", "4169e1");
        colourList.put("sputlebrown", "8b4513");
        colourList.put("salmon", "fa8072");
        colourList.put("sandybrown", "f4a460");
        colourList.put("seagreen", "2e8b57");
        colourList.put("seashell", "fff5ee");
        colourList.put("sienna", "a0522d");
        colourList.put("silver", "c0c0c0");
        colourList.put("skyblue", "87ceeb");
        colourList.put("slateblue", "6a5acd");
        colourList.put("slategray", "708090");
        colourList.put("slategrey", "708090");
        colourList.put("snow", "fffafa");
        colourList.put("springgreen", "00ff7f");
        colourList.put("steelblue", "4682b4");
        colourList.put("tan", "d2b48c");
        colourList.put("teal", "008080");
        colourList.put("thistle", "d8bfd8");
        colourList.put("tomato", "ff6347");
        colourList.put("turquoise", "40e0d0");
        colourList.put("violet", "ee82ee");
        colourList.put("wheat", "f5deb3");
        colourList.put("white", "ffffff");
        colourList.put("whitesmoke", "f5f5f5");
        colourList.put("yellow", "ffff00");
        colourList.put("yellowgreen", "9acd32");
    }
    
    /**
     * Gets a colours hex code by name
     * 
     * @param colour    Name of the colour
     * @return  Hex code
     */
    public static String getColourByName(String colour) {
        return colourList.get(colour);
    }

    /**
     * Check if a colour is in the colours list
     * 
     * @param colour    Name of the colour
     * @return  If the colour is in the list
     */
    public static Boolean isColour(String colour) {
        return colourList.containsKey(colour);
    }

    public static Boolean validateColours(String[] colours) {
        if (colours.length == 0) {
            return false;
        }
        for (String colour : colours) {
            if (!isColour(colour)) { 
                return false;
            }
        }
        return true;
    }

    /**
     * Set solid colour
     *
     * @param colour Colour to apply as a string
     * @param text  Text to colour
     * @return Text with colour codes injected
     */
    public static String setSolidColour(String colour, String text) {
        return "&#" + getColourByName(colour) + text;
    }

    /**
     * Set a gradient colour
     * @param colourLeft    Left colour to apply
     * @param colourRight   Right colour to apply
     * @param text  Text to apply gradient to
     * @return  Text with colour codes injected
     */
    public static String setGradientColour(String colourLeft, String colourRight, String text) {
        // Get the integers of the left colour
        int leftR = Integer.valueOf(getColourByName(colourLeft).substring(0, 2), 16);
        int leftG = Integer.valueOf(getColourByName(colourLeft).substring(2, 4), 16);
        int leftB = Integer.valueOf(getColourByName(colourLeft).substring(4, 6), 16);

        // Get the integers of the right colour
        int rightR = Integer.valueOf(getColourByName(colourRight).substring(0, 2), 16);
        int rightG = Integer.valueOf(getColourByName(colourRight).substring(2, 4), 16);
        int rightB = Integer.valueOf(getColourByName(colourRight).substring(4, 6), 16);

        // Get the difference between left and right
        int diffR = leftR - rightR;
        int diffG = leftG - rightG;
        int diffB = leftB - rightB;

        // Get the amount of steps the colour should take per character
        int stepR, stepG, stepB;
        if (text.length() > 1) {
            stepR = diffR / (text.length() - 1);
            stepG = diffG / (text.length() - 1);
            stepB = diffB / (text.length() - 1);
        } else {
            stepR = 0;
            stepG = 0;
            stepB = 0;
        }

        // Prepare output string
        StringBuilder output = new StringBuilder();

        // Loop for every character
        for (int i = 0; i < text.length(); i++) {
            StringBuilder builder = new StringBuilder();
            // Start with Minecraft's hex code prefix
            builder.append("&#");

            // Get the difference 
            builder.append(
                String.format("%02x", (0 + (leftR - Math.round(stepR * i))))
            );
            builder.append(
                String.format("%02x", (0 + (leftG - Math.round(stepG * i))))
            );
            builder.append(
                String.format("%02x", (0 + (leftB - Math.round(stepB * i))))
            );

            builder.append(text.charAt(i));

            output.append(builder.toString());

        }

        return output.toString();

    }

}
