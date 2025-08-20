class MyCircularQueue {

    int[] q;
    int front = 0,
        rear = 0,
        size = 0;

    public MyCircularQueue(int k) {
        
        q = new int [k];
    }
    
    public boolean enQueue(int value) {
        
        if (isFull())
            return false;

        q[rear] = value;
        rear = (rear + 1) % q.length;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        
        if (isEmpty())
            return false;

        q[front] = -1;
        front = (front + 1) % q.length;
        size--;
        return true;
    }
    
    public int Front() {
        
        if (isEmpty())
            return -1;

        return q[front];
    }
    
    public int Rear() {
        
        if (isEmpty())
            return -1;

        return q[(rear - 1 + q.length) % q.length];
    }
    
    public boolean isEmpty() {
        
        return size == 0;
    }
    
    public boolean isFull() {
        
        return size == q.length;
    }
}
