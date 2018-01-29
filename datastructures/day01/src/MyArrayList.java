public class MyArrayList {
    private Cow[] elems;
    private int size;

    // Runtime: O(1)
    public MyArrayList() {
        elems = new Cow[10];
        size = 0;
    }

    // Runtime: O(1)
    public MyArrayList(int capacity) {
        elems = new Cow[capacity];
        size = 0;
    }

    // Runtime: O(1)*
    public void add(Cow c) {
        if (elems.length == size) {
            grow();
        }

        elems[size] = c;

        size++;
    }

    // Runtime: O(1)
    public int size() {
        return size;
    }

    // Runtime: O(1)
    public Cow get(int index) {
        if (elems[index] == null) {
            throw new IndexOutOfBoundsException("No cow exists at the provided index.");
        }

        return elems[index];
    }

    // Runtime: O(N)
    public Cow remove(int index) {

        if (index >= elems.length || index < 0) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }
        else if (elems[index] == null) {
            throw new IndexOutOfBoundsException("No cow exists at the provided index.");
        }

        Cow removedCow = elems[index];
        elems[index] = null;
        
        for (int i = index + 1; i < size; i++) {
            elems[i - 1] = elems[i];
        }
        
        size--;

        if (size >=4 && size < 0.25 * elems.length) {
            reduce();
        }

        return removedCow;
    }

    // Runtime: O(N)
    public void add(int index, Cow c) {

        if (elems.length == size) {
            grow();
        }

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }

        for (int i = size + 1; i > index; i--) {
            elems[i] = elems[i - 1];
        }

        elems[index] = c;

        size++;
    }

    // Runtime: O(N)
    public void grow() {
        Cow[] temp = new Cow[elems.length * 2];
        System.arraycopy(elems, 0, temp, 0, size);
        elems = temp;
    }

    // Runtime: O(N)
    public void reduce() {
        Cow[] temp = new Cow[elems.length / 2];
        System.arraycopy(elems, 0, temp, 0, size);
        elems = temp;
    }
}
