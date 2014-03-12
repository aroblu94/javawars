import java.io.*;
import java.util.*;
public class ShopItem{
	ArrayList<String> nomeattacco;
	ArrayList<Integer> danno;
	ArrayList<Integer> prezzo;
	File file;
	Scanner doc;
	Scanner tokenizer;
	String s;
	Random ran;
	String nat;
	int dan,pre;
	
	public ShopItem()throws IOException{
		nomeattacco=new ArrayList<String>();
		danno=new ArrayList<Integer>();
		prezzo=new ArrayList<Integer>();
		ran=new Random();
		InputStreamReader in=new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream("shop/shop.txt"));
		BufferedReader b=new  BufferedReader(in);
		s="";
		for(int i=0; i<12;i++){
			s=b.readLine();
			StringTokenizer t=new StringTokenizer(s,".");
			nomeattacco.add(t.nextToken());
			danno.add(Integer.parseInt(t.nextToken()));
			prezzo.add(Integer.parseInt(t.nextToken()));
		}
	}

	public void getAcquisto(){
		int n=ran.nextInt(nomeattacco.size()-1);
		nat=nomeattacco.get(n);
		dan=(int)danno.get(n);
		pre=(int)prezzo.get(n);
	}
	
	public String getNome(){
		return nat;
	}

	public int getDanno(){
		return dan;
	}
	
	public int getPrezzo(){
		return pre;
	}	
}
			
				
			
