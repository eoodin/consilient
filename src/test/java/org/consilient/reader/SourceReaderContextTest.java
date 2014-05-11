package org.consilient.reader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class SourceReaderContextTest {

    private SourceReaderContext readerContext;

    @Before
    public void setup() {
        readerContext = new SourceReaderContext();
    }

    @Test
    public void initializedContextShouldHasRootElementAsCurrentElement() {
        RootElement rootElement = readerContext.getRoot();
        assertNotNull(rootElement);
        assertEquals(readerContext.getCurrentElement(), rootElement);
    }

    @Test
    public void contextCountLinesAfterTextSet() {
        readerContext.setText("Hello\n\n\nworld\n");
        assertEquals(5, readerContext.countTextLines());
    }

    @Ignore
    @Test
    public void contextRememberLinesHaveBeenRead() {
        readerContext.setText("Hello\nworld");
        assertEquals(0, readerContext.countReadLines());

        String line = readerContext.readLine();
        assertEquals("Hello", line);
        assertEquals(1, readerContext.countReadLines());

        line = readerContext.readLine();
        assertEquals("world", line);
        assertEquals(2, readerContext.countReadLines());

        line = readerContext.readLine();
        assertEquals(line, "");
        assertEquals(3, readerContext.countReadLines());

        line = readerContext.readLine();
        assertNull(line);
        assertEquals(3, readerContext.countReadLines());
    }
}
