package kr.co.zungwon.tunnel.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Filter {
	
	String name;
	
	public String openFileToString(byte[] _bytes)
	{
	    String file_string = "";

	    for(int i = 0; i < _bytes.length; i++)
	    {
	        file_string += (char)_bytes[i];
	    }

	    return file_string;    
	}
	
	
	public Filter(byte[] arg0, int arg1, int arg2) {
		try {
			
			FileOutputStream fop = null;
			File file;
		
			// creating UUID      
		    UUID uid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
			
			
			
			String filter = openFileToString(arg0);
			if(filter.contains("SELECT * FROM tab"))
			{
				file = new File("F:\\test\\DETECTOR"+uid.randomUUID()+".txt");
				fop = new FileOutputStream(file);
			}else 
			{
				file = new File("F:\\test\\filename"+uid.randomUUID()+".txt");
				fop = new FileOutputStream(file);
			}
			
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// if file doesnt exists, then create it
			if (!file.exists()) {
							file.createNewFile();
			}
			
			
			fop.write(arg0, arg1, arg2);
			fop.flush();
			fop.close();
 
			System.out.println("Done"+uid.randomUUID());


		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public Filter(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	

}
