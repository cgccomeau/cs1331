/**
 * @author ccomeau7
 * @version 1.0
 * @param <E> is the generic type to be later defined
 * defines the MyList generics class
 */
public class MyList<E> implements List<E> {
    private E[] elements;
    private int size;

    /**
     * No args constructor for MyList
     */
    public MyList() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * @param capacity int
     */
    public MyList(int capacity) {
        elements = (E[]) new Object[capacity];
        size = 0;
    }

    @Override
    public void add(E e) throws IllegalArgumentException {
        if (e == null) {
            throw new IllegalArgumentException("Argument cannot be null!");
        }
        boolean done = false;
        if (size() == elements.length) {
            E[] newElements = (E[]) new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            newElements[elements.length] = e;
            elements = newElements;
        } else {
            for (int i = 0; i < elements.length && !done; i++) {
                if (elements[i] == null) {
                    elements[i] = e;
                    done = true;
                }
            }
        }
        size++;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds!");
        }
        return elements[index];
    }

    @Override
    public void replace(E e, E replaceWith) throws IllegalArgumentException {
        if (e == null || replaceWith == null) {
            throw new IllegalArgumentException("Argument(s) cannot be null!");
        }

        for (int i = 0; i < elements.length && elements[i] != null; i++) {
            if (elements[i].equals(e)) {
                elements[i] = replaceWith;
            }
        }
    }

    @Override
    public int remove(E e) throws IllegalArgumentException {
        int count = 0;
        if (e == null) {
            throw new IllegalArgumentException("Argument cannot be null!");
        }

        for (int i = 0; i < elements.length && elements[i] != null; i++) {
            if (elements[i].equals(e)) {
                elements[i] = null;
                count++;
            }
        }
        boolean done = false;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                for (int j = i + 1; j < elements.length && !done; j++) {
                    if (elements[j] != null) {
                        elements[i] = elements[j];
                        elements[j] = null;
                        done = true;
                    }
                }
            }
            done = false;
        }
        size -= count;
        return count;
    }

    @Override
    public int contains(E e) throws IllegalArgumentException {
        int count = 0;
        if (e == null) {
            throw new IllegalArgumentException("Argument cannot be null!");
        }

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null && elements[i].equals(e)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray(E[] e) throws IllegalArgumentException {
        if (e == null) {
            throw new IllegalArgumentException("Argument cannot be null!");
        }
        for (int i = 0; i < e.length && i < elements.length; i++) {
            e[i] = elements[i];
        }
        if (e.length > size()) {
            for (int i = size(); i < e.length; i++) {
                e[i] = null;
            }
        }

        return e;
    }
}
