package kr.duru.socket;

import java.io.*;

public class BinaryFileCopier {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("BinaryFileCopier");
		
		String outputPath = "/Users/kangnaru/tunnel/tunnel/bin/kr/duru/socket/";
		FileInputStream inFile = new FileInputStream(outputPath+"input.txt");
		
		FileOutputStream outFile = new FileOutputStream(outputPath+"output.bin");
		
		byte buf[] = new byte[1024];
		
		while(true)
		{
			int bytesRead = inFile.read(buf);
			
			if(bytesRead == -1)
			{
				break;
			}
			outFile.write(buf, 0, bytesRead);
		}
		
		outFile.flush();
		outFile.close();
		inFile.close();
		
		System.out.println("Close BinaryFileCopier");
	}

}
