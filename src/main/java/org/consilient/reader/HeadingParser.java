package org.consilient.reader;

import org.consilient.util.Str;

public class HeadingParser {
    public static final String HEADING_SIGN = "#";


    public Heading parse(SourceReaderContext context) {
        Heading heading;

        String firstLine = context.readLine();
        int headingSignCount = Str.countSequence(firstLine, HEADING_SIGN);
        if (headingSignCount > 0) {
            heading = new Heading();
            heading.setLevel(headingSignCount);
            return  heading;
        }

        String secondLine = context.readLine();
        if (secondLine == null) {
            context.cursorBack(2);
            return null;
        }

        secondLine = secondLine.trim();
        int equalMarkCount = Str.countSequence(secondLine, "=");
        if (equalMarkCount > 0 && equalMarkCount == secondLine.length()) {
            heading = new Heading();
            heading.setLevel(1);
            return heading;
        }

        int dashCount = Str.countSequence(secondLine, "-");
        if (dashCount > 0 && dashCount == secondLine.length()) {
            heading = new Heading();
            heading.setLevel(2);
            return heading;
        }

        context.cursorBack(2);
        return null;
    }
}
