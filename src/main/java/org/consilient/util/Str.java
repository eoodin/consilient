package org.consilient.util;

import java.util.ArrayList;
import java.util.List;

public class Str {
    public static final String LN_UNIX = "\n";
    public static final String LN_WIN = "\r\n";
    public static final String LN_MAC = "\r";

    public static String[] split(String text, String ter) {
        if (text == null)
            return new String[0];

        List<String> list = new ArrayList<String>();

        int start = -1;
        int end = 0;
        int ln = ter.length();

        while (true){
            start = text.indexOf(ter, start + ln);
            if (start == -1)
                break;

            list.add(text.substring(end, start));
            end = start + ln;
        }

        list.add(text.substring(end, text.length()));
        String[] splits = new String[list.size()];
        list.toArray(splits);
        return  splits;
    }


    public static String detectLineTerminator(String text) {
        if (text == null)
            return LN_UNIX;

        int crPos = text.indexOf('\r');
        if (crPos == -1)
            return LN_UNIX;

        int lnPos = text.indexOf('\n');
        if (lnPos == crPos +1)
            return LN_WIN;

        return LN_MAC;
    }

    public static String[] splitLines(String text) {
        String ln = detectLineTerminator(text);
        return split(text, ln);
    }

    public static int countSequence(String text, String pattern) {
        if (!text.startsWith(pattern))
            return 0;

        int hit = 0;
        int pl = pattern.length();
        while (-1 != text.indexOf(pattern, hit * pl))
            hit ++;

        return hit;
    }
}
