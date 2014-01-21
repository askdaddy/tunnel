package kr.co.zungwon.tunnel.core;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Tunnel {

			public static final int srcPort = 8888;
			public static final int dstPort = 3389;
			public static final String dstHost = "211.201.139.10";
			//public static final String dstHost = "movie.naver.com";
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		
		System.out.println("Tunneling start");
		ServerSocket svrSOCK = new ServerSocket(srcPort);
		
		//svrSOCK.close();
		while(true){
			Socket clientSocket = svrSOCK.accept();

			ClientThread clientThread = new ClientThread(clientSocket);

			clientThread.start();
		}
		
		

	}

}
