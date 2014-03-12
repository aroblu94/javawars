
import java.awt.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.event.*;
public class Personaggio{

	String nome;
	String pass;
	String pack;
	int campi;
	int campini;
	int met;
	int cost;
	String m1;
	String m2;
	String m3;
	String m4;
	int d1;
	int d2;
	int d3;
	int d4;
	int inter;
	int ecce;
	int sottocl;
	int gpoi;
	Random ran=new Random();

	public Personaggio(String n,String p,String pa,int ca,int caini,int met,int cost,String m1,String m2,String m3,String m4,int d1,int d2,int d3,int d4,int inter,int ecce,int sottocl,int gpoi){
		nome=n;
		pass=p;
		pack=pa;
		campi=ca;
		campini=caini;
		this.met=met;
		this.cost=cost;
		this.m1=m1;
		this.d1=d1;
		this.d2=d2;
		this.d3=d3;
		this.d4=d4;	
		this.m2=m2;
		this.m3=m3;
		this.m4=m4;
		this.inter=inter;
		this.ecce=ecce;
		this.sottocl=sottocl;
		this.gpoi=gpoi;
	}

	public static Personaggio carica(){
		try{
			File file=new File("save/actual.login");
			Scanner s=new Scanner(file);
			String nome=s.next();
			file=new File("save/"+nome);
			s=new Scanner(file);
			return new Personaggio(s.next(),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),s.next(),s.next(),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()));
		}catch(IOException e){
			return null;
		}
	}

	public static Personaggio caricaAvv1(){
		try{
			File file=new File("save/avv.fight");
			Scanner s=new Scanner(file);
			String nome=s.next();
			file=new File("save/"+nome);
			s=new Scanner(file);
			return new Personaggio(s.next(),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),s.next(),s.next(),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()));
		}catch(IOException e){
			return null;
		}
	}

	public static Personaggio caricaAvv2(){
		try{
			File file=new File("save/avv.fight");
			Scanner s=new Scanner(file);
			return new Personaggio(s.next(),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),s.next(),s.next(),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()));
		}catch(IOException e){
			return null;
		}
	}

	//Metodi di accesso alle variabili
	public String getNome(){
		return nome;
	}
	public String getPass(){
		return pass;
	}
	public String getPack(){
		return pack;
	}
	public int getCampi(){
		return campi;
	}
	public int getCampini(){
		return campini;
	}
	public int getMet(){
		return met;
	}
	public int getCost(){
		return cost;
	}
	public String getM1(){
		return m1;
	}
	public String getM2(){
		return m2;
	}
	public String getM3(){
		return m3;
	}
	public String getM4(){
		return m4;
	}
	public int getD1(){
		return d1;
	}
	public int getD2(){
		return d2;
	}
	public int getD3(){
		return d3;
	}
	public int getD4(){
		return d4;
	}
	public int getInter(){
		return inter;
	}
	public int getEcce(){
		return ecce;
	}
	public int getSottocl(){
		return sottocl;
	}
	public int getGpoi(){
		return gpoi;
	}

	//metodi gestione interfacce("Money")
	
	public void addInter(int m){
		inter=inter+m;
	}
	public int addInter(){
		int lose=ran.nextInt(100)+100;
		inter=inter+lose;
		return lose;	
	}
	public int loseInter(){
		int lose=ran.nextInt(50)+50;
		inter=inter-lose;
		return lose;
	}
	public void loseInter(int m){
		inter=inter-m;
	}
	
	//metodi gestione eccezioni("esperienza")

	public int addEcce(){
		int gain=ran.nextInt(100)+50;
		ecce=ecce+gain;	
		int levcount = 500*sottocl;
		if(ecce>=levcount){
			sottocl++;
			gpoi++;
			Personaggio.aggiornaPer(Personaggio.carica());
		}
		return gain;
	}
	
	public void addLev(){
		ecce=ecce+500;	
		sottocl++;
	}
	
	public void loseGpoi(){
		gpoi=gpoi-1;
	}	

	public void setM1(String m){
		this.m1=m;
		this.d1=ran.nextInt(50);
	}
	
		public void setM1(String m,int i){
		this.m1=m;
		this.d1=i;
	}
	

	public void setM2(String m){
		this.m2=m;
		this.d2=ran.nextInt(50);
	}
	
	public void setM2(String m,int i){
		this.m2=m;
		this.d2=i;
	}
	
	public void addCampi(){
		campini=campini+20;
	}
	
	public void addMet(){
		met=met+2;
	}
	
	public void addCost(){
		cost=cost+2;
	}

	public void setM3(String m){
		this.m3=m;
		this.d3=ran.nextInt(50);
	}

	public void setM3(String m,int i){
		this.m3=m;
		this.d3=i;
	}
	
	public void setM4(String m){
		this.m4=m;
		this.d4=ran.nextInt(50);
	}
	
		public void setM4(String m,int i){
		this.m4=m;
		this.d4=i;
	}
	
	public void loseCampi(int m){
		campi=campi-m;
	}

	public void setCampi(int m){
		campi=m;
	}
	
	public void aggiorna(String n,String pa,String pac,int ca,int caini,int met,int cost,String m1,String m2,String m3,String m4,int d1,int d2,int d3,int d4,int inter,int ecce,int sottocl,int gpoi){
	try{
	File file =new File("save/"+n);
	PrintWriter p=new PrintWriter(file);
	p.println(n);
	p.println(pa);
	p.println(pac);
	p.println(ca);
	p.println(caini);
	p.println(met);
	p.println(cost);
	p.println(m1);
	p.println(m2);
	p.println(m3);
	p.println(m4);
	p.println(d1);
	p.println(d2);
	p.println(d3);
	p.println(d4);
	p.println(inter);
	p.println(ecce);
	p.println(sottocl);
	p.println(gpoi);
	p.flush();
	p.close();
		}catch(IOException err){
			System.out.println("impox");
		}
	}

	public void aggiornaAvve(String n,String pa,String pac,int ca,int caini,int met,int cost,String m1,String m2,String m3,String m4,int d1,int d2,int d3,int d4,int inter,int ecce,int sottocl,int gpoi){
	try{
	File file =new File("save/avv.fight");
	PrintWriter p=new PrintWriter(file);
	p.println(n);
	p.println(pa);
	p.println(pac);
	p.println(ca);
	p.println(caini);
	p.println(met);
	p.println(cost);
	p.println(m1);
	p.println(m2);
	p.println(m3);
	p.println(m4);
	p.println(d1);
	p.println(d2);
	p.println(d3);
	p.println(d4);
	p.println(inter);
	p.println(ecce);
	p.println(sottocl);
	p.println(gpoi);
	p.flush();
	p.close();
		}catch(IOException err){
			System.out.println("impox");
		}
	}

	public static void aggiornaAvv(Personaggio pe){
	try{
	File file =new File("save/avv.fight");
	PrintWriter p=new PrintWriter(file);
	p.println(pe.getNome());
	p.println(pe.getPass());
	p.println(pe.getPack());
	p.println(pe.getCampi());
	p.println(pe.getCampini());
	p.println(pe.getMet());
	p.println(pe.getCost());
	p.println(pe.getM1());
	p.println(pe.getM2());
	p.println(pe.getM3());
	p.println(pe.getM4());
	p.println(pe.getD1());
	p.println(pe.getD2());
	p.println(pe.getD3());
	p.println(pe.getD4());
	p.println(pe.getInter());
	p.println(pe.getEcce());
	p.println(pe.getSottocl());
	p.println(pe.getGpoi());
	p.flush();
	p.close();
		}catch(IOException err){
			System.out.println("impox");
		}
	}

	public static void aggiornaPer(Personaggio pe){
	try{
	File file =new File("save/"+pe.getNome());
	PrintWriter p=new PrintWriter(file);
	p.println(pe.getNome());
	p.println(pe.getPass());
	p.println(pe.getPack());
	p.println(pe.getCampi());
	p.println(pe.getCampini());
	p.println(pe.getMet());
	p.println(pe.getCost());
	p.println(pe.getM1());
	p.println(pe.getM2());
	p.println(pe.getM3());
	p.println(pe.getM4());
	p.println(pe.getD1());
	p.println(pe.getD2());
	p.println(pe.getD3());
	p.println(pe.getD4());
	p.println(pe.getInter());
	p.println(pe.getEcce());
	p.println(pe.getSottocl());
	p.println(pe.getGpoi());
	p.flush();
	p.close();
		}catch(IOException err){
			System.out.println("impox");
		}
	}
}

	

