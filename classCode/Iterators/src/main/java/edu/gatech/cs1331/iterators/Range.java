package edu.gatech.cs1331.iterators;

import java.util.Iterator;

public class Range implements Iterator<Integer> {

    private int begin;
    private int end;

    public Range(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public boolean hasNext() {
        return begin < end;
    }

    @Override
    public Integer next() {
        return begin++;
    }

    public static void main(String[] args) {
        Range zeroTen = new Range(0, 11);
        while(zeroTen.hasNext()) {
            int next = zeroTen.next();
            System.out.println("next = " + next);
        }
    }
}
