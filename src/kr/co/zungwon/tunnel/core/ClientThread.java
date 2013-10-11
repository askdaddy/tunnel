package kr.co.zungwon.tunnel.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/** 
 * ClientThread�� Ŭ���̾�Ʈ�� ���� ���̿� �������� �����ϱ� ���� �ۿ��� ����Ѵ�.
 * �������ϴ� ���߿� ����� ������ �߻��ϸ�  ��� ������ ���� ������ �ϰ� ������ Ŭ���̾�Ʈ ��� ��ô�� �����Ѵ�.
 * �������� ����� �� �����ϰ� 2���� ForwardThread instances�� �����Ѵ�.
 */ 
public class ClientThread extends Thread{
	private Socket mClientSocket; //Ŭ���̾�Ʈ ���� ����
	private Socket mServerSocket;
	
	private boolean mForwardingActive = false; //������ Ȱ������ ����

	public ClientThread(Socket clientSocket) {
		// TODO Auto-generated constructor stub
		mClientSocket = clientSocket;
	}
	
	/**
	 * ������ ������ ������ �����ϰ� Ŭ���̾�Ʈ�� �������� ����� �������� �����Ѵ�.
	 */
	public void run() {
		InputStream clientIn, serverIn;
		OutputStream clientOut, serverOut;
		
		try {
			 // Connect to the destination server 
			 // ������ ������ ����
			mServerSocket = new Socket(Tunnel.dstHost, Tunnel.dstPort);
			// Turn on keep-alive for both the sockets 
			// ���ϵΰ� ��� keep-allive ���·� �����Ѵ�.
			mClientSocket.setKeepAlive(true);
			mServerSocket.setKeepAlive(true);
			
			// Obtain client & server input & output streams 
			// Ŭ���̾�Ʈ�� ������ ����� ��Ʈ���� �޴´�.
			clientIn = mClientSocket.getInputStream();
			serverIn = mServerSocket.getInputStream(); 
			//���͸� Ŭ���� ����
			//���ǿ� �������� ������ ������ ���� ����ó�� ��Ŵ
			 clientOut = mClientSocket.getOutputStream(); 
			 serverOut = mServerSocket.getOutputStream();
		} 
		catch (IOException  e) {

			connectionBroken();			
            return; 
		}
		// Start forwarding data between server and client 
		// ������ Ŭ���̾�Ʈ ���̿� ����Ÿ�� �������� �����Ѵ�.
		mForwardingActive = true; 
		//+---> client In --> server Out ---+
	    ForwardThread clientForward = new ForwardThread(this, clientIn, serverOut);
	    //+<--- client Out <-- server In ---+
	    ForwardThread serverForward = new ForwardThread(this, serverIn, clientOut);
	    
		clientForward.start();
		serverForward.start(); 
		
	}
	
	/**
	 * ������ ������ Ŭ���̾�Ʈ ������� ������ Ŭ���̾�Ʈ ��� ������ �����Ų��.
	 * Ŭ���̾�Ʈ ������ �ݰ�, ���� ������ ��� �����忡�� ���� �۾��� �Ϸ�ɶ��� ��ٸ����Ѵ�.
	 * 
	 */
	public synchronized void connectionBroken(){
		try {
			mServerSocket.close();
			mClientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(mForwardingActive) {
			mForwardingActive = false;
		}
	}

}
