
import java.awt.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.event.*;
public class Fight extends JFrame{
		Personaggio p;
	public Fight(Personaggio p){
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

			File file=new File("save/");
			String[] s=file.list();
			ArrayList<String> poss=new ArrayList<String>();
			for (String x:s){
				if((!x.equals("actual.login"))&&(!x.equals("avv.fight")))
					poss.add(x);
			}
			JButton[] avv=new JButton[poss.size()];
			class Select implements ActionListener{
				public void actionPerformed(ActionEvent e){
					JButton btnevent=(JButton)e.getSource();
					try{
						File file=new File("save/avv.fight");
						PrintWriter pr=new PrintWriter(file);
						pr.println(btnevent.getText());
						pr.flush();
						pr.close();
						Personaggio en=Personaggio.caricaAvv1();
						Personaggio.aggiornaAvv(en);
						new Fight1();
						setVisible(false);
					}catch(IOException ex){
						System.out.println("can't logged");
					}
			
				}
			}
			JPanel pannello=new JPanel();
			pannello.setLayout(new BorderLayout());
			ImagePanel pan=new ImagePanel(new ImageIcon(ClassLoader.getSystemResource("src/fight.png")).getImage());
			pan.setLayout(new GridBagLayout());
			final GridBagConstraints cvt=new GridBagConstraints();
			cvt.fill=GridBagConstraints.CENTER;
		
			Select sel=new Select();
			int y=0;
			int x=0;
			for(int i=0;i<poss.size(); i++){
				if(i==3*y){
					y++;
				}
				avv[i]=new JButton(poss.get(i));
				avv[i].addActionListener(sel);
				cvt.gridx=x;
				cvt.gridy=y;
				cvt.weightx=1;
				cvt.weighty=1;
				pan.add(avv[i],cvt);
				x++;
				if(x>2){
					x=0;
				}
		}

		pannello.add(pan, BorderLayout.CENTER);
		JButton back=new JButton("indietro");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				new Menu(getPer());
			}
		});
		pannello.add(back, BorderLayout.PAGE_END);
		
		
		setSize(700,500);
		setLocation(35,35);
		getContentPane().add(pannello);
				setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public Personaggio getPer(){
		return p;
	}
}
