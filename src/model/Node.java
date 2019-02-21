package model;

public class Node {
    int name;
    int cost;
    

	Neighbour neighbourList;
    State state;

    Node(int name) {
        this.name = name;
        state = State.NEW;
        cost = Integer.MAX_VALUE;
    }
    
    public int getCost() {
		return cost;
	}
}
