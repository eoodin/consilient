package org.consilient.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrTest {

    @Test
    public void splitString() {
        String [] lines = Str.split("Hello\n\nworld\n\n", "\n");
        assertEquals(5, lines.length);
        assertEquals("Hello", lines[0]);
        assertEquals("", lines[1]);
        assertEquals("world", lines[2]);
        assertEquals("", lines[4]);

        lines = Str.split("aaa", "\n");
        assertEquals(1, lines.length);
        assertEquals("aaa", lines[0]);

        lines = Str.split("aaa\n", "\n");
        assertEquals(2, lines.length);
        assertEquals("", lines[1]);

        lines = Str.split("aaa\nbbb", "\n");
        assertEquals(2, lines.length);
        assertEquals("bbb", lines[1]);
    }

    @Test
    public void stringInUnixFormatSplit() {
        String[] lines = Str.splitLines("Hello\nWorld");
        assertEquals(2, lines.length);
        assertEquals("Hello", lines[0]);
        assertEquals("World", lines[1]);
    }

    @Test
    public void stringInMacFormatSplit() {
        String[] lines = Str.splitLines("Hello\rWorld");
        assertEquals(2, lines.length);
        assertEquals("Hello", lines[0]);
        assertEquals("World", lines[1]);
    }

    @Test
    public void stringInWindowsFormatSplit() {
        String[] lines = Str.splitLines("Hello\r\nWorld");
        assertEquals(2, lines.length);
        assertEquals("Hello", lines[0]);
        assertEquals("World", lines[1]);
    }

    @Test
    public void noLineBreakShouldBeDetectedAsUnix() {
        assertEquals(Str.LN_UNIX, Str.detectLineTerminator("string without line end."));
    }

    @Test
    public void crWithoutLnFollowedShouldBeDetectedAsMac() {
        assertEquals(Str.LN_MAC, Str.detectLineTerminator("mac format\r"));
    }

    @Test
    public void crWithLnFollowedShouldBeDetectedAsWindows() {
        assertEquals(Str.LN_WIN, Str.detectLineTerminator("Windows format\r\n"));
    }
}
