package mvc;


import mvc.Controller;
import mvc.MVC;

public class MVC
{
    // Properties
    private Controller myController;
    
    // Methods
    public static void main(String[] args)
    {
        new MVC();
    }
    
    public MVC()
    {
        setController(new Controller());
    }

	public void setController(Controller controller) 
	{
		myController = controller;
	}

	public Controller getController() {
		return myController;
	}
}
