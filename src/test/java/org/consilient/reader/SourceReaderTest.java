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

//    @Ignore
//    @Test
//    public void whenNormalTextInLineRead_TextElementShouldBeCreated() {
//        Element root = sourceReader.parse("Normal text in line");
//        assertThat(root, new IsInstanceOf(TextElement.class));
//    }


}
