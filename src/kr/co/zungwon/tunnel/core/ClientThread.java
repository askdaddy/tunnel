package kr.co.zungwon.tunnel.core;

import java.net.Socket;

/** 
 * ClientThread는 클라이언트와 서버 사이에 포워딩을 시작하기 위한 작용을 담당한다.
 * 포둬딩하는 도중에 입출력 에러를 닫는 서버와 클라이언트 모두 추척을 유지한다.
 * 포워딩은 양방향 다 동작하고 2개의 ForwardThread instances가 수행한다.
 */ 
public class ClientThread extends Thread{

	public ClientThread(Socket clientSocket) {
		// TODO Auto-generated constructor stub
	}

}
