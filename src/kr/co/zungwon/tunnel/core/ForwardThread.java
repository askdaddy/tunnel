package kr.co.zungwon.tunnel.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.lang.Thread;
/**  
 * ForwardThread�� �Է½�Ʈ���� ��½�Ʈ�� ���̿� TCP �������� ����Ѵ�.
 * �Էµ� ��Ʈ���� �а� �ƿ�ǲ ��Ʈ������ ��� �������Ѵ�.
 * �������� �����ϸ�, �������� �ߴ��ϰ�, �θ𿡰� �� ������ ��� �ݱ⸦ ���� �˸���. 
 */ 

public class ForwardThread extends Thread {
	//��Ʈ���� ���۸� ��� ����� ���������� ���� ���۸� ������ ������
	private static final int BUFFER_SIZE = 8192; 
	
	InputStream mInputStream; 
    OutputStream mOutputStream; 
    ClientThread mParent; 
	/** 
     * Creates a new traffic redirection thread specifying 
     * its parent, input stream and output stream. 
     * �θ� ������� ���� ����� ��Ʈ���� ���� ���ο� �����̷����� �����.
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
                    break; // End of stream is reached --> exit  ��Ʈ���� ���� ����
              
                mOutputStream.write(buffer, 0, bytesRead);
                mOutputStream.flush(); 
                
            } 
        } catch (IOException e) { 
            // Read/write failed --> connection is broken 
        	// ����/�б� ���� --> ���� ����
        	mParent.connectionBroken(); 
        } 
 
        // Notify parent thread that the connection is broken 
        // �θ𽺷��忡�� ���� ���� ����
        mParent.connectionBroken(); 
    } 
		
}



