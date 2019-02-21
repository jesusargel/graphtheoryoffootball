package model;

public class MinPriorityQueue {
    Node[] queue;
    int maxSize;
    int rear = -1, front = -1;

    MinPriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new Node[maxSize];
    }

    public void add(Node node) {
        queue[++rear] = node;
    }

    public Node remove() {
        Node minValuedNode = null;
        int minValue = Integer.MAX_VALUE;
        int minValueIndex = -1;
        front++;
        for (int i = front; i <= rear; i++) {
            if (queue[i].state == State.IN_Q && queue[i].cost < minValue) {
                minValue = queue[i].cost;
                minValuedNode = queue[i];
                minValueIndex = i;
            }
        }

        swap(front, minValueIndex); // this ensures deletion is still done
                                    // from front;
        queue[front] = null;// lets not hold up unnecessary references in
                            // the queue
        return minValuedNode;
    }

    public void swap(int index1, int index2) {
        Node temp = queue[index1];
        queue[index1] = queue[index2];
        queue[index2] = temp;
    }

    public boolean isEmpty() {
        return front == rear;
    }
}
