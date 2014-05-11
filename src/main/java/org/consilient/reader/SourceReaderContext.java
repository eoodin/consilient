package org.consilient.reader;

import com.sun.deploy.util.StringUtils;
import org.consilient.util.Str;

import java.util.ArrayList;
import java.util.List;

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
}
