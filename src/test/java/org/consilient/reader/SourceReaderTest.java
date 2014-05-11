package org.consilient.reader;

import static org.junit.Assert.*;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SourceReaderTest {

    private SourceReader sourceReader;

    @Before
    public void initializeReader() {
        sourceReader = new SourceReader();
    }


    @Test
    public void secondLineIsSeriesOfEqualMarks_H1ShouldBeGiven() {
        String text =  "Hello\n===\n";
        Element root = sourceReader.parse(text);
        assertThat(root, new IsInstanceOf(Heading.class));

        Heading heading = (Heading) root;
        assertEquals(heading.getLevel(), 1);
    }

    @Test
    public void secondLineIsSeriesOfDashMarks_H2ShouldBeGiven() {
        String text =  "Dash\n----\n";
        Element root = sourceReader.parse(text);
        assertThat(root, new IsInstanceOf(Heading.class));

        Heading heading = (Heading) root;
        assertEquals(heading.getLevel(), 2);
    }

    @Test
    public void whenLineStartWithNHashAndSpaceAndText_HNShouldBeGiven() {
        Element root = sourceReader.parse("# Intent to be H1");
        assertThat(root, new IsInstanceOf(Heading.class));

        Heading heading = (Heading) root;
        assertEquals(heading.getLevel(), 1);

        root = sourceReader.parse("## Intent to be H2");
        assertThat(root, new IsInstanceOf(Heading.class));

        heading = (Heading) root;
        assertEquals(heading.getLevel(), 2);

        root = sourceReader.parse("### Intent to be H3");
        assertThat(root, new IsInstanceOf(Heading.class));

        heading = (Heading) root;
        assertEquals(heading.getLevel(), 3);
    }

}
