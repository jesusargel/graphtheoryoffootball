package model;

public class Player {
	
	private int myNumber;
	private String myName;
	private int proximity;
	
	

	public Player(String name, int number)
	{
		this.myName = name;
		this.myNumber = number;
	}

	public int getMyNumber() {
		return myNumber;
	}

	public void setMyNumber(int myNumber) {
		this.myNumber = myNumber;
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}
	
	public int getProximity() {
		return proximity;
	}

	public void setProximity(int proximity) {
		this.proximity = proximity;
	}

}
