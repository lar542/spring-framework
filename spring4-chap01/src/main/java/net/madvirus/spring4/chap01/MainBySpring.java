package net.madvirus.spring4.chap01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * 스프링으로 객체 조립하기 : 스프링을 이용한 객체 생성 및 사용
 * 
 *  - 작성한 XML 설정 파일로부터 스프링 컨테이너를 생성하고 필요한 객체를 컨테이너로부터 가져와 사용하자.
 *  - 스프링 컨테이너는 설정 정보로부터 스프링 빈 객체를 생성/조립/관리한다.
 */
public class MainBySpring {

	public static void main(String[] args) {
		//XML 설정 파일로부터 스프링 컨테이너 생성
		String configLocation = "classpath:applicationContext.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		//스프링 컨테이너로부터 빈 객체를 가져온다.
		Project project = ctx.getBean("sampleProject", Project.class);
		project.build();
		ctx.close();
	}
}
