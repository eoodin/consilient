package org.consilient.reader.parser;

import org.consilient.reader.Paragraph;
import org.consilient.reader.SourceReaderContext;

public class ParagraphParser {
    public Paragraph parse(SourceReaderContext context) {
        String first = context.readLine();
        String second = context.readLine();
        if (first == null || (first.trim().length() == 0 && second == null)) {
            context.cursorBack(2);
            return null;
        }

        return new Paragraph();
    }
}
