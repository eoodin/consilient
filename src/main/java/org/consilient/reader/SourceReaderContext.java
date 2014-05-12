package org.consilient.reader;

import org.consilient.util.Str;

public class SourceReaderContext {
    private RootElement rootElement;
    private Element currentElement;
    private int currentLine;
    private String[] lines;

    private static final String LN_UNIX = "\n";
    private static final String LN_WIN = "\r\n";
    private static final String LN_MAC = "\r";

    public SourceReaderContext() {
        rootElement = new RootElement();
        currentElement = rootElement;
    }

    public RootElement getRoot() {
        return rootElement;
    }

    public Element getCurrentElement() {
        return currentElement;
    }

    public void setCurrentElement(Element currentElement) {
        this.currentElement = currentElement;
    }

    public void setText(String text) {
        lines = Str.splitLines(text);
        currentLine = 0;
    }

    public int countReadLines() {
        return currentLine;
    }

    public String readLine() {
        if (lines.length <= currentLine)
            return null;

        return lines[currentLine++];
    }

    public int countTextLines() {
        return lines.length;
    }

    public void cursorBack(int steps) {
        currentLine -= steps;

        if (currentLine < 0)
            currentLine = 0;
    }
}
