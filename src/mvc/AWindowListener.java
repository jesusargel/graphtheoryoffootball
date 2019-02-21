package mvc;

import java.awt.event.*;

public class AWindowListener extends WindowAdapter
{

    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
}
