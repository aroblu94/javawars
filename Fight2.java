
import java.awt.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.event.*;
public class Fight2 extends JFrame{
		Personaggio p;
		Personaggio e;
	public Fight2(Personaggio p, Personaggio e){
		this.p=p;
		this.e=e;

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

		final int hp=p.getCampi();
		final int atk=p.getMet();
		final int def=p.getCost();
		final String m1=p.getM1();
		final String m2=p.getM2();
		final String m3=p.getM3();
		final String m4=p.getM4();
		final int d1=p.getD1();
		final int d2=p.getD2();
		final int d3=p.getD3();
		final int d4=p.getD4();

		final int hp1=e.getCampini();
		final int atk1=e.getMet();
		final int def1=e.getCost();
		final String m11=e.getM1();
		final String m21=e.getM2();
		final String m31=e.getM3();
		final String m41=e.getM4();
		final int d11=e.getD1();
		final int d21=e.getD2();
		final int d31=e.getD3();
		final int d41=e.getD4();
	
		final Random ran=new Random();

		JButton btnm1=new JButton(m1);
		JButton btnm2=new JButton(m2);
		JButton btnm3=new JButton(m3);
		JButton btnm4=new JButton(m4);
		final ImagePanel c=new ImagePanel(new ImageIcon(ClassLoader.getSystemResource("src/select.png")).getImage());
		c.setLayout(new GridBagLayout());
		final GridBagConstraints cbt=new GridBagConstraints();
		cbt.fill=GridBagConstraints.CENTER;

		btnm1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				int cas=ran.nextInt(3)+1;
				int g=0;
				String m="";
				switch(cas){
				case 1: g=hp-(((d11*3/2)+atk1-def)*3/4); m=m11; break;
				case 2: g=hp-(((d21*3/2)+atk1-def)*3/4); m=m21; break;
				case 3: g=hp-(((d31*3/2)+atk1-def)*3/4); m=m31; break;
				case 4: g=hp-(((d41*3/2)+atk1-def)*3/4); m=m41; break;
				}
				int l=hp1-(((d1*3/2)+atk-def1)*3/4);
				if(l<0)
					l=0;
				if(g<0)
					g=0;


				getPer().aggiorna(getPer().getNome(),getPer().getPass(),getPer().getPack(),g,getPer().getCampini(),getPer().getMet(),getPer().getCost(), getPer().getM1(),getPer().getM2(),getPer().getM3(),getPer().getM4(),getPer().getD1(),getPer().getD2(),getPer().getD3(),getPer().getD4(), getPer().getInter(),getPer().getEcce(),getPer().getSottocl(),getPer().getGpoi());

				getAvv().aggiornaAvve(getAvv().getNome(),getAvv().getPass(),getAvv().getPack(),getAvv().getCampi(),l,getAvv().getMet(),getAvv().getCost(), getAvv().getM1(),getAvv().getM2(),getAvv().getM3(),getAvv().getM4(),getAvv().getD1(),getAvv().getD2(),getAvv().getD3(),getAvv().getD4(), getAvv().getInter(),getAvv().getEcce(),getAvv().getSottocl(),getAvv().getGpoi());
				c.removeAll();
				ImagePanel imp=new ImagePanel(new ImageIcon(ClassLoader.getSystemResource("src/select2.png")).getImage());
				JLabel testo=new JLabel(getPer().getNome()+" hai attaccato con "+m1+" lasciando l'avversario con "+l+" di vita");
				JLabel testo1=new JLabel(getAvv().getNome()+" ti ha attaccato con "+m+" lasciando lasciandoti con "+g+" di vita");
				JButton btncont=new JButton("Continua");
				btncont.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						setVisible(false);
						new Fight1();		
					}
				});
				
				imp.setLayout(new GridBagLayout());
				GridBagConstraints cbt=new GridBagConstraints();
				cbt.fill=GridBagConstraints.CENTER;
				cbt.gridx=0;
				cbt.gridy=0;
				cbt.gridwidth=2;
				imp.add(testo,cbt);
				cbt.gridx=0;
				cbt.gridy=1;
				cbt.gridwidth=2;
				imp.add(testo1,cbt);
				cbt.gridx=1;
				cbt.gridy=2;
				cbt.gridwidth=1;
				cbt.weighty=1;
				imp.add(btncont,cbt);
				c.removeAll();
				c.add(imp);
				c.validate();
				c.repaint();
			}
		});

		btnm2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				int cas=ran.nextInt(3)+1;
				int g=0;
				String m="";
				switch(cas){
				case 1: g=hp-(((d11*3/2)+atk1-def)*3/4); m=m11; break;
				case 2: g=hp-(((d21*3/2)+atk1-def)*3/4); m=m21; break;
				case 3: g=hp-(((d31*3/2)+atk1-def)*3/4); m=m31; break;
				case 4: g=hp-(((d41*3/2)+atk1-def)*3/4); m=m41; break;
				}
				int l=hp1-(((d2*3/2)+atk-def1)*3/4);
				if(l<0)
					l=0;
				if(g<0)
					g=0;

				ImagePanel imp=new ImagePanel(new ImageIcon(ClassLoader.getSystemResource("src/select2.png")).getImage());
				getPer().aggiorna(getPer().getNome(),getPer().getPass(),getPer().getPack(),g,getPer().getCampini(),getPer().getMet(),getPer().getCost(), getPer().getM1(),getPer().getM2(),getPer().getM3(),getPer().getM4(),getPer().getD1(),getPer().getD2(),getPer().getD3(),getPer().getD4(), getPer().getInter(),getPer().getEcce(),getPer().getSottocl(),getPer().getGpoi());

				getAvv().aggiornaAvve(getAvv().getNome(),getAvv().getPass(),getAvv().getPack(),getAvv().getCampi(),l,getAvv().getMet(),getAvv().getCost(), getAvv().getM1(),getAvv().getM2(),getAvv().getM3(),getAvv().getM4(),getAvv().getD1(),getAvv().getD2(),getAvv().getD3(),getAvv().getD4(), getAvv().getInter(),getAvv().getEcce(),getAvv().getSottocl(),getAvv().getGpoi());
