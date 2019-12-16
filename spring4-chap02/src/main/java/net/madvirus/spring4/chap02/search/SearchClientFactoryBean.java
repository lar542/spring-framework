package net.madvirus.spring4.chap02.search;

import org.springframework.beans.factory.FactoryBean;

public class SearchClientFactoryBean implements FactoryBean<SearchClientFactory> {

	private String server;
	private int port;
	private String contentType;
	private String encoding = "utf8";

	private SearchClientFactory searchClientFactory;

	public void setServer(String server) {
		this.server = server;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/**
	 * 이 메서드가 리턴하는 객체를 실제 빈 객체로 사용
	 */
	public SearchClientFactory getObject() throws Exception {
		if (this.searchClientFactory != null)
			return this.searchClientFactory;
		
		SearchClientFactoryBuilder builder = new SearchClientFactoryBuilder();
		builder.server(server)
				.port(port)
				.contentType(contentType == null ? "json" : contentType)
				.encoding(encoding);
		SearchClientFactory searchClientFactory = builder.build();
		searchClientFactory.init();
		this.searchClientFactory = searchClientFactory;
		return this.searchClientFactory;
	}

	public Class<?> getObjectType() {
		return SearchClientFactory.class;
	}

	public boolean isSingleton() {
		return true;
	}

}
