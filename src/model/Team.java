package model;

import java.util.Vector;

public class Team {
	
	private  Vector<Player> players;
	private Vector<Integer> numbers;
	private String teamName;
	private int[][] adjacencyMatrix;
	private double[][] proximityMatrix;
	private double maxWidth;
	private String[] playerNames;

	


	public Team()
	{
		
	}
	
	public Team(String name){
		
		this.teamName = name;
		
		
	}
	
	public Vector<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Vector<Player> players) {
		this.players = players;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}

	public double[][] getProximityMatrix() {
		return proximityMatrix;
	}

	public void setProximityMatrix(double[][] proximityMatrix) {
		this.proximityMatrix = proximityMatrix;
	}

	
	public Vector<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(Vector<Integer> numbers) {
		this.numbers = numbers;
	}

	public double getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(double maxWidth) {
		this.maxWidth = maxWidth;
	}

	public String[] getPlayerNames() {
		return playerNames;
	}

	public void setPlayerNames(String[] playerNames) {
		this.playerNames = playerNames;
	}

}