c.removeAll();
				JLabel testo=new JLabel(getPer().getNome()+" hai attaccato con "+m2+" lasciando l'avversario con "+l+" di vita");
				JLabel testo1=new JLabel(getAvv().getNome()+" ti ha attaccato con "+m+" lasciando lasciandoti con "+g+" di vita");
				JButton btncont=new JButton("Continua");
				btncont.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						setVisible(false);
						new Fight1();		
					}
				});
				imp.setLayout(new GridBagLayout());
				GridBagConstraints cbt=new GridBagConstraints();
				cbt.fill=GridBagConstraints.CENTER;
				cbt.gridx=0;
				cbt.gridy=0;
				cbt.gridwidth=2;
				imp.add(testo,cbt);
				cbt.gridx=0;
				cbt.gridy=1;
				cbt.gridwidth=2;
				imp.add(testo1,cbt);
				cbt.gridx=1;
				cbt.gridy=2;
				cbt.gridwidth=1;
				cbt.weighty=1;
				imp.add(btncont,cbt);
				c.removeAll();
				c.add(imp);
				c.validate();
				c.repaint();
			}
		});

		btnm3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				int cas=ran.nextInt(3)+1;
				int g=0;
				String m="";
				switch(cas){
				case 1: g=hp-(((d11*3/2)+atk1-def)*3/4); m=m11; break;
				case 2: g=hp-(((d21*3/2)+atk1-def)*3/4); m=m21; break;
				case 3: g=hp-(((d31*3/2)+atk1-def)*3/4); m=m31; break;
				case 4: g=hp-(((d41*3/2)+atk1-def)*3/4); m=m41; break;
				}
				int l=hp1-(((d3*3/2)+atk-def1)*3/4);
				if(l<0)
					l=0;
				if(g<0)
					g=0;
				ImagePanel imp=new ImagePanel(new ImageIcon(ClassLoader.getSystemResource("src/select2.png")).getImage());
				getPer().aggiorna(getPer().getNome(),getPer().getPass(),getPer().getPack(),g,getPer().getCampini(),getPer().getMet(),getPer().getCost(), getPer().getM1(),getPer().getM2(),getPer().getM3(),getPer().getM4(),getPer().getD1(),getPer().getD2(),getPer().getD3(),getPer().getD4(), getPer().getInter(),getPer().getEcce(),getPer().getSottocl(),getPer().getGpoi());

				getAvv().aggiornaAvve(getAvv().getNome(),getAvv().getPass(),getAvv().getPack(),getAvv().getCampi(),l,getAvv().getMet(),getAvv().getCost(), getAvv().getM1(),getAvv().getM2(),getAvv().getM3(),getAvv().getM4(),getAvv().getD1(),getAvv().getD2(),getAvv().getD3(),getAvv().getD4(), getAvv().getInter(),getAvv().getEcce(),getAvv().getSottocl(),getAvv().getGpoi());
