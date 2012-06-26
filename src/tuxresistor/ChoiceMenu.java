package tuxresistor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ChoiceMenu {
	
	protected JButton selectbutton,credits,exitbutton;
    protected JComboBox box;
	public JFrame fr;
	
	public String[] choice={"ColorBands to Resistor Values","Resistor Values to ColorBands"};

	public ChoiceMenu() throws IOException
	{
		
		 Icon img1=new ImageIcon(getClass().getResource("continuebutton.png"));
 	     Icon img2=new ImageIcon(getClass().getResource("continuebuttonhover.png"));
 	     
		 Icon img3=new ImageIcon(getClass().getResource("exitbutton.png"));
 	     Icon img4=new ImageIcon(getClass().getResource("exitbuttonhover.png"));
 	     
	     
		 Icon img5=new ImageIcon(getClass().getResource("creditsbutton.png"));
 	     Icon img6=new ImageIcon(getClass().getResource("creditsbuttonhover.png"));
 	
		 selectbutton=new JButton("",img1);
		 selectbutton.setRolloverIcon(img2);
		 exitbutton=new JButton("",img3);
		 exitbutton.setRolloverIcon(img4);
		 credits=new JButton("",img5);
		 credits.setRolloverIcon(img6);
		 
         box=new JComboBox(choice);
 	   		 	
		 String separator = System.getProperty("file.separator");
	     String rootPath = System.getProperty("user.dir");
	     String imgPath = rootPath + separator +"img" + separator;
		 
         BufferedImage myImage = ImageIO.read(new File(imgPath+"choicebg.png"));

         fr=new JFrame("Selection Menu");
         fr.setContentPane(new ImagePanel(myImage));

	}
	
	public void getChoiceFrame() throws IOException
	{
      fr.setLayout(null);
      fr.add(selectbutton);
      fr.add(exitbutton);
      fr.add(box);
      fr.add(credits);
 
      fr.setVisible(true);
      
      fr.setSize(500, 310);
      
      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      
        ChoiceHandler handler=new ChoiceHandler();
		box.addActionListener(handler);
		selectbutton.addActionListener(handler);
		exitbutton.addActionListener(handler);
		credits.addActionListener(handler);
    
	}

	
	public void setChoiceLocation()
	{
		
	      box.setBounds(50, 100, 300, 29);
	      selectbutton.setBounds(355, 100, 88, 29);
	      exitbutton.setBounds(180, 180, 100, 25);
	      credits.setBounds(420, 255, 80, 20);
	      
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
	    
	    class ChoiceHandler implements ActionListener
	    {

	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    		String str = (String)box.getSelectedItem();
	    		boolean b=selectbutton.hasFocus();
	    		
	    		if(str==choice[0] && b)
	    		{
	    			ColorBandToValues exe;
					try {
						exe = new ColorBandToValues();
		    			exe.getCBVFrame();
		    			exe.getChoiceColor();
		    			exe.setChoiceFonts();
		    			exe.setChoiceLocation();
					} catch (IOException e) {
						e.printStackTrace();
					}			
	    		}
	    		else if(str==choice[1] && b)
	    		{
	    		    ValuesToBand exe;
					try {
						exe = new ValuesToBand();
		    			exe.getChoiceColor();
		    			exe.setChoiceFonts();
		    			exe.setChoiceLocation();
		    			exe.getVTBFrame();	
					} catch (IOException e) {
						e.printStackTrace();
					}
			
	    		}
	    		else if(exitbutton.hasFocus())
	    		{
	    			System.exit(0);
	    		}
	    		else if(credits.hasFocus())
	    		{
	    			Credits a;
					try {
						a = new Credits();
		    	        a.getCredits();
					} catch (IOException e) {
						e.printStackTrace();
					}
	
	    		}
	    		
	    	}	
	    
	    }
}
