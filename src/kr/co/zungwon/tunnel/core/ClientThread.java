package kr.co.zungwon.tunnel.core;

import java.net.Socket;

/** 
 * ClientThread는 클라이언트와 서버 사이에 포워딩을 시작하기 위한 작용을 담당한다.
 * 포워딩하는 도중에 입출력 에러가 발생하면  모든 소켓을 끊는 역할을 하고 서버와 클라이언트 모두 추척을 유지한다.
 * 포워딩은 양방향 다 동작하고 2개의 ForwardThread instances가 수행한다.
 */ 
public class ClientThread extends Thread{
	private Socket mClientSocket; //클라이언트 접속 속켓
	private Socket mServerSocket;
	
	private boolean mForwardingActive = false; //포워딩 활성상태 여부

	public ClientThread(Socket clientSocket) {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 목적지 서버에 연결을 수행하고 클라이언트와 서버간에 양방향 포워딩을 시작한다.
	 */
	public void run() {
		
	}
	
	/**
	 * 연결이 실패한 클라이언트 스레드는 서버와 클라이언트 모두 연결을 종료시킨다.
	 * 클라이언트 소켓을 닫고, 서버 소켓의 모든 스레드에게 끊는 작업이 완료될때가 기다리게한다.
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
