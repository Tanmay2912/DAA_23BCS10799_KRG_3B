public class DAA_A4_PriorityQueue {
    static class Element {
        int data;
        int priority;
        Element(int data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }
    static class PriorityQueue {
        private Element[] queue;
        private int size;
        private int capacity;
        PriorityQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new Element[capacity];
            this.size = 0;
        }
        public void enqueue(int data, int priority) {
            if (size == capacity) {
                System.out.println("Queue is full!");
                return;
            }
            queue[size++] = new Element(data, priority);
        }
        private int getHighestPriorityIndex() {
            int highestPriority = Integer.MIN_VALUE;
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (queue[i].priority > highestPriority) {
                    highestPriority = queue[i].priority;
                    index = i;
                }
            }
            return index;
        }
        public void dequeue() {
            if (size == 0) {
                System.out.println("Queue is empty!");
                return;
            }
            int index = getHighestPriorityIndex();
            System.out.println("Dequeued: " + queue[index].data + " (Priority: " + queue[index].priority + ")");
            for (int i = index; i < size - 1; i++) {
                queue[i] = queue[i + 1];
            }
            queue[size - 1] = null;
            size--;
        }
        public void display() {
            if (size == 0) {
                System.out.println("Queue is empty!");
                return;
            }
            System.out.println("Current Priority Queue:");
            for (int i = 0; i < size; i++) {
                System.out.println("Data: " + queue[i].data + ", Priority: " + queue[i].priority);
            }
        }
    }
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(10);

        pq.enqueue(10, 2);
        pq.enqueue(30, 1);
        pq.enqueue(20, 3);
        pq.enqueue(5, 4);

        pq.display();
        pq.dequeue(); 
        pq.display();
    }
}
