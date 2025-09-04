class MyCircularQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false; 
        }
        queue[tail] = value;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false; 
        }
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int lastElementIndex = (tail - 1 + capacity) % capacity;
        return queue[lastElementIndex];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Checks whether the circular queue is full.
    public boolean isFull() {
        return size == capacity;
    }
}
