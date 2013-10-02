package kr.co.zungwon.tunnel.test.core;

import org.junit.Test;

import kr.co.zungwon.tunnel.core.Tunnel;

public class TunnelTest {
	
	@Test
	public void tunnelTest() throws Exception {
		Tunnel tunnelTest = new Tunnel();
		if( tunnelTest == null ){
			throw new Exception("투널생성 실패");
		}
	}
	
}
