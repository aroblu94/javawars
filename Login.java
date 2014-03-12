
import java.awt.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.event.*;
public class Login{
	public static boolean authenticate(String user, String pass){
		String usernam="";
		String passwor="";
		try{
			File file=new File("save/"+user);
			Scanner input=new Scanner(file);
			usernam=input.next();
			passwor=input.next();
			

		}catch(IOException e){
			System.out.println("error");
		}
		if((user.equals(usernam)) && (pass.equals(passwor)))
			return true;
		else{
			return false;
		}
	}
}
