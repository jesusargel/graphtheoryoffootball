package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;


public class Engine {
	
	private Team myTeam1;
	private Team myTeam2;
	private File myFile;
	private Vector<Team> myTeams;
	private Graph g1;
	private Graph g2;
	
	public Engine(File file)
	{
		this.myFile = file;
		myTeam1 = new Team();
		myTeam2 = new Team();
		myTeams = new Vector<Team>();
		g1 = new Graph(11);
		g2 = new Graph(11);
		for(int i = 1; i < 12; i++)
		{
			g1.addEdge(i, i, 0);
			g2.addEdge(i, i, 0);
		}
		this.readFile();
	}
	
	

	private void readFile()
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner("it");
		try {
			sc = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		myTeam1.setTeamName(sc.nextLine());
		String[] team1Names = new String[11];
		Vector<Player> playersFound1 = new Vector<Player>();
		Vector<Integer> numbersFound1 = new Vector<Integer>();
		for(int i = 0; i < 11; i ++)
		{
			int numberFound = sc.nextInt();
			String nameFound = sc.next();
			team1Names[i] = nameFound;
			Player playerFound = new Player(nameFound, numberFound);
			playerFound.setProximity(i);
			numbersFound1.addElement(numberFound);
			playersFound1.addElement(playerFound);
		}
		myTeam1.setPlayerNames(team1Names);
		myTeam1.setPlayers(playersFound1);
		myTeam1.setNumbers(numbersFound1);
		
		sc.nextLine();
		myTeam2.setTeamName(sc.nextLine());
		String[] team2Names = new String[11];
		Vector<Integer> numbersFound2 = new Vector<Integer>();
		Vector<Player> playersFound2 = new Vector<Player>();
		for(int i = 0; i < 11; i ++)
		{
			int numberFound = sc.nextInt();
			String nameFound = sc.next();
			team2Names[i] = nameFound;
			Player playerFound = new Player(nameFound, numberFound);
			playerFound.setProximity(i);
			numbersFound2.addElement(numberFound);
			playersFound2.addElement(playerFound);
		}
		myTeam2.setPlayerNames(team2Names);
		myTeam2.setPlayers(playersFound2);
		myTeam2.setNumbers(numbersFound2);
		
		
		sc.next();
		
		int indexFrom;
		int indexTo;
		
		int weight1;
		int from1;
		int to1;
		double maxWidth1= 0;
		int[][] adjacency1 = new int[11][11];
		double[][] proximity1 = new double[11][11];
		for(int i = 0; i < 11; i++)
		{
			for(int j = 0; j < 11; j++)
			{
				adjacency1[i][j] = 0;
				proximity1[i][j] = (double) 0.0;
			}
		}
		int k = 0;
		
		while(k < 55)
		{
			
				from1 = sc.nextInt();
				to1 = sc.nextInt();
				weight1 = sc.nextInt();
				indexFrom = myTeam1.getNumbers().indexOf(from1);
				indexTo = myTeam1.getNumbers().indexOf(to1);
				adjacency1[indexFrom][indexTo] = weight1;
				adjacency1[indexTo][indexFrom] = weight1;
				g1.addEdge(indexFrom + 1, indexTo + 1, 100/weight1);
				g1.addEdge(indexTo + 1, indexFrom + 1, 100/weight1);
				if(weight1 > maxWidth1)
				{
					maxWidth1 = weight1;
				}
				proximity1[indexFrom][indexTo] = (double)1/weight1;
				proximity1[indexTo][indexFrom] = (double)1/weight1;
			k++;
			
		}
		myTeam1.setMaxWidth(maxWidth1);
		myTeam1.setAdjacencyMatrix(adjacency1);
		myTeam1.setProximityMatrix(proximity1);
		
		sc.next();
		int weight2;
		int from2;
		int to2;
		double maxWidth2= 0;
		int[][] adjacency2 = new int[11][11];
		double[][] proximity2 = new double[11][11];
		for(int i = 0; i < 11; i++)
		{
			for(int j = 0; j < 11; j++)
			{
				adjacency2[i][j] = 0;
				proximity2[i][j] = (double) 0.0;
			}
		}
		k = 0;
		while(k < 55)
		{
			
				from2 = sc.nextInt();
				to2 = sc.nextInt();
				weight2 = sc.nextInt();
				indexFrom = myTeam2.getNumbers().indexOf(from2);
				indexTo = myTeam2.getNumbers().indexOf(to2);
				adjacency2[indexFrom][indexTo] = weight2;
				adjacency2[indexTo][indexFrom] = weight2;
				g2.addEdge(indexFrom + 1, indexTo + 1, 100/weight2);
				g2.addEdge(indexTo + 1, indexFrom + 1, 100/weight2);
				if(weight2 > maxWidth2)
				{
					maxWidth2 = weight2;
				}

				proximity2[indexFrom][indexTo] = (double)1/weight2;
				proximity2[indexTo][indexFrom] = (double)1/weight2;
			k++;
			
		}
		myTeam2.setMaxWidth(maxWidth2);
		myTeam2.setAdjacencyMatrix(adjacency2);
		myTeam2.setProximityMatrix(proximity2);
		
		myTeams.addElement(myTeam1);
		myTeams.addElement(myTeam2);	
	}
	
	
	
	public Vector<Player> shortestPath(int team, int source)
	{
		Vector<Player> shortestP = new Vector<Player>();
		
		return shortestP;
	}
	
	public void printAdjacencyMatrix(int num)
	{
		System.out.println("Adjacency Matrix for " + this.myTeams.elementAt(num-1).getTeamName());
		for(int i = 0; i < 11; i++)
		{
			for(int j = 0; j < 11; j++)
			{
				System.out.print(this.myTeams.elementAt(num-1).getAdjacencyMatrix()[i][j] + " | ");
			}
			System.out.println("");
		}	
	}
	
	public void printProximityMatrix(int num)
	{
		System.out.println("Proximity Matrix for " + this.myTeams.elementAt(num-1).getTeamName());	
		for(int i = 0; i < 11; i++)
		{
			for(int j = 0; j < 11; j++)
			{
				System.out.print(this.myTeams.elementAt(num-1).getProximityMatrix()[i][j] + " | ");
			}
			System.out.println("");
		}
	}
	
	public Team getMyTeam1() {
		return myTeam1;
	}

	public void setMyTeam1(Team myTeam1) {
		this.myTeam1 = myTeam1;
	}

	public Team getMyTeam2() {
		return myTeam2;
	}

	public void setMyTeam2(Team myTeam2) {
		this.myTeam2 = myTeam2;
	}

	public File getMyFile() {
		return myFile;
	}
	
	public Vector<Team> getMyTeams() {
		return myTeams;
	}

	public Graph getG1() {
		return g1;
	}

	public Graph getG2() {
		return g2;
	}

}
