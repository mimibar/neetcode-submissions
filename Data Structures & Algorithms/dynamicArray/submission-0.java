class DynamicArray {
    int size = 0;
    int capacity = 0;
    int[] array;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if (size == capacity)
            resize();
        array[size] = n;
        size++;
    }

    public int popback() {
        size--;
        int n = array[size];
        return n;
    }

    private void resize() {
        int[] b = new int[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            b[i] = array[i];
        }
        array = b;
        capacity *= 2;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
