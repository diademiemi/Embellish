package me.diademiemi.embellish.tool;

public class Pattern {
    public static String stretchPattern(String[] pattern, String text) {
        double segment = (double) text.length() / pattern.length;
        StringBuilder builder = new StringBuilder();
        double position = 0;
        int colour = 0;
        while (position < text.length()) {
            // Check if the next one will overshoot, if it does, stretch to the end
            if (position + segment * 2 > text.length()) {
                builder.append(Tool.setSolidColour(pattern[colour], text.substring((int) Math.ceil(position), text.length())));
                position = text.length();
            } else if (position + segment <= text.length()) {
                builder.append(Tool.setSolidColour(pattern[colour], text.substring((int) Math.ceil(position), (int) Math.ceil(position + segment))));
                position = position + segment;
            }
            colour++;
        }
        return builder.toString();
    }
}
