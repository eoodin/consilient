package org.consilient.reader;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SourceReaderContextTest {

    private SourceReaderContext context;

    @Before
    public void setup() {
        context = new SourceReaderContext();
    }

    @Test
    public void initializedContextShouldHasRootElementAsCurrentElement() {
        RootElement rootElement = context.getRoot();
        assertNotNull(rootElement);
        assertEquals(context.getCurrentElement(), rootElement);
    }

    @Test
    public void contextCountLinesAfterTextSet() {
        context.setText("Hello\n\n\nworld\n");
        assertEquals(5, context.countTextLines());
    }

    @Test
    public void linesCanBeReadAgainAfterMoveCursorBack() {
        context.setText("Line 1\nLine 2\nLine 3");
        context.readLine();
        String line2 = context.readLine();
        assertEquals("Line 2", line2);

        context.cursorBack(2);
        assertEquals("Line 1", context.readLine());
    }

    @Test
    public void whenCursorMoveBackTooMuch_CursorStayAtBegining() {
        context.setText("Line 1\nLine 2\nLine 3");
        context.readLine();
        context.readLine();
        context.cursorBack(10);
        assertEquals("Line 1", context.readLine());
    }
    
    @Test
    public void contextRememberLinesHaveBeenRead() {
        context.setText("Hello\nworld\n");
        assertEquals(0, context.countReadLines());

        assertEquals("Hello", context.readLine());
        assertEquals(1, context.countReadLines());

        assertEquals("world", context.readLine());
        assertEquals(2, context.countReadLines());

        assertEquals("", context.readLine());
        assertEquals(3, context.countReadLines());

        assertNull(context.readLine());
        assertEquals(3, context.countReadLines());
    }
}
