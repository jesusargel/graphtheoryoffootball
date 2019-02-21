package mvc;


import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Shape;
import java.awt.TextComponent;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.geom.Line2D;
import java.lang.reflect.Method;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("unused")
public class View extends Frame 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int stroke ;
	int maxWidth1;
	int maxWidth2;
	
	int gk1_x = 540;
	int lcb1_x = 470;
	int rcb1_x = 610;
	int lb1_x = 310;
	int rb1_x = 760;
	int rcm1_x = 380;
	int cdm1_x = 540;
	int lcm1_x = 700;
	int rw1_x = 360;
	int lw1_x = 720;
	int cf1_x = 540;
	
	int gk2_x = 1240;
	int lcb2_x = 1170;
	int rcb2_x = 1310;
	int lb2_x = 1010;
	int rb2_x = 1460;
	int rcm2_x = 1080;
	int cdm2_x = 1240;
	int lcm2_x = 1400;
	int lw2_x = 1060;
	int rw2_x = 1420;
	int cf2_x = 1240;
	
	int gk_y = 770;
	int lcb_y = 650;
	int rcb_y = 650;
	int lb_y = 630;
	int rb_y = 630;
	int rcm_y = 420;
	int cdm_y = 450;
	int lcm_y = 420;
	int lw_y = 200;
	int rw_y = 200;
	int cf_y = 190;
	
	private Image myField;
	private Image myIcon1;
	private Image myIcon2;
	private Controller myController;
	private Panel myFieldsPanel;
	private Label myTeam1Name;
	private Label myTeam2Name;
	private Can field1;
	private Can field2;
	
	private Panel panelt1p1;
	private Panel panelt1p2;
	private Panel panelt1p3;
	private Panel panelt1p4;
	private Panel panelt1p5;
	private Panel panelt1p6;
	private Panel panelt1p7;
	private Panel panelt1p8;
	private Panel panelt1p9;
	private Panel panelt1p10;
	private Panel panelt1p11;
	private Panel panelt2p1;
	private Panel panelt2p2;
	private Panel panelt2p3;
	private Panel panelt2p4;
	private Panel panelt2p5;
	private Panel panelt2p6;
	private Panel panelt2p7;
	private Panel panelt2p8;
	private Panel panelt2p9;
	private Panel panelt2p10;
	private Panel panelt2p11;
	
	private Can t1p1;
	private Can t1p2;
	private Can t1p3;
	private Can t1p4;
	private Can t1p5;
	private Can t1p6;
	private Can t1p7;
	private Can t1p8;
	private Can t1p9;
	private Can t1p10;
	private Can t1p11;
	private Can t2p1;
	private Can t2p2;
	private Can t2p3;
	private Can t2p4;
	private Can t2p5;
	private Can t2p6;
	private Can t2p7;
	private Can t2p8;
	private Can t2p9;
	private Can t2p10;
	private Can t2p11;
	
	private Label[] team1num;
	private Label[] team2num;
	private Label tn;
	
	private Panel action1;
	private Panel action2;
	private ButtonListener mySet1;
	private ButtonListener mySet2;
	private Button myButtonT1;
	private Button myButtonT2;
	
	private JComboBox<String> t1Roster;
	private JComboBox<String> t2Roster;
	
	public View(Controller controller)
	{
		this.setSize(1800, 1200);
		this.setLayout(null);
		this.setBackground(new Color(153, 221, 255));
		myController = controller;
		
		this.associateListeners(controller);
		
		myField = Toolkit.getDefaultToolkit().getImage("images/field.jpg");
		myIcon1 = Toolkit.getDefaultToolkit().getImage("images/icon1.png");
		myIcon2 = Toolkit.getDefaultToolkit().getImage("images/icon2.png");
		
		maxWidth1 = (int) controller.getMyEngine().getMyTeam1().getMaxWidth();
		maxWidth2 = (int) controller.getMyEngine().getMyTeam2().getMaxWidth();
				
		myFieldsPanel = new Panel(new GridLayout(0,2));
		myFieldsPanel.setSize(1400, 800);
		myFieldsPanel.setLocation(250, 50);
		
		field1 = new Can(myField);
		field2 = new Can(myField);
		myFieldsPanel.add(field1);
		myFieldsPanel.add(field2);
		
		tn = new Label("0");
		tn.setFont(new Font("Arial", 16, 15));
		
		team1num = new Label[11];
		team2num = new Label[11];
		
		for(int i = 0; i < 11; i ++)
		{
			tn = new Label("0");
			team1num[i] = tn;
			tn = new Label("0");
			team2num[i] = tn;
		}
		
		//GK
		panelt1p1 =new Panel(new GridLayout(0,1));
		panelt1p1.setSize(32, 64);
		panelt1p1.setLocation(gk1_x, gk_y);
		t1p1 = new Can(myIcon1);
		panelt1p1.add(t1p1);
		panelt1p1.add(team1num[0]);

		
		
		//LCB
		panelt1p2 =new Panel(new GridLayout(0,1));
		panelt1p2.setSize(32, 64);
		panelt1p2.setLocation(lcb1_x, lcb_y);
		t1p2 = new Can(myIcon1);
		panelt1p2.add(t1p2);
		panelt1p2.add(team1num[1]);
		
		
		//RCB
		panelt1p3 =new Panel(new GridLayout(0,1));
		panelt1p3.setSize(32, 64);
		panelt1p3.setLocation(rcb1_x, rcb_y);
		t1p3 = new Can(myIcon1);
		panelt1p3.add(t1p3);
		panelt1p3.add(team1num[2]);

		
		
		//RB
		panelt1p4 =new Panel(new GridLayout(0,1));
		panelt1p4.setSize(32, 64);
		panelt1p4.setLocation(rb1_x, rb_y);
		t1p4 = new Can(myIcon1);
		panelt1p4.add(t1p4);
		panelt1p4.add(team1num[3]);
		
		//LB
		panelt1p5 =new Panel(new GridLayout(0,1));
		panelt1p5.setSize(32, 64);
		panelt1p5.setLocation(lb1_x, lb_y);
		t1p5 = new Can(myIcon1);
		panelt1p5.add(t1p5);
		panelt1p5.add(team1num[4]);

		
		//RCM
		panelt1p6 =new Panel(new GridLayout(0,1));
		panelt1p6.setSize(32, 64);
		panelt1p6.setLocation(rcm1_x, rcm_y);
		t1p6 = new Can(myIcon1);
		panelt1p6.add(t1p6);
		panelt1p6.add(team1num[5]);

		
		//CDM
		panelt1p7 =new Panel(new GridLayout(0,1));
		panelt1p7.setSize(32, 64);
		panelt1p7.setLocation(cdm1_x, cdm_y);
		t1p7 = new Can(myIcon1);
		panelt1p7.add(t1p7);
		panelt1p7.add(team1num[6]);

		
		//LCM
		panelt1p8 =new Panel(new GridLayout(0,1));
		panelt1p8.setSize(32, 64);
		panelt1p8.setLocation(lcm1_x, lcm_y);
		t1p8 = new Can(myIcon1);
		panelt1p8.add(t1p8);
		panelt1p8.add(team1num[7]);

		
		//LW
		panelt1p9 =new Panel(new GridLayout(0,1));
		panelt1p9.setSize(32, 64);
		panelt1p9.setLocation(lw1_x, lw_y);
		t1p9 = new Can(myIcon1);
		panelt1p9.add(t1p9);
		panelt1p9.add(team1num[9]);

		
		//RW
		panelt1p10 =new Panel(new GridLayout(0,1));
		panelt1p10.setSize(32, 64);
		panelt1p10.setLocation(rw1_x, rw_y);
		t1p10 = new Can(myIcon1);
		panelt1p10.add(t1p10);
		panelt1p10.add(team1num[8]);

		
		//CF
		panelt1p11 =new Panel(new GridLayout(0,1));
		panelt1p11.setSize(32, 64);
		panelt1p11.setLocation(cf1_x, cf_y);
		t1p11 = new Can(myIcon1);
		panelt1p11.add(t1p11);
		panelt1p11.add(team1num[10]);

		
		//GK
		panelt2p1 =new Panel(new GridLayout(0,1));
		panelt2p1.setSize(32, 64);
		panelt2p1.setLocation(gk2_x, gk_y);
		t2p1 = new Can(myIcon2);
		panelt2p1.add(t2p1);
		panelt2p1.add(team2num[0]);

		
		//LCB
		panelt2p2 =new Panel(new GridLayout(0,1));
		panelt2p2.setSize(32, 64);
		panelt2p2.setLocation(lcb2_x, lcb_y);
		t2p2 = new Can(myIcon2);
		panelt2p2.add(t2p2);
		panelt2p2.add(team2num[1]);

		
		//RCB
		panelt2p3 =new Panel(new GridLayout(0,1));
		panelt2p3.setSize(32, 64);
		panelt2p3.setLocation(rcb2_x, rcb_y);
		t2p3 = new Can(myIcon2);
		panelt2p3.add(t2p3);
		panelt2p3.add(team2num[2]);

		
		//RB
		panelt2p4 =new Panel(new GridLayout(0,1));
		panelt2p4.setSize(32, 64);
		panelt2p4.setLocation(rb2_x, rb_y);
		t2p4 = new Can(myIcon2);
		panelt2p4.add(t2p4);
		panelt2p4.add(team2num[3]);

		
		//LB
		panelt2p5 =new Panel(new GridLayout(0,1));
		panelt2p5.setSize(32, 64);
		panelt2p5.setLocation(lb2_x, lb_y);
		t2p5 = new Can(myIcon2);
		panelt2p5.add(t2p5);
		panelt2p5.add(team2num[4]);

		
		//RCM
		panelt2p6 =new Panel(new GridLayout(0,1));
		panelt2p6.setSize(32, 64);
		panelt2p6.setLocation(rcm2_x, rcm_y);
		t2p6 =new Can(myIcon2);
		panelt2p6.add(t2p6);
		panelt2p6.add(team2num[5]);

		
		//CDM
		panelt2p7 =new Panel(new GridLayout(0,1));
		panelt2p7.setSize(32, 64);
		panelt2p7.setLocation(cdm2_x, cdm_y);
		t2p7 = new Can(myIcon2);
		panelt2p7.add(t2p7);
		panelt2p7.add(team2num[6]);

		
		//LCM
		panelt2p8 =new Panel(new GridLayout(0,1));
		panelt2p8.setSize(32, 64);
		panelt2p8.setLocation(lcm2_x, lcm_y);
		t2p8 = new Can(myIcon2);
		panelt2p8.add(t2p8);
		panelt2p8.add(team2num[7]);

		
		//LW
		panelt2p9 =new Panel(new GridLayout(0,1));
		panelt2p9.setSize(32, 64);
		panelt2p9.setLocation(lw2_x, lw_y);
		t2p9 = new Can(myIcon2);
		panelt2p9.add(t2p9);
		panelt2p9.add(team2num[8]);

		
		//RW
		panelt2p10 =new Panel(new GridLayout(0,1));
		panelt2p10.setSize(32, 64);
		panelt2p10.setLocation(rw2_x, rw_y);
		t2p10 = new Can(myIcon2);
		panelt2p10.add(t2p10);
		panelt2p10.add(team2num[9]);

		
		//CF
		panelt2p11 =new Panel(new GridLayout(0,1));
		panelt2p11.setSize(32, 64);
		panelt2p11.setLocation(cf2_x, cf_y);
		t2p11 = new Can(myIcon2);
		panelt2p11.add(t2p11);
		panelt2p11.add(team2num[10]);

		
		
		
		
		myTeam1Name = new Label(controller.getMyEngine().getMyTeam1().getTeamName());
		myTeam1Name.setSize(200, 100);
		myTeam1Name.setLocation(490, 850);
		myTeam1Name.setFont(new Font("Arial", 16, 30));
		
		myTeam2Name = new Label(controller.getMyEngine().getMyTeam2().getTeamName());
		myTeam2Name.setSize(200, 100);
		myTeam2Name.setLocation(1180, 850);
		myTeam2Name.setFont(new Font("Arial", 16, 30));
		
		t1Roster = new JComboBox<String>(controller.getMyEngine().getMyTeam1().getPlayerNames());
		t2Roster = new JComboBox<String>(controller.getMyEngine().getMyTeam2().getPlayerNames());
		

		
		myButtonT1 = new Button("SET");
		myButtonT1.addMouseListener(mySet1);
		
		myButtonT2 = new Button("SET");
		myButtonT2.addMouseListener(mySet2);
		
		action1 = new Panel(new GridLayout(1,0));
		action1.setSize(400, 50);
		action1.setLocation(350, gk_y + 150);
		action1.add(t1Roster);
		action1.add(myButtonT1);
		
		action2 = new Panel(new GridLayout(1,0));
		action2.setSize(400, 50);
		action2.setLocation(1050, gk_y + 150);
		action2.add(t2Roster);
		action2.add(myButtonT2);
		
		this.add(action1);
		this.add(action2);
		this.add(panelt1p1);
		this.add(panelt1p2);
		this.add(panelt1p3);
		this.add(panelt1p4);
		this.add(panelt1p5);
		this.add(panelt1p6);
		this.add(panelt1p7);
		this.add(panelt1p8);
		this.add(panelt1p9);
		this.add(panelt1p10);
		this.add(panelt1p11);
		this.add(panelt2p1);
		this.add(panelt2p2);
		this.add(panelt2p3);
		this.add(panelt2p4);
		this.add(panelt2p5);
		this.add(panelt2p6);
		this.add(panelt2p7);
		this.add(panelt2p8);
		this.add(panelt2p9);
		this.add(panelt2p10);
		this.add(panelt2p11);
		this.add(myFieldsPanel);
		this.add(myTeam1Name);
		this.add(myTeam2Name);
		
		
		
		this.setVisible(true);
		this.addWindowListener(new AWindowListener());
		
	}
	
	public void associateListeners(Controller controller)
    {
        Class<? extends Controller> controllerClass;
        Method sp1Method;
        Method sp2Method;

        controllerClass = controller.getClass();
        
        sp1Method = null;
        sp2Method = null;
        
        try
        {
        	sp1Method = controllerClass.getMethod("sp1",(Class<?>[])null);
        	sp2Method = controllerClass.getMethod("sp2",(Class<?>[])null); 
        }
        catch(NoSuchMethodException exception)
        {
           String error;

           error = exception.toString();
           System.out.println(error);
        }
        catch(SecurityException exception)
        {
           String error;

           error = exception.toString();
           System.out.println(error);
        }
        

        mySet1 = new ButtonListener(controller, sp1Method, null);
        mySet2 = new ButtonListener(controller, sp2Method, null);       
        
    }
	
	public void setValues1(int n, int value)
	{
		team1num[n].setText(Integer.toString(value));	
	}
	
	public void setValues2(int n, int value)
	{
		team2num[n].setText(Integer.toString(value));			
	}
	
	public int getNum1()
	{
		return this.t1Roster.getSelectedIndex();
	}
	
	public int getNum2()
	{
		return this.t2Roster.getSelectedIndex();
	}
	
}
