package org.example;

import java.util.LinkedList;

public class Tape {
    private LinkedList<String> source = new LinkedList<String>(); // this will represente our inifinite tape.
    private int index = 0;

    public Tape(String source) {
        // to inisialise the tape at a state
        if (source.length() == 0) {
            this.source.add(" ");
            return;
        }
        for (int i = 0; i < source.length(); i++) {
            this.source.add(String.valueOf(source.charAt(i)));
        }
    }

    public String read() {
        // to read the character under the index .
        return source.get(index);
    }

    public void write(String replace, String direction) {
        // to write into the curent index and change to the left or right .
        source.set(index, replace);
        if (direction.equals("L")) {
            --index;
            if (index < 0) {
                source.addFirst(" ");
                index = 0;
            }
        }
        if (direction.equals("R")) {
            ++index;
            if (index >= source.size() - 1) {
                source.addLast(" ");
            }
        }
    }

    @Override
    public String toString() {
        String strBuffer = "";
        for (String str : source) {
            strBuffer = strBuffer + str;
        }
        return strBuffer;
    }

    public int getIndex() {
        return index;
    }

}
