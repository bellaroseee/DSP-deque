package deque;

public class LinkedDeque<T> implements Deque<T> {
    private int size;
    private Node sentiel;

    public LinkedDeque() {
        size = 0;
        sentiel = new Node(null);
    }

    private class Node {
        private T value;
        Node prev;
        Node next;

        Node(T value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public void addFirst(T item) {
        Node i = new Node(item);
        //when LinkedDeque is empty
        if (sentiel.next == null) {
            i.next = sentiel;
            i.prev = sentiel;
            sentiel.next = i;
            sentiel.prev = i;
        } else {
            //when LinkedDeque is not empty
            sentiel.next.prev = i;
            i.next = sentiel.next;
            i.prev = sentiel;
            sentiel.next = i;
        }
        size += 1;
    }

    public void addLast(T item) {
        Node i = new Node(item);
        //when LinkedDeque is empty
        if (sentiel.next == null) {
            i.next = sentiel;
            i.prev = sentiel;
            sentiel.next = i;
            sentiel.prev = i;
        } else {
            //when LinkedDeque is not empty
            i.prev = sentiel.prev;
            sentiel.prev.next = i;
            sentiel.prev = i;
            i.next = sentiel;
        }
        size += 1;
    }

    public T removeFirst() {
        T i;
        if (size == 0) {
            return null;
        }
        //if there is only 1 node in LinkedDeque
        if (size == 1) {
            i = sentiel.next.value;
            sentiel.next = null;
            sentiel.prev = null;
        } else {
            //if there are more than 1 node in LinkedDeque
            i = sentiel.next.value;
            sentiel.next.next.prev = sentiel;
            sentiel.next = sentiel.next.next;
        }
        size -= 1;
        return i;
    }

    public T removeLast() {
        T i;
        if (size == 0) {
            return null;
        }
        //if there is only 1 node in LinkedDeque
        if (size == 1) {
            i = sentiel.prev.value;
            sentiel.next = null;
            sentiel.prev = null;
        } else {
            //if there are more than 1 node in LinkedDeque
            i = sentiel.prev.value;
            sentiel.prev = sentiel.prev.prev;
            sentiel.prev.next = sentiel;

        }
        size -= 1;
        return i;
    }

    public T get(int index) {
        T i;
        Node n = sentiel;
        if ((index >= size) || (index < 0)) {
            return null;
        }
        n = n.next;
        for (int j = 0; j < index; j++) {
            n = n.next;
        }
        i = n.value;
        return i;
    }

    public int size() {
        return size;
    }
}
