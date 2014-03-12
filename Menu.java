
import java.awt.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.event.*;
public class Menu extends JFrame{
	Personaggio p;
	public Menu(Personaggio p){
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

		ImagePanel menu= new ImagePanel(new ImageIcon(ClassLoader.getSystemResource("src/backmenu.png")).getImage());
		
		final int max=p.getCampini();
		final JProgressBar pb1=new JProgressBar();
		pb1.setMinimum(0);
		pb1.setMaximum(max);
		pb1.setStringPainted(true);
		pb1.setValue(p.getCampi());


	//menu
		menu.setLayout(new GridBagLayout());
		GridBagConstraints cbt=new GridBagConstraints();
		cbt.fill=GridBagConstraints.HORIZONTAL;

		JButton btnstat=new JButton("Statistiche",new ImageIcon(ClassLoader.getSystemResource("src/btndocu.png")));
		btnstat.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					new Stat(getPer());
					setVisible(false);
			}
		});
		
		JButton btnfight=new JButton("Combatti",new ImageIcon(ClassLoader.getSystemResource("src/btnfight.png")));		
		btnfight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					new Fight(getPer());
					setVisible(false);
			}
		});

		JButton btnmod=new JButton("Modifica",new ImageIcon(ClassLoader.getSystemResource("src/gedit.png")));
		btnmod.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					new Mod(getPer());
					setVisible(false);
			}
		});

		JButton btnshop=new JButton("Negozio",new ImageIcon(ClassLoader.getSystemResource("src/btnshop.png")));
		btnshop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					new Shop(getPer());
					setVisible(false);
			}
		});

		JButton btnexit=new JButton("Logout",new ImageIcon(ClassLoader.getSystemResource("src/logout.png")));		
		btnexit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					setVisible(false);
					new Start();
			}
		});
		JButton btnclose=new JButton("Chiudi",new ImageIcon(ClassLoader.getSystemResource("src/out.png")));
		btnclose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					System.exit(0);
			}
		});

		cbt.gridx=1;
		cbt.gridy=0;
		menu.add(pb1,cbt);
		
		cbt.gridx=0;
		cbt.gridy=1;
		menu.add(btnstat,cbt);
		
		cbt.gridx=2;
		cbt.gridy=1;
		menu.add(btnmod,cbt);

		cbt.gridx=1;
		cbt.gridy=2;
		menu.add(btnfight,cbt);

		cbt.gridx=1;
		cbt.gridy=4;
		menu.add(btnclose,cbt);

		cbt.gridx=0;
		cbt.gridy=3;
		menu.add(btnexit,cbt);

		cbt.gridx=2;
		cbt.gridy=3;
		menu.add(btnshop,cbt);


	//gestione frame
		setSize(700,500);
		setLocation(35,35);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(menu);
		setVisible(true);
	}

	public Personaggio getPer(){
		return p;
	}
}
