package kr.co.zungwon.tunnel.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
	
	final protected  char[] hexArray = "0123456789ABCDEF".toCharArray();
	
	public  String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2]; //2배로 문자열의 길이를 늘림
	    
	    for ( int j = 0; j < bytes.length; j++ ) {
	    	
	        int v = bytes[j] & 0xFF; //논
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	public Filter(byte[] arg0, int arg1, int arg2) {
//		try {
			
//			FileOutputStream fop = null;
//			File file;
		
			// creating UUID      
		    UUID uid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
			
			
		    
			
			//String fileEncoding=System.getProperty("file.encoding");
	        //System.out.println("file.encoding = "+fileEncoding);
	        
	     

	        //String filter;
			System.out.println(bytesToHex(arg0) + " ");
		    
		
			
//			if(filter.contains("SELECT * FROM tab"))
//			{
//				file = new File("F:\\test\\DETECTOR"+uid.randomUUID()+".txt");
//				fop = new FileOutputStream(file);
//			}else 
//			{
//				file = new File("F:\\test\\filename"+uid.randomUUID()+".txt");
//				fop = new FileOutputStream(file);
//			}
//			
//			// if file doesnt exists, then create it
//			if (!file.exists()) {
//				file.createNewFile();
//			}
//			// if file doesnt exists, then create it
//			if (!file.exists()) {
//							file.createNewFile();
//			}
			
			
	//		fop.write(arg0, arg1, arg2);
		//	fop.flush();
		//	fop.close();
 
			//System.out.println("Done"+uid.randomUUID());

//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}


	public Filter(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	

}
