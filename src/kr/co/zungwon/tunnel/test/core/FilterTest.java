package kr.co.zungwon.tunnel.test.core;

import org.junit.Test;
import kr.co.zungwon.tunnel.core.Filter;

public class FilterTest {
	
	@Test
	public void FilterTest() throws Exception {
		Filter filterTest = new Filter("string");
		
		if(filterTest == null) {
			throw new Exception("���ϻ����");
		}
		
	}

}
