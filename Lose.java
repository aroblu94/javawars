
import java.awt.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.event.*;
public class Lose extends JFrame{
		Personaggio p;
	public Lose(Personaggio p){
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


		ImagePanel pan=new ImagePanel(new ImageIcon(ClassLoader.getSystemResource("src/lose.png")).getImage());
		pan.setLayout(new GridBagLayout());
		GridBagConstraints cbt=new GridBagConstraints();
		cbt.fill=GridBagConstraints.HORIZONTAL;
		
		cbt.gridx=0;
		cbt.gridy=0;
		JLabel lbte=new JLabel("sei stato sconfitto!");
		lbte.setBackground(Color.WHITE);
		pan.add(lbte,cbt);
		
		JLabel lbb=new JLabel("Visita il negozio per acquistare un pacchetto salute");		
		cbt.gridx=0;
		cbt.gridy=1;
		lbte.setBackground(Color.WHITE);
		pan.add(lbb,cbt);
		
		cbt.gridx=0;
		cbt.gridy=2;		
		JButton btnok=new JButton("Continua");
		pan.add(btnok,cbt);

		btnok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){		
				new Menu(getPer());
				setVisible(false);
			}
		});
				
		
		setSize(700,500);
		setLocation(35,35);
		getContentPane().add(pan);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setResizable(false);
		setVisible(true);
	}

	public Personaggio getPer(){
		return p;
	}
}
