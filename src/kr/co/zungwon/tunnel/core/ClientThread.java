package kr.co.zungwon.tunnel.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

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
		mClientSocket = clientSocket;
	}
	
	/**
	 * 목적지 서버에 연결을 수행하고 클라이언트와 서버간에 양방향 포워딩을 시작한다.
	 */
	public void run() {
		InputStream clientIn, serverIn;
		OutputStream clientOut, serverOut;
		
		try {
			 // Connect to the destination server 
			 // 목적지 서버에 연결
			mServerSocket = new Socket(Tunnel.dstHost, Tunnel.dstPort);
			// Turn on keep-alive for both the sockets 
			// 소켓두개 모두 keep-allive 상태로 설정한다.
			mClientSocket.setKeepAlive(true);
			mServerSocket.setKeepAlive(true);
			
			// Obtain client & server input & output streams 
			// 클라이언트와 서버의 입출력 스트림을 받는다.
			clientIn = mClientSocket.getInputStream();
			serverIn = mServerSocket.getInputStream(); 
			//필터링 클래스 주입
			//조건에 만족하지 않으면 에러를 던져 예외처리 시킴
			 clientOut = mClientSocket.getOutputStream(); 
			 serverOut = mServerSocket.getOutputStream();
		} 
		catch (IOException  e) {

			connectionBroken();			
            return; 
		}
		// Start forwarding data between server and client 
		// 서버와 클라이언트 사이에 데이타의 포워딩을 시작한다.
		mForwardingActive = true; 
		//+---> client In --> server Out ---+
	    ForwardThread clientForward = new ForwardThread(this, clientIn, serverOut);
	    //+<--- client Out <-- server In ---+
	    ForwardThread serverForward = new ForwardThread(this, serverIn, clientOut);
	    
		clientForward.start();
		serverForward.start(); 
		
	}
	
	/**
	 * 연결이 실패한 클라이언트 스레드는 서버와 클라이언트 모두 연결을 종료시킨다.
	 * 클라이언트 소켓을 닫고, 서버 소켓의 모든 스레드에게 끊는 작업이 완료될때가 기다리게한다.
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
