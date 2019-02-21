package model;

public class Neighbour {
    int index;
    int weight;
    Neighbour next;

    public Neighbour(int index, Neighbour next, int weight) {
        this.index = index;
        this.next = next;
        this.weight = weight;
    }
}
