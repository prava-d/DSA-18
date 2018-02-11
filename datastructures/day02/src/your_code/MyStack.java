import java.util.LinkedList;

/**
 * An implementation of the Stack interface.
 */
public class MyStack implements StackADT<Integer> {

    private LinkedList<Integer> ll;
    private LinkedList<Integer> myList;
    private int size;

    public MyStack() {
        ll = new LinkedList<>();
        myList = new LinkedList<>();
        size = 0;
    }

    @Override
    public void push(Integer e) {
        ll.addFirst(e);
        
        if (size == 0 || e >= myList.peek()) {
            myList.addFirst(e);
        }
        
        size ++;
    }

    @Override
    public Integer pop() {
        Integer pop = ll.removeFirst();
        
        if (pop == myList.peek()) {
            myList.pop();
        }
        
        return pop;
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public Integer peek() {
        return ll.getFirst();
    }

    public Integer maxElement() {
        return myList.peek();
    }
}
