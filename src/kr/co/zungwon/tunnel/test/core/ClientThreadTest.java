package kr.co.zungwon.tunnel.test.core;

import org.junit.Test;
import kr.co.zungwon.tunnel.core.ClientThread;
import java.net.*;

public class ClientThreadTest {
	
	@Test
	public void ClientTreadCreate() throws Exception {
		Socket clientSocket = null;
		ClientThread clientTreadTest = new ClientThread(clientSocket);
		if(clientTreadTest == null) {
			throw new Exception("Ŭ���̾�Ʈ  ����");
		}
		
	}

}
