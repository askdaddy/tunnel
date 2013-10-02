package kr.co.zungwon.tunnel.test.core;

import org.junit.Test;
import kr.co.zungwon.tunnel.core.ForwardThread;
public class ForwardThreadTest {
	
	@Test
	public void ForwardThreadCreate()throws Exception {
		ForwardThread forwardThradTest = new ForwardThread();
		if(forwardThradTest == null){
			throw new Exception("투널생성 실패");
		}
	}

}
