package tuxresistor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ValuesToBand {
     
	protected  JTextField resinput;
	protected  JComboBox tolinput,box;
	
	protected  JButton enter,exit,credits;
	
	protected  JFrame fr;
	
	protected  JLabel band1,band2,band3,band4;

	protected  JLabel bandname1,bandname2,bandname3,bandname4,bandname5,bandname6,bandname7,bandname8;
	
	protected  String[] power={"-","10","100","K","10K","100K","M","10M"};
	protected  String[] tol={"5%","10%","20%"};
    
	Icon img1=new ImageIcon(getClass().getResource("continuebutton.png"));
    Icon img2=new ImageIcon(getClass().getResource("continuebuttonhover.png"));
     
	Icon img3=new ImageIcon(getClass().getResource("exitbutton.png"));
    Icon img4=new ImageIcon(getClass().getResource("exitbuttonhover.png"));
      
	Icon img5=new ImageIcon(getClass().getResource("creditsbutton.png"));
    Icon img6=new ImageIcon(getClass().getResource("creditsbuttonhover.png"));
	
	public ValuesToBand() throws IOException
	{
		band1=new JLabel("");
		band2=new JLabel("");
		band3=new JLabel("");
		band4=new JLabel("");
		bandname1=new JLabel("BLACK");
		bandname2=new JLabel("BLACK");
		bandname3=new JLabel("BLACK");
		bandname4=new JLabel("BLACK");
		bandname5=new JLabel("");
		bandname6=new JLabel("");
		bandname7=new JLabel("");
		bandname8=new JLabel("");
		

		
		enter=new JButton("",img1);
		enter.setRolloverIcon(img2);
		exit=new JButton("",img3);
		exit.setRolloverIcon(img4);
		credits=new JButton("",img5);
		credits.setRolloverIcon(img6);
		
		box=new JComboBox(power);
		
		resinput=new JTextField("1 - 99");
        
		tolinput=new JComboBox(tol);
		
		String separator = System.getProperty("file.separator");
	    String rootPath = System.getProperty("user.dir");
	    String imgPath = rootPath + separator +"img" + separator;
		 
        BufferedImage myImage = ImageIO.read(new File(imgPath+"ch2op.png"));
		
        fr=new JFrame("Convert Resistor values to Color bands");
        fr.setContentPane(new ImagePanel(myImage));
		
		
		TBVHandler handler=new TBVHandler();
		resinput.addActionListener(handler);
		tolinput.addActionListener(handler);
		box.addActionListener(handler);
		enter.addActionListener(handler);
		exit.addActionListener(handler);
		credits.addActionListener(handler);
		
	}
	
	public void getVTBFrame()
	{
		fr.setLayout(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(500, 635);
		fr.setVisible(true);
		
		fr.add(band1);
		fr.add(band2);
		fr.add(band3);
		fr.add(band4);

		fr.add(enter);
		fr.add(exit);
		fr.add(credits);
		fr.add(box);
		fr.add(resinput);
		fr.add(tolinput);

		
		fr.add(bandname1);
		fr.add(bandname2);
		fr.add(bandname3);
		fr.add(bandname4);
		fr.add(bandname5);
		fr.add(bandname6);
		fr.add(bandname7);
		fr.add(bandname8);
	}
	
	public void setChoiceFonts()
	{
		 Font font=new Font("Serif",Font.BOLD,14);
	     resinput.setFont(font);
	     tolinput.setFont(font);

	     
	     bandname1.setFont(font);
	     bandname2.setFont(font);
	     bandname3.setFont(font);
	     bandname4.setFont(font);
	}
	
	public void setChoiceLocation()
	{
		 resinput.setBounds(50, 77, 100, 25);
		 box.setBounds(170, 77, 100, 25);

	
		 tolinput.setBounds(50, 132, 220, 25);

		 
		 enter.setBounds(50, 185, 88, 25);
		 exit.setBounds(150, 185, 100, 25);
		 credits.setBounds(420,580,80,20);
				 
		 band1.setBounds(168, 282, 21, 76);
		 band2.setBounds(198, 282, 21, 76);
		 band3.setBounds(228, 282, 21, 76);
		 band4.setBounds(312, 282, 21, 76);
		 

    	 
    	 bandname1.setBounds(200, 420, 100, 25);
    	 bandname2.setBounds(200, 457, 100, 25);
    	 bandname3.setBounds(200, 497, 100, 25);
    	 bandname4.setBounds(200, 533, 100, 25);
    	 
    	 bandname5.setBounds(310, 420, 100, 25);
    	 bandname6.setBounds(310, 457, 100, 25);
    	 bandname7.setBounds(310, 497, 100, 25);
    	 bandname8.setBounds(310, 533, 100, 25);
		 		 	 
		 resinput.setHorizontalAlignment( SwingConstants.CENTER );
	}
	
	public void getChoiceColor()
	{
		Color def=Color.BLACK;
		Color def1=Color.YELLOW;
		
		band1.setOpaque(true);
		band2.setOpaque(true);
		band3.setOpaque(true);
		band4.setOpaque(true);
		
		bandname1.setOpaque(true);
		bandname2.setOpaque(true);
		bandname3.setOpaque(true);
		bandname4.setOpaque(true);
		bandname5.setOpaque(true);
		bandname6.setOpaque(true);
		bandname7.setOpaque(true);
		bandname8.setOpaque(true);
        
		band1.setBackground(def);
		band2.setBackground(def);
		band3.setBackground(def);
		band4.setBackground(def);
		
		bandname1.setBackground(def);
		bandname2.setBackground(def);
		bandname3.setBackground(def);
		bandname4.setBackground(def);
		bandname5.setBackground(def);
		bandname6.setBackground(def);
		bandname7.setBackground(def);
		bandname8.setBackground(def);
		
		bandname1.setForeground(def1);
		bandname2.setForeground(def1);
		bandname3.setForeground(def1);
		bandname4.setForeground(def1);
		
		bandname1.setHorizontalAlignment(SwingConstants.CENTER);
		bandname2.setHorizontalAlignment(SwingConstants.CENTER);
		bandname3.setHorizontalAlignment(SwingConstants.CENTER);
		bandname4.setHorizontalAlignment(SwingConstants.CENTER);	
	}
	
	
	  class TBVHandler implements ActionListener
	    {

			public void actionPerformed(ActionEvent e) 
			
			{
				
				try {
					String str1=resinput.getText();
					String str2=(String)tolinput.getSelectedItem();
					String boxstr=(String)box.getSelectedItem();
					
					String bstr1="";
					String bstr2="";
					String bstr3="";
					String bstr4=getTolName(str2);
							
					int a=Integer.parseInt(str1);
					
					Color b1=Color.BLACK;
					Color b2=Color.BLACK;
					Color b3=Color.BLACK;
					Color b4=Color.BLACK;

					b4=getTolColors(str2);
								
					if(a>=100)
					{
						JOptionPane.showMessageDialog(null, " Type only Intgers ranging 1 - 99 ", "Error", JOptionPane.ERROR_MESSAGE);
					}
								
					
					if(boxstr=="-")
					{
						if(a<10)
						{
							b1=getbandColors(0);
							b2=getbandColors(a);
							b3=getbandColors(0);
							
							bstr1=getColorName(0);
							bstr2=getColorName(a);
							bstr3=getColorName(0);
						}						
						else
						{
							b1=getbandColors(a/10);
							b2=getbandColors(a%10);
							b3=getbandColors(0);
							
							bstr1=getColorName(a/10);
							bstr2=getColorName(a%10);
							bstr3=getColorName(0);

						}
							
					}
					else if(boxstr=="10")
					{
						if(a<10)
						{
							b1=getbandColors(0);
							b2=getbandColors(a%10);
							b3=getbandColors(1);
							
							bstr1=getColorName(0);
							bstr2=getColorName(a%10);
							bstr3=getColorName(1);
						}						
						else
						{
							b1=getbandColors(a/10);
							b2=getbandColors(a%10);
							b3=getbandColors(1);
							
							bstr1=getColorName(a/10);
							bstr2=getColorName(a%10);
							bstr3=getColorName(1);
						}
					}
					else if(boxstr=="100")
					{
						if(a<10)
						{
							b1=getbandColors(0);
							b2=getbandColors(a%10);
							b3=getbandColors(2);
							
							bstr1=getColorName(0);
							bstr2=getColorName(a%10);
							bstr3=getColorName(2);
						}						
						else
						{
							b1=getbandColors(a/10);
							b2=getbandColors(a%10);
							b3=getbandColors(2);
							
							bstr1=getColorName(a/10);
							bstr2=getColorName(a%10);
							bstr3=getColorName(2);
						}
					}
					else if(boxstr=="K")
					{
						if(a<10)
						{
							b1=getbandColors(0);
							b2=getbandColors(a%10);
							b3=getbandColors(3);
							
							bstr1=getColorName(0);
							bstr2=getColorName(a%10);
							bstr3=getColorName(3);
						}						
						else
						{
							b1=getbandColors(a/10);
							b2=getbandColors(a%10);
							b3=getbandColors(3);
							
							bstr1=getColorName(a/10);
							bstr2=getColorName(a%10);
							bstr3=getColorName(3);
						}
					}
					else if(boxstr=="10K")
					{
						if(a<10)
						{
							b1=getbandColors(0);
							b2=getbandColors(a%10);
							b3=getbandColors(4);
							
							bstr1=getColorName(0);
							bstr2=getColorName(a%10);
							bstr3=getColorName(4);
						}						
						else
						{
							b1=getbandColors(a/10);
							b2=getbandColors(a%10);
							b3=getbandColors(4);
							
							bstr1=getColorName(a/10);
							bstr2=getColorName(a%10);
							bstr3=getColorName(4);
						}
					}
					else if(boxstr=="100K")
					{
						if(a<10)
						{
							b1=getbandColors(0);
							b2=getbandColors(a%10);
							b3=getbandColors(5);
							
							bstr1=getColorName(0);
							bstr2=getColorName(a%10);
							bstr3=getColorName(5);
						}						
						else
						{
							b1=getbandColors(a/10);
							b2=getbandColors(a%10);
							b3=getbandColors(5);
							
							bstr1=getColorName(a/10);
							bstr2=getColorName(a%10);
							bstr3=getColorName(5);
						}
					}
					else if(boxstr=="M")
					{
						if(a<10)
						{
							b1=getbandColors(0);
							b2=getbandColors(a%10);
							b3=getbandColors(6);
							
							bstr1=getColorName(0);
							bstr2=getColorName(a%10);
							bstr3=getColorName(6);
						}						
						else
						{
							b1=getbandColors(a/10);
							b2=getbandColors(a%10);
							b3=getbandColors(6);
							
							bstr1=getColorName(a/10);
							bstr2=getColorName(a%10);
							bstr3=getColorName(6);
						}
					}
					else if(boxstr=="10M")
					{
						if(a<10)
						{
							b1=getbandColors(0);
							b2=getbandColors(a%10);
							b3=getbandColors(7);
							
							bstr1=getColorName(0);
							bstr2=getColorName(a%10);
							bstr3=getColorName(7);
						}						
						else
						{
							b1=getbandColors(a/10);
							b2=getbandColors(a%10);
							b3=getbandColors(7);
							
							bstr1=getColorName(a/10);
							bstr2=getColorName(a%10);
							bstr3=getColorName(7);
						}
					}
					
					if(enter.hasFocus())
					{
						band1.setBackground(b1);
						band2.setBackground(b2);
						band3.setBackground(b3);
						band4.setBackground(b4);	
						
						bandname5.setBackground(b1);
						bandname6.setBackground(b2);
						bandname7.setBackground(b3);
						bandname8.setBackground(b4);

						bandname1.setText(bstr1);
						bandname2.setText(bstr2);
						bandname3.setText(bstr3);
						bandname4.setText(bstr4);
					}
					else  if(credits.hasFocus())
					{
						Credits b;
						try {
							b = new Credits();
				    	    b.getCredits();
						} catch (IOException e1) {
							e1.printStackTrace();
						}

					}
else if(exit.hasFocus())
{
fr.setVisible(false);
}
				} catch (NumberFormatException e1) {
					if(exit.hasFocus())
					{
					fr.setVisible(false);
					}
					else  if(credits.hasFocus())
					{
						Credits a;
						try {
							a = new Credits();
				    	    a.getCredits();
						} catch (IOException e2) {
							e2.printStackTrace();
						}

					}
					else {
						JOptionPane.showMessageDialog(null, " Enter Integers 1 - 99 ", "Error", JOptionPane.ERROR_MESSAGE);
					}
					} catch (HeadlessException e1) {
					JOptionPane.showMessageDialog(null, " You Need Keyboard to Run this App ", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
									
			public Color getbandColors(int a) 
			{
												
				if(a==0)
				{   
					return Color.BLACK;
				}
				else if(a==1)
				{
					return new Color(102,51,0);
				}
				else if(a==2)
				{
					return Color.RED;
				}
				else if(a==3)
				{
					return Color.ORANGE;
				}
				else if(a==4)
				{
					return Color.YELLOW;
				}
				else if(a==5)
				{
					return Color.GREEN;
				}
				else if(a==6)
				{
					return Color.BLUE;
				}
				else if(a==7)
				{
					return new Color(102,0,153);
				}
				else if(a==8)
				{
					return Color.GRAY;
				}
				else if(a==9)
				{
					return Color.WHITE;
				}	
				else 
					return Color.BLACK;
			}
			
			public String getColorName(int a) 
			{
												
				if(a==0)
				{   
					return "BLACK";
				}
				else if(a==1)
				{
					return "BROWN";
				}
				else if(a==2)
				{
					return "RED";
				}
				else if(a==3)
				{
					return "ORANGE";
				}
				else if(a==4)
				{
					return "YELLOW";
				}
				else if(a==5)
				{
					return "GREEN";
				}
				else if(a==6)
				{
					return "BLUE";
				}
				else if(a==7)
				{
					return "VIOLET";
				}
				else if(a==8)
				{
					return "GRAY";
				}
				else if(a==9)
				{
					return "WHITE";
				}	
				else 
					return "BLACK";
			}
			
			public Color getTolColors(String a)
			  {
				  if(a=="5%")
				  {
					  return new Color(255,215,0);
				  }
				  else if(a=="10%")
				  {
					  return new Color(197,197,197);
				  }
				  else if(a=="20%")
				  {
					  return new Color(207,179,105);
				  }
				  else {
					  return new Color(207,179,105);
				  }
			  }		
		
			public String getTolName(String a)
			  {
				  if(a=="5%")
				  {
					  return "GOLD";
				  }
				  else if(a=="10%")
				  {
					  return "SILVER";
				  }
				  else if(a=="20%")
				  {
					  return "NONE";
				  }
				  else {
					  return "NONE";
				  }
			  }		    
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
	

}
