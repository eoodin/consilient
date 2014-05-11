package org.consilient.reader;

public class SourceReader {

    public Element parse(String text) {
        SourceReaderContext context = new SourceReaderContext();
        context.setText(text);

        String firstLine = context.readLine();
        String secondLine = context.readLine();
        if (secondLine == null) {
            if (firstLine.startsWith("#")) {
                int hashCount = 1;
                while (-1 != firstLine.indexOf('#', hashCount))
                    hashCount++;
                Heading heading = new Heading();
                heading.setLevel(hashCount);
                return heading;
            }
        }

        Heading heading = new Heading();
        if (secondLine != null && secondLine.trim().matches("\\-*"))
            heading.setLevel(2);

        return heading;
    }
}
