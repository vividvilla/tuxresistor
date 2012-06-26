package tuxresistor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class ColorBandToValues {

	protected  String[] colorbands={"BLACK","BROWN","RED","ORANGE","YELLOW","GREEN","BLUE","VIOLET","GRAY","WHITE"};
	protected  String[] tolerance={"GOLD","SILVER","NONE"};
	
	
	Icon img1=new ImageIcon(getClass().getResource("calcval.png"));
    Icon img2=new ImageIcon(getClass().getResource("calcvalhover.png"));
     
	Icon img3=new ImageIcon(getClass().getResource("exitbutton.png"));
    Icon img4=new ImageIcon(getClass().getResource("exitbuttonhover.png"));
      
	Icon img5=new ImageIcon(getClass().getResource("creditsbutton.png"));
    Icon img6=new ImageIcon(getClass().getResource("creditsbuttonhover.png"));
	
    protected JComboBox band1,band2,band3,band4;
    
    protected JTextField totres,tottol;
	
    protected JFrame fr1;
	
    protected JButton calculate,credits,exit;
	
	public ColorBandToValues() throws IOException
	{
		band1=new JComboBox(colorbands);
		band2=new JComboBox(colorbands);
		band3=new JComboBox(colorbands);
		band4=new JComboBox(tolerance);
		
		
		totres=new JTextField("Total Resistance");
		tottol=new JTextField("Total Tolerance");
		
		calculate=new JButton("",img1);
		calculate.setRolloverIcon(img2);
		exit=new JButton("",img3);
		exit.setRolloverIcon(img4);
		credits=new JButton("",img5);
		credits.setRolloverIcon(img6);
							
		 String separator = System.getProperty("file.separator");
	     String rootPath = System.getProperty("user.dir");
	     String imgPath = rootPath + separator +"img" + separator;
		 
         BufferedImage myImage = ImageIO.read(new File(imgPath+"ch1op.png"));
         
         fr1=new JFrame("Convert ColorBands to Resistor Values");
         fr1.setContentPane(new ImagePanel(myImage));
	
		CBVHandler handler=new CBVHandler();
		band1.addActionListener(handler);
		band2.addActionListener(handler);
		band3.addActionListener(handler);
		band4.addActionListener(handler);
		calculate.addActionListener(handler);
		exit.addActionListener(handler);
		credits.addActionListener(handler);
	}
	
	public void getCBVFrame()
	{
		
		fr1.setLayout(null);
		
		fr1.add(band1);
		fr1.add(band2);
		fr1.add(band3);
		fr1.add(band4);
		fr1.add(calculate);
		fr1.add(exit);
		fr1.add(totres);
		fr1.add(tottol);
		fr1.add(credits);
		
		fr1.setVisible(true);      
	    fr1.setSize(500, 635);      
	    fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    
	    totres.setEditable(false);
	    tottol.setEditable(false);
	}
	
	public void setChoiceFonts()
	{
		 Font font2=new Font("Serif",Font.BOLD,16);
	     
	     totres.setFont(font2);
	     tottol.setFont(font2);
	}
	
	public void setChoiceLocation()
	{
		 
		 
		 band1.setBounds(210, 220, 200, 25);
		 band2.setBounds(210, 260, 200, 25);
		 band3.setBounds(210, 303, 200, 25);
		 band4.setBounds(210, 349, 200, 25);
		 
		 calculate.setBounds(62, 400, 167, 29);
		 exit.setBounds(300, 402, 100, 25);
		 credits.setBounds(420, 580, 80, 20);
		
		 totres.setBounds(40, 470, 200, 40);
		 tottol.setBounds(40,517,200,40);
		 
		 
		 totres.setHorizontalAlignment( SwingConstants.CENTER );
		 tottol.setHorizontalAlignment( SwingConstants.CENTER );
	}
	
	public void getChoiceColor()
	{

		
		totres.setOpaque(true);
		tottol.setOpaque(true);
	       	    	
		
		totres.setBackground(Color.BLACK);
		tottol.setBackground(Color.BLACK);
		
		totres.setForeground(Color.YELLOW);
		tottol.setForeground(Color.YELLOW);
	}
	

    class ImagePanel extends JComponent {
    private static final long serialVersionUID = 1L;
	private Image image;
    public ImagePanel(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
    
    }
    
    class CBVHandler implements ActionListener
    {

		public void actionPerformed(ActionEvent e) 
		
		{
			String str1=(String)band1.getSelectedItem();
			String str2=(String)band2.getSelectedItem();
			String str3=(String)band3.getSelectedItem();
			String str4=(String)band4.getSelectedItem();
			
			int value1=iterateband(str1);
			int value2=iterateband(str2);
			int value3=iterateband(str3);
			int value4=iteratetolerance(str4);
			
						
			int power =(int) Math.pow(10,(double)value3);
			
			int totalval=((value1*10)+(value2))*power;
			
			if(calculate.hasFocus())
			{	
			
			totres.setText(Integer.toString(totalval));
			tottol.setText(Integer.toString(value4));
			
			}
			else  if(exit.hasFocus())
			{
				fr1.setVisible(false);

			}
			else  if(credits.hasFocus())
			{
				Credits a;
				try {
					a = new Credits();
		    	    a.getCredits();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
			
		}
		
		public int iterateband(String s)
		{
			if(s=="BLACK")
				return 0;
			else if(s=="BROWN")
				return 1;
			else if(s=="RED")
				return 2;
			else if(s=="ORANGE")
				return 3;
			else if(s=="YELLOW")
				return 4;
			else if(s=="GREEN")
				return 5;
			else if(s=="BLUE")
				return 6;
			else if(s=="VIOLET")
				return 7;
			else if(s=="GRAY")
				return 8;
			else 
				return 9;
		}
		
		public int iteratetolerance(String s)
		{
			if(s=="GOLD")
				return 5;
			else if(s=="SILVER")
				return 10;
			else 
				return 20;
    }
    }
	
    
    }
