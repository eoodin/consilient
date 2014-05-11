package org.consilient.model.source;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GuideParseTest {

    @Test
    public void whenNoH1HeadingFound_NoGuideInstanceCreated() {
        GuideParser guideParser = new GuideParser();

        String text = "This string contains no equal mark.";
        Guide[] guides = guideParser.parse(text);
        assertTrue(guides.length == 0);
    }

    @Test
    public void whenH1HeadingFound_AGuideInstanceCreated() {
//        String text = "Start Consilient\n" +
//                "================\n" +
//                "\n" +
//                "*Prerequisite*\n" +
//                "Consilient downloaded and installed properly.\n" +
//                "\n" +
//                "Start a your terminal, and type:\n" +
//                " java -jar Consilient.jar\n";
        String text = "Start Consilient\n" +
                "================\n" +
                "\n" +
                "*Prerequisite*\n" +
                "Consilient downloaded and installed properly.\n" +
                "\n" +
                "Start a your terminal, and type:\n" +
                " java -jar Consilient.jar\n";

    }
}
