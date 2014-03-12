
import java.awt.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.event.*;
public class Start{
	public Start(){
		final JFrame f=new JFrame("Menu Iniziale");
		//creo gestore pannelli
		CardLayout manager=new CardLayout();

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

		ImageIcon im=new ImageIcon(ClassLoader.getSystemResource("src/reg.png"));
		ImageIcon im2=new ImageIcon(ClassLoader.getSystemResource("src/login.png"));
		ImagePanel opening= new ImagePanel(new ImageIcon(ClassLoader.getSystemResource("src/back.png")).getImage());
		ImagePanel start= new ImagePanel(new ImageIcon(ClassLoader.getSystemResource("src/back.png")).getImage());
		ImagePanel login= new ImagePanel(new ImageIcon(ClassLoader.getSystemResource("src/back.png")).getImage());
		final ImagePanel register= new ImagePanel(new ImageIcon(ClassLoader.getSystemResource("src/back.png")).getImage());

		manager.addLayoutComponent(start,"start");
		manager.addLayoutComponent(login,"login");
		manager.addLayoutComponent(register,"register");
		manager.addLayoutComponent(opening,"opening");

		//creo pannello gestore e aggiungo gli altri
		final JPanel showmanager=new JPanel(manager);
		showmanager.add(opening);
		showmanager.add(start);
		showmanager.add(login);
		showmanager.add(register);
	
		//Pannello start
		start.setLayout(new GridBagLayout());
		GridBagConstraints cbt=new GridBagConstraints();
		cbt.fill=GridBagConstraints.HORIZONTAL;
		//creo bottone login
		JButton btnLogin= new JButton("Login",im2);
		cbt.gridx=0;
		cbt.gridy=0;
		start.add(btnLogin,cbt);
		//creo bottone registra
		JButton btnRegister=new JButton("Registrati",im);
		cbt.gridx=0;
		cbt.gridy=2;
		start.add(btnRegister, cbt);

		btnRegister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					CardLayout cl=(CardLayout)(showmanager.getLayout());
					cl.show(showmanager,"register"); 
			}
		});

		btnLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					CardLayout cl=(CardLayout)(showmanager.getLayout());
					cl.show(showmanager,"login"); 
			}
		});

		//Pannello Opening


		opening.setLayout(new GridBagLayout());
		cbt=new GridBagConstraints();
		cbt.fill=GridBagConstraints.HORIZONTAL;
		//creo i label
		JButton btnPress=new JButton("GIOCA!");
		//aggiungo
		cbt.gridx=0;
		cbt.gridy=2;
		opening.add(btnPress,cbt);

		btnPress.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					CardLayout cl=(CardLayout)(showmanager.getLayout());
					cl.show(showmanager,"start"); 
			}
		});

		//Pannello register, creo i contenuti
		register.setLayout(new GridBagLayout());
		final GridBagConstraints cvt=new GridBagConstraints();
		cvt.fill=GridBagConstraints.HORIZONTAL;
		JButton registrati=new JButton("Registrati");
		final JLabel lbldesc=new JLabel();
		final JTextField txtnome=new JTextField("NomeClasse",20);
		final JPasswordField txtpass=new JPasswordField("password");
		final JTextField txtm1=new JTextField("Metodo1");
		final JTextField txtm2=new JTextField("Metodo2");
		final JTextField txtm3=new JTextField("Metodo3");
		final JTextField txtm4=new JTextField("Metodo4");
		String [] npackage= {"java.applet","java.lang","java.util","java.io", "java.math", "java.nio", "java.net", "java.awt","java.awt.event","javax.swing", "java.text", "java.sql"};
		final JComboBox cbpackage=new JComboBox(npackage);
		ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("src/java.applet.jpg"));
		lbldesc.setIcon(image);
		
		cbpackage.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String s=cbpackage.getSelectedItem().toString();
					ImageIcon im=new ImageIcon(ClassLoader.getSystemResource("src/"+s+".jpg"));
					lbldesc.setIcon(im);
					register.validate();
					register.repaint();
					
				}
			});
			cvt.gridx=0;
			cvt.gridy=0;
			cvt.gridwidth=6;
			register.add(lbldesc,cvt);
		JButton btnBack[]=new JButton[2];
		btnBack[0]=new JButton("indietro");
		btnBack[1]=new JButton("indietro");

		for(int i=0;i<2;i++){
			btnBack[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
						CardLayout cl=(CardLayout)(showmanager.getLayout());
						cl.show(showmanager,"start"); 
				}
			});
		}


		//aggiungo
		cvt.gridx=0;
		cvt.gridy=0;
		cvt.gridwidth=6;
		register.add(lbldesc,cvt);
		
		cvt.gridx=3;
		cvt.gridy=1;
		cvt.gridwidth=2;
		register.add(txtnome,cvt);

		cvt.gridx=3;
		cvt.gridy=2;
		cvt.gridwidth=2;
		register.add(txtpass,cvt);

		cvt.gridx=3;
		cvt.gridy=3;
		cvt.gridwidth=2;
		register.add(cbpackage,cvt);

		cvt.gridx=3;
		cvt.gridy=4;
		cvt.gridwidth=2;
		register.add(txtm1,cvt);

		cvt.gridx=3;
		cvt.gridy=5;
		cvt.gridwidth=2;
		register.add(txtm2,cvt);

		cvt.gridx=3;
		cvt.gridy=6;
		cvt.gridwidth=2;
		register.add(txtm3,cvt);

		cvt.gridx=3;
		cvt.gridy=7;
		cvt.gridwidth=2;
		register.add(txtm4,cvt);

		cvt.gridx=5;
		cvt.gridy=8;
		cvt.gridwidth=1;
		register.add(registrati,cvt);

		cvt.gridx=5;
		cvt.gridy=10;
		cvt.gridwidth=1;
		register.add(btnBack[0],cvt);
	

		registrati.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{//prima verifica se esiste già un file con quel nome! se esiste impedisce
					File cart=new File("save");
					String[] d=cart.list();
					ArrayList<String> s=new ArrayList<String>();
					for (String x:d)
						s.add(x);
					boolean fai=true;
					for(String c:s){
						if(c.equals(txtnome.getText().trim()))
							fai=false;
					}
					if(fai){
						File file=new File("save/"+txtnome.getText());
						Random ran=new Random();
						PrintWriter p=new PrintWriter(file);
						p.println(txtnome.getText());
						p.println(txtpass.getPassword());
						p.println(cbpackage.getSelectedItem().toString());
						int hp=ran.nextInt(500)+200;
						p.println(hp);
						p.println(hp);
						p.println(ran.nextInt(20));
						p.println(ran.nextInt(20));
						p.println(txtm1.getText());
						p.println(txtm2.getText());
						p.println(txtm3.getText());
						p.println(txtm4.getText());	
						p.println(ran.nextInt(40)+10);
						p.println(ran.nextInt(40)+10);
						p.println(ran.nextInt(40)+10);
						p.println(ran.nextInt(40)+10);
						p.println(1000);
						p.println(0);
						p.println(1);
						p.println(0);
						p.flush();
						p.close();
						CardLayout cl=(CardLayout)(showmanager.getLayout());
						cl.show(showmanager,"start"); 
					}else{
						JOptionPane.showMessageDialog(f,"Il nome scelto esiste gia', inserirne un altro", "ERRORE", JOptionPane.ERROR_MESSAGE);
					}
				}catch(IOException ex){
					System.out.println("errore creapersonaggio");
				}
			}
		});

		//Pannello login
		login.setLayout(new GridBagLayout());
		cbt=new GridBagConstraints();
		cbt.fill=GridBagConstraints.HORIZONTAL;
		final JTextField txtlognome=new JTextField("Classe");
		final JPasswordField txtlogpass=new JPasswordField("password");
		JButton btnLog=new JButton("Login");

		cbt.gridx=1;
		cbt.gridy=0;
		cbt.gridwidth=2;
		login.add(txtlognome,cbt);

		cbt.gridx=1;
		cbt.gridy=1;
		cbt.gridwidth=2;
		login.add(txtlogpass,cbt);

		cbt.gridx=1;
		cbt.gridy=3;
		cbt.gridwidth=1;
		login.add(btnLog, cbt);

		cbt.gridx=2;
		cbt.gridy=3;
		cbt.gridwidth=1;
		login.add(btnBack[1], cbt);

		btnLog.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (Login.authenticate(txtlognome.getText().trim(), new String (txtlogpass.getPassword()))){ //else mostra un dialog che dice login fallito
					try{
						File file=new File("save/actual.login");
						PrintWriter p=new PrintWriter(file);
						p.println(txtlognome.getText());
						p.flush();
						p.close();
						f.setVisible(false);
					}catch(IOException ex){
						System.out.println("can't logged");
					}
					new Menu(Personaggio.carica());	
				}else{
					JOptionPane.showMessageDialog(f,"Nome utente o password errata, reinserire", "ERRORE", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		//gestione frame
		f.setSize(700,500);
		f.setLocation(50,50);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(showmanager);
		f.setVisible(true);
		f.setResizable(false);
	}
}
