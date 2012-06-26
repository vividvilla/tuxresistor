package tuxresistor;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Credits {
	
	 Icon img1=new ImageIcon(getClass().getResource("exitbutton.png"));
     Icon img2=new ImageIcon(getClass().getResource("exitbuttonhover.png"));
	
	protected JFrame fr;
	protected JButton exit;
	
	public Credits() throws IOException
	{
	
		exit=new JButton("",img1);	
		exit.setRolloverIcon(img2);
		 	
		String separator = System.getProperty("file.separator");
		String rootPath = System.getProperty("user.dir");
		String imgPath = rootPath + separator +"img" + separator;
 
		BufferedImage myImage = ImageIO.read(new File(imgPath+"credits.png"));

		fr=new JFrame("Credits - TuxResistor");
		fr.setContentPane(new ImagePanel(myImage));
		
		 CreditsHandler handler=new CreditsHandler();
			exit.addActionListener(handler);
	}
	
	public void getCredits()
	{
		fr.setVisible(true);
		fr.setSize(500, 500);
		
		fr.add(exit);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		exit.setBounds(150, 400, 100, 25);
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
	 
	    class CreditsHandler implements ActionListener
	    {

	    	public void actionPerformed(ActionEvent arg0) 
	    	{
	    		if(exit.hasFocus())
	    		{
	    			fr.setVisible(false);
	    		}
	    		
	    	}
	    }

}
