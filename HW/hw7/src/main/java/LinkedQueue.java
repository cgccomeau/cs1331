import javafx.collections.ModifiableObservableListBase;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author ccomeau7
 * @version 2.0
 * @param <E>
 */
public class LinkedQueue<E> extends ModifiableObservableListBase<E>
    implements Iterable<E>, SimpleQueue<E> {

    private LinkedQueueNode<E> head;
    private int size = 0;

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private LinkedQueueNode<E> pointer = head;

            public boolean hasNext() {
                return pointer != null;
            }

            public E next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E answer = pointer.getData();
                pointer = pointer.getNext();
                return answer;
            }
        };
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        LinkedQueueNode<E> pointer = head;
        int start = 0;
        while (start < index) {
            pointer = pointer.getNext();
            start++;
        }
        return pointer.getData();
    }

    @Override
    public void enqueue(E element) {
        super.add(element);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        return super.remove(0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected void doAdd(int index, E element)
        throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        LinkedQueueNode<E> insert = new LinkedQueueNode<E>(element);
        LinkedQueueNode<E> bridge = null;
        LinkedQueueNode<E> pointer = head;

        if (index == 0) {
            head = insert;
            insert.setNext(pointer);
        } else if (index == size()) {
            for (int i = 0; i < size() - 1; i++) {
                pointer = pointer.getNext();
            }
            pointer.setNext(insert);
        } else {
            for (int i = 0; i < index - 1; i++) {
                pointer = pointer.getNext();
            }
            bridge = pointer.getNext();
            pointer.setNext(insert);
            insert.setNext(bridge);
        }
        size++;
    }

    @Override
    protected E doSet(int index, E element) throws
        UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected E doRemove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        LinkedQueueNode<E> pointer = head;
        LinkedQueueNode<E> result;
        LinkedQueueNode<E> bridge;

        if (index == 0) {
            bridge = pointer.getNext();
            result = pointer;
            pointer.setNext(null);
            head = bridge;
        } else {
            for (int i = 0; i < index - 1; i++) {
                pointer = pointer.getNext();
            }
            result = pointer.getNext();
            bridge = result.getNext();
            pointer.setNext(bridge);
        }
        size--;
        return result.getData();
    }

    @Override
    public void clear() {
        head.setNext(null);
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}