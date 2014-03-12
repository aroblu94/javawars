
import java.awt.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.event.*;
public class Win extends JFrame{
		Personaggio p;
	public Win(Personaggio p, int esp,int money){
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



		ImagePanel pan=new ImagePanel(new ImageIcon(ClassLoader.getSystemResource("src/win.png")).getImage());
		JLabel lbte=new JLabel("hai sconfitto il tuo avversario e guadagnato "+esp+" di esperienza e "+money+" interfacce");
		JButton btnok=new JButton("Continua");
		pan.setLayout(new GridBagLayout());
		GridBagConstraints cbt=new GridBagConstraints();
		cbt.fill=GridBagConstraints.CENTER;
		cbt.gridx=0;
		cbt.gridy=0;
		cbt.gridwidth=3;
		cbt.insets.top=1;
		cbt.anchor=GridBagConstraints.NORTH;
		pan.add(lbte,cbt);
		
		cbt.gridx=1;
		cbt.gridy=1;
		cbt.weighty=1;
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public Personaggio getPer(){
		return p;
	}
}
