import java.io.File;
import java.io.*;
public class Main{	
	public static void main(String[] a) throws Exception{
		class getDir{
			class CopyFiles{
				public CopyFiles(){
				try{ 
						InputStreamReader in=new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream("Bases/Easy"));
						BufferedReader b=new  BufferedReader(in);
						File f=new File("save/Easy");
						PrintWriter p=new PrintWriter(f);
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());				
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.flush();
						p.close();
						
						in=new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream("Bases/Medium"));
						b=new  BufferedReader(in);
						f=new File("save/Medium");
						p=new PrintWriter(f);
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());				
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.flush();
						p.close();				

						in=new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream("Bases/Hard"));
						b=new  BufferedReader(in);
						f=new File("save/Hard");
						p=new PrintWriter(f);
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());				
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.println(b.readLine());
						p.flush();
						p.close();	
					}catch(IOException e){
						System.out.println("non copiati");
					}
				}
			}
			private getDir(){
				File f=new File(".");
				String current=f.getAbsolutePath();
				f=new File(f+"/save");
				if (!f.exists()){
					f.mkdir();
					new CopyFiles();
					try{
						Runtime r=Runtime.getRuntime();
						String[] param={"/Windows/System32/attrib.exe","+H","save"};
						r.exec(param);
					}catch(IOException e){
						System.out.println("complimenti, era impossibile succedesse, ora l'hai rotto e so' cazzi tua!");
					}
				}
			}
		}
	new getDir();
	new Start();
	}
}
