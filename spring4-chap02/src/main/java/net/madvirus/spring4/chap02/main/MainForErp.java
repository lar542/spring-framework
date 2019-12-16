package net.madvirus.spring4.chap02.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import net.madvirus.spring4.chap02.erp.ErpClient;
import net.madvirus.spring4.chap02.erp.ErpClientFactory;

/**
 * 정적 메서드를 이용해서 객체를 생성하는 경우 
 */
public class MainForErp {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:config-erp.xml");
		ErpClientFactory factory = ctx.getBean("erpClientFactory", ErpClientFactory.class);
		ErpClient client = factory.create();
		client.connect();
		client.close();
		ctx.close();
	}
}
