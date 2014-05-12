package org.consilient.reader.parser;

import org.consilient.reader.Heading;
import org.consilient.reader.SourceReaderContext;
import org.consilient.reader.parser.HeadingParser;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeadingParserTest {

    private HeadingParser parser;
    private SourceReaderContext context;

    @Before
    public void initialize() {
        parser = new HeadingParser();
        context = new SourceReaderContext();
    }
        
    @Test
    public void secondLineIsSeriesOfEqualMarks_H1ShouldBeGiven() {
        context.setText("Hello\n===\n");
        Heading heading = parser.parse(context);

        assertNotNull(heading);
        assertEquals(1, heading.getLevel());
    }

    @Test
    public void secondLineIsSeriesOfDashMarks_H2ShouldBeGiven() {
        context.setText("Dash\n----\n");
        Heading heading = parser.parse(context);
        assertThat(heading, new IsInstanceOf(Heading.class));

        assertEquals(heading.getLevel(), 2);
    }

    @Test
    public void whenLineStartWithNHashAndSpaceAndText_HNShouldBeGiven() {
        context.setText("# Intent to be H1");
        Heading heading = parser.parse(context);
        assertNotNull(heading);
        assertEquals(heading.getLevel(), 1);

        context.setText("### Intent to be H3");
        heading = parser.parse(context);
        assertNotNull(heading);
        assertEquals(heading.getLevel(), 3);

        context.setText("###### Intent to be H6");
        heading = parser.parse(context);
        assertNotNull(heading);
        assertEquals(heading.getLevel(), 6);
    }

    @Test
    public void nonHeadingText_ShouldGetNullAndContextRollback() {
        String nonHeadingLine = "No hash prefix, no dash or equal in next line.";
        context.setText(nonHeadingLine);

        assertNull(parser.parse(context));
        assertEquals(nonHeadingLine, context.readLine());

        nonHeadingLine = "Two lines\n second line is not heading mark";
        context.setText(nonHeadingLine);
        assertNull(parser.parse(context));
        assertEquals("Two lines", context.readLine());
    }

    @Test
    public void emptyLine_ShouldGetNullAndContextRollback() {
        context.setText("");

        assertNull(parser.parse(context));
        assertEquals("", context.readLine());
    }
}
