
import java.awt.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.event.*;
public class Shop{
		Personaggio p;
	public Shop(Personaggio p){
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

		final JFrame f=new JFrame();
		final ImagePanel pan=new ImagePanel(new ImageIcon(ClassLoader.getSystemResource("src/backshop.png")).getImage());

		pan.setLayout(new GridBagLayout());
		final GridBagConstraints cbt=new GridBagConstraints();
		cbt.fill=GridBagConstraints.CENTER;

		ImageIcon im=new ImageIcon(ClassLoader.getSystemResource("src/btnCura.png"));
		

		JButton btnric=new JButton(/*"Compra Ricarica ",*/im);
		JButton btnback=new JButton("Menu");
		JLabel lbmoney=new JLabel("Interfacce: "+p.getInter());
		JButton btnpot=new JButton("Potenzia le tue statistiche",new ImageIcon(ClassLoader.getSystemResource("src/potenzia.png")));

		//da aggiungere: comprare potenziamenti, comprare mosse più forti

		btnback.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				f.setVisible(false);
				new Menu(getPer());
			}
		});

		btnric.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(getPer().getInter()>=100){
					getPer().loseInter(100);
					getPer().setCampi(getPer().getCampini());
					Personaggio.aggiornaPer(getPer());
				}else{
					JOptionPane.showMessageDialog(f,"Non hai abbastanza soldi!", "ERRORE", JOptionPane.ERROR_MESSAGE);
				}
				f.setVisible(false);
				new Shop(getPer());
			}
		});
		
		JButton btnmet=new JButton("Impara nuovi metodi",new ImageIcon(ClassLoader.getSystemResource("src/learn.png")));
		btnmet.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
				final ShopItem sh=new ShopItem();
				sh.getAcquisto();
				JLabel lb=new JLabel("Il negozio propone l'acquisto di "+sh.getNome()+" al prezzo di "+sh.getPrezzo()+".\n Acquistare?");
				final int max=80;
				final JProgressBar pb1=new JProgressBar();
				pb1.setMinimum(0);
				pb1.setMaximum(max);
				pb1.setStringPainted(true);
				pb1.setValue(sh.getDanno());
				JButton si=new JButton("si");
				JButton no=new JButton("no");
				si.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(getPer().getInter()>=sh.getPrezzo()){
							JLabel lbd=new JLabel("Scegli quale metodo vuoi sovrascrivere");
							JButton m1=new JButton(getPer().getM1());
							JButton m2=new JButton(getPer().getM2());
							JButton m3=new JButton(getPer().getM3());
							JButton m4=new JButton(getPer().getM4());
							JButton ind=new JButton("Esci");
							
							ind.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									new Shop(getPer());
									f.setVisible(false);
								}
							});
							
							m1.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent ev){
							getPer().loseInter(sh.getPrezzo());
							getPer().setM1(sh.getNome(),sh.getDanno());
							Personaggio.aggiornaPer(getPer());
							f.setVisible(false);
							new Shop(getPer());		
								}
							});
							
							m2.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent ev){
							getPer().loseInter(sh.getPrezzo());
							getPer().setM2(sh.getNome(),sh.getDanno());
							Personaggio.aggiornaPer(getPer());
							f.setVisible(false);
							new Shop(getPer());		
								}
							});
							
							m3.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent ev){
							getPer().loseInter(sh.getPrezzo());
							getPer().setM3(sh.getNome(),sh.getDanno());
							Personaggio.aggiornaPer(getPer());
							f.setVisible(false);
							new Shop(getPer());		
								}
							});
							
							m4.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent ev){
							getPer().loseInter(sh.getPrezzo());
							getPer().setM4(sh.getNome(),sh.getDanno());
							Personaggio.aggiornaPer(getPer());
							f.setVisible(false);
							new Shop(getPer());		
								}
							});
							
							pan.removeAll();
							cbt.gridx=2;
							cbt.gridy=0;
							pan.add(lbd,cbt);
							cbt.gridx=0;
							cbt.gridy=1;
							pan.add(m1,cbt);
							cbt.gridx=3;
							cbt.gridy=1;
							pan.add(m2,cbt);
							cbt.gridx=0;
							cbt.gridy=2;
							pan.add(m3,cbt);
							cbt.gridx=3;
							cbt.gridy=2;
							pan.add(m4,cbt);
							cbt.gridx=2;
							cbt.gridy=3;
							pan.add(ind,cbt);
							pan.validate();
							pan.repaint();
						
						
						}else{
							JOptionPane.showMessageDialog(f,"Non hai abbastanza soldi!", "ERRORE", JOptionPane.ERROR_MESSAGE);
							f.setVisible(false);
							new Shop(getPer());
						}
					}
				});
				
				no.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						new Shop(getPer());
						f.setVisible(false);
					}
				});
				pan.removeAll();
				cbt.gridx=0;
				cbt.gridy=0;
				pan.add(lb,cbt);
				
				cbt.gridx=0;
				cbt.gridy=1;
				pan.add(pb1,cbt);
				
				cbt.gridx=0;
				cbt.gridy=2;
				pan.add(si,cbt);
				
				cbt.gridx=0;
				cbt.gridy=3;
				pan.add(no,cbt);
				
				pan.validate();
				pan.repaint();
				}catch(IOException ex){
					System.out.println("prrrrrr");
				}
			}
		});

		btnpot.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JLabel lb=new JLabel("Scegli quale Statistica aumentare al costo di 5000 interfacce");
				JButton met=new JButton("Metodi");
				JButton campi=new JButton("Campi");
				JButton lev=new JButton("SottoClassi");
				JButton cos=new JButton("Costruttori");
				JButton ind=new JButton("indietro");
				JLabel mo=new JLabel("Interfacce: "+getPer().getInter());
				
				ind.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						f.setVisible(false);
						new Menu(getPer());
					}
				});

				met.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						getPer().addMet();
						Personaggio.aggiornaPer(getPer());
					}
				});
				
				campi.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						getPer().addCampi();
						Personaggio.aggiornaPer(getPer());
					}
				});
				
				cos.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						getPer().addCost();
						Personaggio.aggiornaPer(getPer());
					}
				});
				
				lev.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						getPer().addLev();
						Personaggio.aggiornaPer(getPer());
					}
				});
				
				pan.removeAll();
				cbt.gridx=1;
				cbt.gridy=0;
				pan.add(mo,cbt);
				
				cbt.gridx=1;
				cbt.gridy=1;
				pan.add(lb,cbt);
				
				cbt.gridx=0;
				cbt.gridy=2;
				pan.add(campi,cbt);
				
				cbt.gridx=2;
				cbt.gridy=2;
				pan.add(met,cbt);
				
				cbt.gridx=0;
				cbt.gridy=3;
				pan.add(cos,cbt);
				
				cbt.gridx=2;
				cbt.gridy=3;
				pan.add(lev,cbt);
				
				cbt.gridx=1;
				cbt.gridy=4;
				pan.add(ind,cbt);
				pan.validate();
				pan.repaint();
			}
		});
		
		cbt.gridx=2;
		cbt.gridy=1;
		pan.add(lbmoney,cbt);

		cbt.gridx=2;
		cbt.gridy=2;
		pan.add(btnback,cbt);
		
		cbt.gridx=0;
		cbt.gridy=0;
		pan.add(btnpot,cbt);

		cbt.gridx=1;
		cbt.gridy=1;
		pan.add(btnric, cbt);
		
		cbt.gridx=2;
		cbt.gridy=0;
		pan.add(btnmet, cbt);



		f.setSize(700,500);
		f.setLocation(35,35);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(pan);
		f.setVisible(true);
	}

	public Personaggio getPer(){
		return p;
	}
}
