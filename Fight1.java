
import java.awt.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.event.*;
public class Fight1{
	Personaggio p,e;
	public Fight1(){

		p=Personaggio.carica();
		e=Personaggio.caricaAvv2();		

		if(p.getCampi()>0 && e.getCampini()>0){
			new Fight2(getPer(),getAvv());
		}

		if(p.getCampi()==0 && e.getCampini()>0){
			p.loseInter();
			Personaggio.aggiornaPer(p);
			new Lose(p);
		}

		if(p.getCampi()>0 && e.getCampini()==0){
			int gain=p.addEcce();
			int lose=p.addInter();
			Personaggio.aggiornaPer(p);
			new Win(getPer(),gain,lose);
		}

		if(p.getCampi()==0 && e.getCampini()==0){
			Random r=new Random();
			int c=r.nextInt(1)+1;
			if(c==1){
				int gain=p.addEcce();
				int lose=p.addInter();
				Personaggio.aggiornaPer(p);
				new Win(getPer(),gain,lose);
			}
			if(c==2){
				p.loseInter();
				Personaggio.aggiornaPer(p);
				new Lose(p);
			}
		}
	}

	public Personaggio getPer(){
		return p;
	}
	
	public Personaggio getAvv(){
		return e;
	}
}
