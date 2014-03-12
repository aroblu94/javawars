
import java.awt.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.event.*;
public class Mod extends JFrame{
	Personaggio p;
	public Mod(Personaggio p){
		this.p=p;
		
	class ImagePanel extends JPanel{
			private Image img;
			public ImagePanel(String img){
				this(new ImageIcon(img).getImage());
			}
			public ImagePanel(Image img){
				this.img=img;
				Dimension size=new Dimension(img.getWidth(null), img.getHeight(null));
				setPreferredSize(size);
				setMinimumSize(size);
				setMaximumSize(size);
				setSize(size);
				setLayout(null);
			}
			public void paintComponent(Graphics g){
				g.drawImage(img,0,0,null);
			}
		}


		JLabel lb=new JLabel("Gedit Points: "+getPer().getGpoi());
		final String m1=p.getM1();
		final String m2=p.getM2();
		final String m3=p.getM3();
		final String m4=p.getM4();
		final ImagePanel c=new ImagePanel(new ImageIcon(ClassLoader.getSystemResource("src/geditback.png")).getImage());
		c.setLayout(new GridBagLayout());
		final GridBagConstraints cbt=new GridBagConstraints();
		cbt.fill=GridBagConstraints.CENTER;
		
		JButton btnm1=new JButton(m1);
		JButton btnm2=new JButton(m2);
		JButton btnm3=new JButton(m3);
		JButton btnm4=new JButton(m4);
		JButton btnesc=new JButton("Menu");
		
		cbt.gridx=0;
		cbt.gridy=1;
		cbt.insets.top = 80;
		cbt.weightx=1;
		cbt.anchor=GridBagConstraints.LINE_START;
		c.add(lb,cbt);
		
		cbt.insets.top = 80;
		cbt.gridx=1;
		cbt.gridy=1;
		cbt.weightx=1;
		cbt.weighty=1;
		cbt.anchor=GridBagConstraints.EAST;
		c.add(btnm1,cbt);
		
		cbt.gridx=3;
		cbt.gridy=1;
		cbt.anchor=GridBagConstraints.WEST;
		c.add(btnm2,cbt);
		
		cbt.gridx=1;
		cbt.gridy=2;
		cbt.weighty=1;
		cbt.anchor=GridBagConstraints.EAST;
		c.add(btnm3,cbt);
		
		cbt.gridx=3;
		cbt.gridy=2;
		cbt.anchor=GridBagConstraints.WEST;
		c.add(btnm4,cbt);
		
		cbt.gridx=2;
		cbt.gridy=3;
		cbt.weighty=1;
		cbt.anchor=GridBagConstraints.CENTER;
		c.add(btnesc,cbt);

		btnesc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){	
				setVisible(false);
				new Menu(getPer());		
			}
		});

		btnm1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				if(getPer().getGpoi()>0){
					getPer().loseGpoi();
					c.removeAll();
					JLabel testo=new JLabel("Nuovo Metodo");
					final JTextField testo1=new JTextField("Metodo",20);
					JButton btncont=new JButton("Continua");

					btncont.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							getPer().setM1(testo1.getText());
							Personaggio.aggiornaPer(getPer());
							setVisible(false);
							new Mod(getPer());		
						}
					});
					
				c.removeAll();
				GridBagConstraints cbt=new GridBagConstraints();
				cbt.fill=GridBagConstraints.CENTER;
				cbt.gridx=0;
				cbt.gridy=0;		
				cbt.insets.top = 80;
				cbt.anchor=GridBagConstraints.SOUTH;
				c.add(testo,cbt);
				cbt.gridx=0;
				cbt.gridy=1;
				cbt.gridwidth=2;
				cbt.anchor=GridBagConstraints.NORTH;
				c.add(testo1,cbt);
				cbt.gridx=0;
				cbt.gridy=2;
				cbt.gridwidth=1;
				cbt.weighty=1;
				c.add(btncont,cbt);
				c.validate();
				c.repaint();
				}
			}
		});
		

		btnm2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				if(getPer().getGpoi()>0){
					getPer().loseGpoi();
					c.removeAll();
					JLabel testo=new JLabel("Nuovo Metodo");
					final JTextField testo1=new JTextField("Metodo",20);
					JButton btncont=new JButton("Continua");

					btncont.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							getPer().setM2(testo1.getText());
							Personaggio.aggiornaPer(getPer());
							setVisible(false);
							new Mod(getPer());		
						}
					});

				GridBagConstraints cbt=new GridBagConstraints();
				cbt.gridx=0;
				cbt.gridy=0;		
				cbt.insets.top = 80;
				cbt.anchor=GridBagConstraints.SOUTH;
				c.add(testo,cbt);
				cbt.gridx=0;
				cbt.gridy=1;
				cbt.gridwidth=2;
				cbt.anchor=GridBagConstraints.NORTH;
				c.add(testo1,cbt);
				cbt.gridx=0;
				cbt.gridy=2;
				cbt.gridwidth=1;
				cbt.weighty=1;
				c.add(btncont,cbt);
				c.validate();
				c.repaint();
				}
			}
		});

		btnm3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				if(getPer().getGpoi()>0){
					getPer().loseGpoi();
					c.removeAll();
					JLabel testo=new JLabel("Nuovo Metodo");
					final JTextField testo1=new JTextField("Metodo",20);
					JButton btncont=new JButton("Continua");

					btncont.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							getPer().setM3(testo1.getText());
							Personaggio.aggiornaPer(getPer());
							setVisible(false);
							new Mod(getPer());		
						}
					});
					
				cbt.gridx=0;
				cbt.gridy=0;		
				cbt.insets.top = 80;
				cbt.anchor=GridBagConstraints.SOUTH;
				c.add(testo,cbt);
				cbt.gridx=0;
				cbt.gridy=1;
				cbt.gridwidth=2;
				cbt.anchor=GridBagConstraints.NORTH;
				c.add(testo1,cbt);
				cbt.gridx=0;
				cbt.gridy=2;
				cbt.gridwidth=1;
				cbt.weighty=1;
				c.add(btncont,cbt);
				c.validate();
				c.repaint();
				}
			}
		});


		btnm4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				if(getPer().getGpoi()>0){
					getPer().loseGpoi();
					c.removeAll();
					JLabel testo=new JLabel("Nuovo Metodo");
					final JTextField testo1=new JTextField("Metodo",20);
					JButton btncont=new JButton("Continua");

					btncont.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							getPer().setM4(testo1.getText());
							Personaggio.aggiornaPer(getPer());
							setVisible(false);
							new Mod(getPer());		
						}
					});

				cbt.gridx=0;
				cbt.gridy=0;		
				cbt.insets.top = 80;
				cbt.anchor=GridBagConstraints.SOUTH;
				c.add(testo,cbt);
				cbt.gridx=0;
				cbt.gridy=1;
				cbt.gridwidth=2;
				cbt.anchor=GridBagConstraints.NORTH;
				c.add(testo1,cbt);
				cbt.gridx=0;
				cbt.gridy=2;
				cbt.gridwidth=1;
				cbt.weighty=1;
				c.add(btncont,cbt);
				c.validate();
				c.repaint();
				}
			}
		});

		setSize(700,500);
		setLocation(35,35);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(c);
				setResizable(false);
		setVisible(true);
	}

	public Personaggio getPer(){
		return p;
	}
}
