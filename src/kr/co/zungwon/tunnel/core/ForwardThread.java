package kr.co.zungwon.tunnel.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.lang.Thread;
/**  
 * ForwardThread는 입력스트림과 출력스트림 사이에 TCP 포워딩을 담당한다.
 * 입력된 스트림을 읽고 아웃풋 스트림으로 모두 포워딩한다.
 * 스프림이 실패하면, 포워딩을 중단하고, 부모에게 그 소켓을 모두 닫기를 위해 알린다. 
 */ 

public class ForwardThread extends Thread {
	//스트림의 버퍼를 계산 현재는 고정이지만 차후 버퍼를 동적을 변경함
	private static final int BUFFER_SIZE = 8192; 
	
	InputStream mInputStream; 
    OutputStream mOutputStream; 
    ClientThread mParent; 
	/** 
     * Creates a new traffic redirection thread specifying 
     * its parent, input stream and output stream. 
     * 부모 스레드로 부터 입출력 스트림에 대한 새로운 리다이레션을 만든다.
     */ 
	public ForwardThread(ClientThread clientThread, InputStream clientIn,
			OutputStream serverOut) {
		// TODO Auto-generated constructor stub
		mParent = clientThread; 
        mInputStream = clientIn; 
        mOutputStream = serverOut; 
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		byte[] buffer = new byte[BUFFER_SIZE]; 
        try { 
            while (true) { 
                int bytesRead = mInputStream.read(buffer); 
                if (bytesRead == -1) 
                    break; // End of stream is reached --> exit  스트림의 끝에 도달
              
                mOutputStream.write(buffer, 0, bytesRead);
                mOutputStream.flush(); 
                
            } 
        } catch (IOException e) { 
            // Read/write failed --> connection is broken 
        	// 쓰기/읽기 실패 --> 연결 끊기
        	mParent.connectionBroken(); 
        } 
 
        // Notify parent thread that the connection is broken 
        // 부모스레드에게 연결 끊기 전달
        mParent.connectionBroken(); 
    } 
		
}



