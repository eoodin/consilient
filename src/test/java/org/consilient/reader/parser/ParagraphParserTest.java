package org.consilient.reader.parser;

import org.consilient.reader.Paragraph;
import org.consilient.reader.SourceReaderContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ParagraphParserTest {

    private ParagraphParser parser;
    private SourceReaderContext context;

    @Before
    public void initialize() {
        parser = new ParagraphParser();
        context = new SourceReaderContext();
    }

    @Test
    public void oneLneTextShouldBeParsedAsOneParagraph() {
        context.setText("Single line.");
        Paragraph paragraph = parser.parse(context);

        assertNotNull(paragraph);
    }

    @Test
    public void emptyTextShouldNotBeParsedAsParagraph() {
        context.setText("");
        Paragraph paragraph = parser.parse(context);

        assertNull(paragraph);

        context.setText("\n");
        paragraph = parser.parse(context);

        assertNull(paragraph);
    }
}
