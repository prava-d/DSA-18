 public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Chicken val;
        Node prev;
        Node next;

        private Node(Chicken d, Node prev, Node next) {
            this.val = d;
            this.prev = prev;
            this.next = next;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Chicken c) {
        addLast(c);
    }

    public Chicken pop() {
        return removeLast();
    }

    public void addLast(Chicken c) {
        if (size == 0) {
            Node newNode = new Node(c, null, null);
            head = newNode;
            tail = newNode;
        }
        else {
            Node newNode = new Node(c, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
        
        size++;
    }

    public void addFirst(Chicken c) {
        if (size == 0) {
            Node newNode = new Node(c, null, null);
            head = newNode;
            tail = newNode;
        }
        else {
            Node newNode = new Node(c, null, head);
            head.prev = newNode;
            head = newNode;
        }
        
        size++;
    }

    public Chicken get(int index) {
        if (index >= size) {
            return null;
        }
        
        Node currNode = head;
        
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
            
        return currNode.val;
    }

    public Chicken remove(int index) {
        if (index >= size || size == 0) {
            return null;
        }
        else if (size == 1) {
            return head.val;
        }
        else if (index == 0) {
            Chicken tempChicken = removeFirst();
            return tempChicken;
        }
        else if (index == size - 1) {
            Chicken tempChicken = removeLast();
            return tempChicken;
        }
        else {
            Node currNode = head;
            
            for (int i = 0; i < index; i++) {
                currNode = currNode.next;
            }
            
            Chicken tempChicken = currNode.val;
            currNode.next.prev = currNode.prev;
            currNode.prev.next = currNode.next;
            
            size--;
            return tempChicken;
        }
    }

    public Chicken removeFirst() {
        if (size == 0) {
            return null;
        }
        else if (size == 1) {
            Chicken tempChicken = head.val;
            head = null;
            tail = null;
            size--;
            return tempChicken;
        }
        else {
            Chicken tempChicken = head.val;
            head = head.next;
            head.prev = null;
            size--;
            return tempChicken;
        }
    }

    public Chicken removeLast() {
        if (size == 0) {
            return null;
        }
        else if (size == 1) {
            Chicken tempChicken = head.val;
            head = null;
            tail = null;
            size--;
            return tempChicken;
        }
        else {
            Chicken tempChicken = tail.val;
            tail = tail.prev;
            tail.next = null;
            size--;
            return tempChicken;
        }
    }
}