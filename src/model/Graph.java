package model;

public class Graph {

private Node[] vertices;
private int size;
private MinPriorityQueue queue;

	public Graph(int size) {
	    this.size = size;
	    vertices = new Node[size];
	    addNodes();
	    queue = new MinPriorityQueue(size);
	}
	
	

	private void addNodes() {
        for (int i = 1; i <= size; i++) {
            addNode(i);
        }
    }

    public void addNode(int name) {
        vertices[name - 1] = new Node(name);
    }

    public void addEdge(int sourceName, int destiName, int weight) {
        int srcIndex = sourceName - 1;
        int destiIndex = destiName - 1;
        Node srcNode = vertices[srcIndex];
        Node destiNode = vertices[destiIndex];
        srcNode.neighbourList = new Neighbour(destiIndex, srcNode.neighbourList, weight);
        destiNode.neighbourList = new Neighbour(srcIndex, destiNode.neighbourList, weight);
    }

    public void computeSortestPathsFrom(int sourceNodeName) {
        for (int i = 0; i < size; i++) {
            if (vertices[i].name == sourceNodeName) {
                applyDijkstraAlgorithm(vertices[i]);
                break;
            }
        }
    }


    private void applyDijkstraAlgorithm(Node sourceNode) {
        queue.add(sourceNode);
        sourceNode.state = State.IN_Q;
        sourceNode.cost = 0;
        while (!queue.isEmpty()) {
            Node visitedNode = queue.remove();
            visitedNode.state = State.VISITED;
            Neighbour connectedEdge = visitedNode.neighbourList;
            while (connectedEdge != null) {
                Node neighbour = vertices[connectedEdge.index];
                if (neighbour.state == State.NEW) {
                    queue.add(neighbour);
                    neighbour.state = State.IN_Q;
                }
                if (neighbour.state != State.VISITED && ((connectedEdge.weight + visitedNode.cost) < neighbour.cost)) {
                    neighbour.cost = connectedEdge.weight + visitedNode.cost;
                }
                connectedEdge = connectedEdge.next;
            }
        }
        
        for(int i = 0; i < size; i++){
            if(vertices[i].cost != Integer.MAX_VALUE){
                System.out.println("distance from "+sourceNode.name +" to "+vertices[i].name+" is " +vertices[i].cost);
            }else{
                System.out.println(vertices[i].name +" is not reachable from "+sourceNode.name);
            }
        }
    }
    
    public Node[] getVertices() {
		return vertices;
	}
}