package kr.co.zungwon.tunnel.core;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
// TODO ������ �ڵ� ����

public class Tunnel {

	// TODO ������Ʈ ����
			public static final int srcPort = 1552;
			public static final int dstPort = 1521;
			
			public static final String dstHost = "172.16.100.76";
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		
		System.out.println("Tunneling start");
		// TODO ���ɼ����� ����
		ServerSocket svrSOCK = new ServerSocket(srcPort);
		
		
		while(true){
			// TODO Ŭ���̾�Ʈ ���� ����
			Socket clientSocket = svrSOCK.accept();
		
			// TODO Ŭ���̾�Ʈ������ ����
			ClientThread clientThread = new ClientThread(clientSocket);
			
			// TODO �ڽĽ����� ����
			clientThread.start();
		}

	}

}
