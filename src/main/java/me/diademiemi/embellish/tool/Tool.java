package me.diademiemi.embellish.tool;


/**
 * Embellish functions to apply colours
 *
 * @author diademiemi
 */

public class Tool {

    /**
     * Set solid colour
     *
     * @param colour Colour to apply as a string
     * @param text  Text to colour
     * @return Text with colour codes injected
     */
    public static String setSolidColour(String colour, String text) {
        return "&#" + Colour.getColourByName(colour) + text;
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
        int leftR = Integer.valueOf(Colour.getColourByName(colourLeft).substring(0, 2), 16);
        int leftG = Integer.valueOf(Colour.getColourByName(colourLeft).substring(2, 4), 16);
        int leftB = Integer.valueOf(Colour.getColourByName(colourLeft).substring(4, 6), 16);

        // Get the integers of the right colour
        int rightR = Integer.valueOf(Colour.getColourByName(colourRight).substring(0, 2), 16);
        int rightG = Integer.valueOf(Colour.getColourByName(colourRight).substring(2, 4), 16);
        int rightB = Integer.valueOf(Colour.getColourByName(colourRight).substring(4, 6), 16);

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
