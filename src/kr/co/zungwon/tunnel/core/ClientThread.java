package kr.co.zungwon.tunnel.core;

import java.net.Socket;

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
	}
	
	/**
	 * ������ ������ ������ �����ϰ� Ŭ���̾�Ʈ�� �������� ����� �������� �����Ѵ�.
	 */
	public void run() {
		
	}
	
	/**
	 * ������ ������ Ŭ���̾�Ʈ ������� ������ Ŭ���̾�Ʈ ��� ������ �����Ų��.
	 * Ŭ���̾�Ʈ ������ �ݰ�, ���� ������ ��� �����忡�� ���� �۾��� �Ϸ�ɶ��� ��ٸ����Ѵ�.
	 * 
	 */
	public synchronized void connectionBroken() throws Exception {
		mServerSocket.close();
		mClientSocket.close();
		if(mForwardingActive) {
			mForwardingActive = false;
		}
	}

}
