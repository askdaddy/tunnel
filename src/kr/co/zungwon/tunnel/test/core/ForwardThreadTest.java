package kr.co.zungwon.tunnel.test.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

import kr.co.zungwon.tunnel.core.ClientThread;
import kr.co.zungwon.tunnel.core.ForwardThread;
public class ForwardThreadTest {
	public static final int srcPort = 1552;
	
	@Test
	public void ForwardThreadCreate()throws Exception {
		
		//ServerSocket svrSOCK = new ServerSocket(srcPort);
		// TODO Ŭ���̾�Ʈ ���� ����
		Socket clientSocket = (new Socket());
				
	    // TODO Ŭ���̾�Ʈ������ ����
		ClientThread clientThread = new ClientThread(clientSocket);
		InputStream clientIn, serverIn;
		OutputStream clientOut, serverOut;
		clientIn = new InputStream(){
			
			@Override
			public int read() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		serverOut = new OutputStream() {
			
			@Override
			public void write(int b) throws IOException {
				// TODO Auto-generated method stub
				
			}
		};
		
		ForwardThread forwardThradTest = new ForwardThread(clientThread, clientIn, serverOut);
		if(forwardThradTest == null){
			throw new Exception("���λ��� ����");
		}
		
		//svrSOCK.close();
	}

}
