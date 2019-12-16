package net.madvirus.spring4.chap02.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import net.madvirus.spring4.chap02.search.SearchClientFactory;

/**
 * FactoryBean 인터페이스를 이용한 객체 생성 
 */
public class MainForSearch {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:config-search.xml");
		SearchClientFactory factory = ctx.getBean("searchClientFactory", SearchClientFactory.class);
		System.out.println(factory);
		SearchClientFactory factory2 = ctx.getBean("searchClientFactory", SearchClientFactory.class);
		System.out.println("same instance = " + (factory == factory2));
		ctx.close();
	}
}
