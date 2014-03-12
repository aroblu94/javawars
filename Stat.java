
import java.awt.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.event.*;
public class Stat extends JFrame{
		Personaggio p;
	public Stat(Personaggio p){
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

		ImagePanel pan=new ImagePanel(new ImageIcon(ClassLoader.getSystemResource("src/docu.png")).getImage());
		Font f=new Font(pan.getName(),Font.BOLD,30);
		pan.setLayout(null);

		JLabel lbnome=new JLabel(p.getNome());
		JLabel lbpack =new JLabel("Package: "+ p.getPack());
		JLabel lbcampi =new JLabel("Campi: "+p.getCampi()+" su "+p.getCampini());
		JLabel lbcost =new JLabel("Costruttori: "+p.getCost());
		JLabel lbmet =new JLabel("Metodi: "+ p.getMet());
		JLabel lbm1 =new JLabel("Metodo 1: "+p.getM1());
		JLabel lbm2 =new JLabel("Metodo 2: "+p.getM2());
		JLabel lbm3 =new JLabel("Metodo 3: "+p.getM3());
		JLabel lbm4 =new JLabel("Metodo 4: "+p.getM4());
		JLabel lbecce =new JLabel("Eccezioni: "+p.getEcce());
		JLabel lbsotto =new JLabel("Sottoclassi: "+p.getSottocl());
		JButton back=new JButton("indietro");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				new Menu(getPer());
			}
		});
		JLabel im=new JLabel();
		im.setIcon(new ImageIcon(ClassLoader.getSystemResource("src/"+p.getPack()+".jpg")));
		im.setBounds(480,60,120,120);
		pan.add(im);
		
		final int max=80;
		final JProgressBar pb1=new JProgressBar();
		pb1.setMinimum(0);
		pb1.setMaximum(max);
		pb1.setStringPainted(true);
		final int cv=p.getD1();
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					pb1.setValue(cv);
				}
			});
		pb1.setBounds(540,220,100,15);
		pan.add(pb1);
		
		final JProgressBar pb2=new JProgressBar();
		pb2.setMinimum(0);
		pb2.setMaximum(max);
		pb2.setStringPainted(true);
		final int cv2=p.getD2();
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					pb2.setValue(cv2);
				}
			});
		pb2.setBounds(540,245,100,15);
		pan.add(pb2);
		
		final JProgressBar pb3=new JProgressBar();
		pb3.setMinimum(0);
		pb3.setMaximum(max);
		pb3.setStringPainted(true);
		final int cv3=p.getD3();
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					pb3.setValue(cv3);
				}
			});
		pb3.setBounds(540,270,100,15);
		pan.add(pb3);
		
				final JProgressBar pb4=new JProgressBar();
		pb4.setMinimum(0);
		pb4.setMaximum(max);
		pb4.setStringPainted(true);
		final int cv4=p.getD4();
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					pb4.setValue(cv4);
				}
			});
		pb4.setBounds(540,295,100,15);
		pan.add(pb4);
		
		lbnome.setBounds(340,60,150,15);
		pan.add(lbnome );
		lbcampi.setBounds(220,80,250,15);
		pan.add(lbcampi );
		lbpack.setBounds(500,185,180,15);
		pan.add(lbpack);
		lbcost.setBounds(220,100,250,15);
		pan.add(lbcost );
		lbmet.setBounds(220,120,250,15);
		pan.add(lbmet );
		lbm1.setBounds(240,225,400,15);
		pan.add(lbm1);
		lbm2.setBounds(240,250,400,15);
		pan.add(lbm2);		
		lbm3.setBounds(240,275,400,15);
		pan.add(lbm3);
		lbm4.setBounds(240,300,400,15);
		pan.add(lbm4);
		lbecce.setBounds(240,360,300,15);
		pan.add(lbecce );
		lbsotto.setBounds(240,390,400,15);
		pan.add(lbsotto );
		back.setBounds(600,450,100,20);
		pan.add(back );

		setSize(700,500);
		setLocation(35,35);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(pan);
				setResizable(false);
		setVisible(true);
	}

	public Personaggio getPer(){
		return p;
	}
}
