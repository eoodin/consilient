package org.consilient.reader;

public class Heading implements Element {
    private int level;

    public Heading() {
        this.level = 1;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
