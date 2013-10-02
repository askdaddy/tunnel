package kr.co.zungwon.tunnel.core;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
// TODO 참조한 코드 기재

public class Tunnel {

	// TODO 원본포트 지정
			public static final int srcPort = 1552;
			public static final int dstPort = 1521;
			
			public static final String dstHost = "172.16.100.76";
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		
		System.out.println("Tunneling start");
		// TODO 소케서버를 생성
		ServerSocket svrSOCK = new ServerSocket(srcPort);
		
		
		while(true){
			// TODO 클라이언트 소켓 생성
			Socket clientSocket = svrSOCK.accept();
		
			// TODO 클라이언트쓰레드 생성
			ClientThread clientThread = new ClientThread(clientSocket);
			
			// TODO 자식스레드 생성
			clientThread.start();
		}

	}

}
