class MyCircularDeque {

    int[] arr;
    int front,
        rear,
        size,
        capacity;

    public MyCircularDeque(int k) {

        arr = new int[k];
        capacity = k;
        size = 0;
        front = 0;
        rear = k - 1;        
    }
    
    public boolean insertFront(int value) {
        
        if (isFull())
            return false;

        size = size + 1;
        front = front - 1;

        if (front < 0)
            front = front + capacity;

        arr[front] = value;
        return true;
    }
    
    public boolean insertLast(int value) {
        
        if (isFull())
            return false;

        size = size + 1;
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        return true;
    }
    
    public boolean deleteFront() {
        
        if (isEmpty())
            return false;

        size = size - 1;
        front = (front + 1) % capacity;
        return true;
    }
    
    public boolean deleteLast() {
        
        if (isEmpty())
        return false;

        size = size - 1;
        rear = rear - 1;
        if (rear < 0)
            rear = rear + capacity;

        return true;
    }
    
    public int getFront() {
        
        if (isEmpty())
            return -1;
        
        return arr[front];
    }
    
    public int getRear() {
        
        if (isEmpty())
            return -1;
        
        return arr[rear];
    }
    
    public boolean isEmpty() {
        
        return size == 0;
    }
    
    public boolean isFull() {
        
        return size == capacity;
    }
}
