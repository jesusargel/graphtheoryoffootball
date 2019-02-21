package mvc;

import java.io.File;

import model.*;
import mvc.View;

public class Controller {
	
	private Engine myEngine;
	private View myView;
	private File myFile;
	
	public Controller()
	{
		myFile = new File("src/data.txt");
		myEngine = new Engine(myFile);
		myView = new View(this);
	}
	
	public void sp1()
	{
		setMyEngine();
		int num = myView.getNum1();
		myEngine.getG1().computeSortestPathsFrom(num + 1);
		for(int i = 0; i < 11; i ++)
		{
			int value = myEngine.getG1().getVertices()[i].getCost();
			myView.setValues1(i, value);
		}	
	}

	public void sp2()
	{
		setMyEngine();
		int num = myView.getNum2();
		myEngine.getG2().computeSortestPathsFrom(num + 1);
		for(int i = 0; i < 11; i ++)
		{
			int value = myEngine.getG2().getVertices()[i].getCost();
			myView.setValues2(i, value);
		}		
	}
	
	public Engine getMyEngine() {
		return myEngine;
	}

	public void setMyEngine() {
		myEngine = new Engine(myFile);
	}

	public View getMyView() {
		return myView;
	}

	public void setMyView(View myView) {
		this.myView = myView;
	}
	
	
}
