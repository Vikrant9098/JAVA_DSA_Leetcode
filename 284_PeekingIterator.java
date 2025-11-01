// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator; // stores the original iterator
    private Integer nextElement;        // stores the next element for peek
    private boolean hasNext;            // indicates if there's a next element

    public PeekingIterator(Iterator<Integer> iterator) {
        // assign the given iterator
        this.iterator = iterator;

        // if iterator has an element, store it for peek
        if (iterator.hasNext()) {
            nextElement = iterator.next();
            hasNext = true; // mark true since there is a next element
        } else {
            hasNext = false; // mark false if iterator is empty
        }
    }

    // return next element without moving the iterator
    public Integer peek() {
        return nextElement; // simply return stored next value
    }

    @Override
    public Integer next() {
        // save current element to return
        Integer current = nextElement;

        // if more elements exist, move to next
        if (iterator.hasNext()) {
            nextElement = iterator.next();
        } else {
            // no next element, mark hasNext false and clear nextElement
            hasNext = false;
            nextElement = null;
        }

        // return the current element
        return current;
    }

    @Override
    public boolean hasNext() {
        // return if there’s another element
        return hasNext;
    }
}
