package edu.gatech.cs1331.exam3review;

import java.util.Iterator;

public class MyStuff implements Iterable<String> {

    private class Msi implements Iterator<String> {

        private int i;

        @Override
        public boolean hasNext() {
            return i < stuff.length;
        }

        @Override
        public String next() {
            return stuff[i++];
        }
    }

    private String[] stuff = {"foo", "bar", "baz"};

    @Override
    public Iterator<String> iterator() {
        return new Msi();
    }

    interface I {
        int a(String a);
    }

    public static void main(String[] args) {
        // sugar
        I i = (String s) -> s.length();
        // Desugar
        I i2 = new I() {
            public int a(String s) {
                return s.length();
            }
        };

        // De-sugared version
        Iterator<String> iter = new MyStuff().iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
            // String thing = iter.next();
            // System.out.println("sugared thing = " + thing);
        }

        // Sugared version
        for(String thing: new MyStuff()) {
            System.out.println("desugared thing = " + thing);
        }
    }
}
