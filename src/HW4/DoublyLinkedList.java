package HW4;

public class DoublyLinkedList<E> {
    // ------------- nested Node class -----------------
    private static class Node<E> {
        // instance variables
        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the next node in the linked list
        private Node<E> previous;
        // constructor
        public Node(E e, Node<E> n, Node<E> p) {
            element = e;
            next = n;
            previous = p;
        }
        // methods
        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        public Node<E> getPrevious() {return previous;}
        public void setNext(Node<E> n) { next = n; }
        public void setPrevious(Node<E> p){ previous = p;}
    } // end of nested Node class

    // instance variables for SinglyLinkedList
    private Node<E> head = null; // head node of the list (or null if empty)
    private Node<E> tail = null; // tail node of the list (or null if empty)
    private int size = 0; // number of nodes in the list

    // constructor
    public DoublyLinkedList() {} // constructs an initially empty list

    // access methods
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }



    public E first() { // returns (but does not remove) the first element
        if ( this.isEmpty() ) return null;
        return head.getElement(); // will fail if head is null
    }
    public E last() { // returns (but does not remove) the last element
        if ( this.isEmpty() ) return null;
        return tail.getElement(); // will fail if head is null
    }
    public String toString() {
        String sb = "";
        if (isEmpty()) return null;
        sb += "1. " + head.getElement() + "\n";
        Node<E> nextnode = head.getNext();
        for (int i=2; i<=this.size(); i++) {
            sb += (i) + ". " + nextnode.getElement() + "\n";
            nextnode = nextnode.getNext();
        }
        return sb;
    }



    // update methods
    public void addFirst(E e) { // add element e to the front of the list
        head = new Node<>(e, head, null); // create and link a new node
        if (size == 0) {
            tail = head; // special case: new node becomes tail also
        }
        size++;
    }
    public void addLast(E e) { // add element e to the end of the list
        Node<E> temp_previous = tail;
        Node<E> new_tail = new Node<>(e, null, temp_previous); // create Node for new tail
        if (isEmpty()) {
            head = new_tail;
        }
        else {
            tail.setNext(new_tail); // point old tail to new tail
        }
        tail = new_tail; // point tail to new tail
        size++;
    }
    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) return null;
        E old_head = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) tail = null; // special case for list with one cell
        return old_head;
    }


    public static void main(String[] args) {
        System.out.println("I compiled.");
        DoublyLinkedList<String> names = new DoublyLinkedList<>();

        names.addFirst("Ralph");
        System.out.println(names.first());
        System.out.println(names.last());
        names.addFirst("Savannah");
        System.out.println(names.first());
        System.out.println(names.last());
        names.addLast("Sindi");
        System.out.println(names);
        names.removeFirst();
        System.out.println(names);

    }

}