c.removeAll();
				JLabel testo=new JLabel(getPer().getNome()+" hai attaccato con "+m3+" lasciando l'avversario con "+l+" di vita");
				JLabel testo1=new JLabel(getAvv().getNome()+" ti ha attaccato con "+m+" lasciando lasciandoti con "+g+" di vita");
				JButton btncont=new JButton("Continua");
				btncont.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						setVisible(false);
						new Fight1();		
					}
				});
				imp.setLayout(new GridBagLayout());
				GridBagConstraints cbt=new GridBagConstraints();
				cbt.fill=GridBagConstraints.CENTER;
				cbt.gridx=0;
				cbt.gridy=0;
				cbt.gridwidth=2;
				imp.add(testo,cbt);
				cbt.gridx=0;
				cbt.gridy=1;
				cbt.gridwidth=2;
				imp.add(testo1,cbt);
				cbt.gridx=1;
				cbt.gridy=2;
				cbt.gridwidth=1;
				cbt.weighty=1;
				imp.add(btncont,cbt);
				c.removeAll();
				c.add(imp);
				c.validate();
				c.repaint();
			}
		});

		btnm4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				int cas=ran.nextInt(3)+1;
				int g=0;
				String m="";
				switch(cas){
				case 1: g=hp-(((d11*3/2)+atk1-def)*3/4); m=m11; break;
				case 2: g=hp-(((d21*3/2)+atk1-def)*3/4); m=m21; break;
				case 3: g=hp-(((d31*3/2)+atk1-def)*3/4); m=m31; break;
				case 4: g=hp-(((d41*3/2)+atk1-def)*3/4); m=m41; break;
				}
				int l=hp1-(((d4*3/2)+atk-def1)*3/4);
				if(l<0)
					l=0;
				if(g<0)
					g=0;

				ImagePanel imp=new ImagePanel(new ImageIcon(ClassLoader.getSystemResource("src/select2.png")).getImage());
				getPer().aggiorna(getPer().getNome(),getPer().getPass(),getPer().getPack(),g,getPer().getCampini(),getPer().getMet(),getPer().getCost(), getPer().getM1(),getPer().getM2(),getPer().getM3(),getPer().getM4(),getPer().getD1(),getPer().getD2(),getPer().getD3(),getPer().getD4(), getPer().getInter(),getPer().getEcce(),getPer().getSottocl(),getPer().getGpoi());

				getAvv().aggiornaAvve(getAvv().getNome(),getAvv().getPass(),getAvv().getPack(),getAvv().getCampi(),l,getAvv().getMet(),getAvv().getCost(), getAvv().getM1(),getAvv().getM2(),getAvv().getM3(),getAvv().getM4(),getAvv().getD1(),getAvv().getD2(),getAvv().getD3(),getAvv().getD4(), getAvv().getInter(),getAvv().getEcce(),getAvv().getSottocl(),getAvv().getGpoi());
c.removeAll();
				JLabel testo=new JLabel(getPer().getNome()+" hai attaccato con "+m4+" lasciando l'avversario con "+l+" di vita");
				JLabel testo1=new JLabel(getAvv().getNome()+" ti ha attaccato con "+m+" lasciando lasciandoti con "+g+" di vita");
				JButton btncont=new JButton("Continua");
				btncont.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						setVisible(false);
						new Fight1();		
					}
				});
				imp.setLayout(new GridBagLayout());
				GridBagConstraints cbt=new GridBagConstraints();
				cbt.fill=GridBagConstraints.CENTER;
				cbt.gridx=0;
				cbt.gridy=0;
				cbt.gridwidth=2;
				imp.add(testo,cbt);
				cbt.gridx=0;
				cbt.gridy=1;
				cbt.gridwidth=2;
				imp.add(testo1,cbt);
				cbt.gridx=1;
				cbt.gridy=2;
				cbt.gridwidth=1;
				cbt.weighty=1;
				imp.add(btncont,cbt);
				c.removeAll();
				c.add(imp);
				c.validate();
				c.repaint();
			}
		});

		JButton escape=new JButton("Fuggi");
		escape.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Menu(getPer());
				setVisible(false);
			}
		});
		
		JLabel lbsc=new JLabel("Scegli il Metodo con cui attaccare");
		cbt.gridx=1;
		cbt.gridy=0;
		cbt.weightx=1;
		cbt.weighty=1;
		c.add(lbsc,cbt);
		
		cbt.gridx=0;
		cbt.gridy=1;
		cbt.weightx=1;
		cbt.weighty=1;
		c.add(btnm1,cbt);
		
		cbt.gridx=2;
		cbt.gridy=1;
		cbt.weightx=1;
		cbt.weighty=1;
		c.add(btnm2,cbt);
		
		cbt.gridx=0;
		cbt.gridy=2;
		cbt.weightx=1;
		cbt.weighty=1;
		c.add(btnm3,cbt);
		
		cbt.gridx=2;
		cbt.gridy=2;
		cbt.weightx=1;
		cbt.weighty=1;
		c.add(btnm4,cbt);
		
		cbt.gridx=1;
		cbt.gridy=3;
		cbt.weightx=1;
		cbt.weighty=1;
		c.add(escape,cbt);

		setSize(700,500);
		setLocation(35,35);
		getContentPane().add(c);
				setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public Personaggio getPer(){
		return p;
	}

	public Personaggio getAvv(){
		return e;
	}
}



