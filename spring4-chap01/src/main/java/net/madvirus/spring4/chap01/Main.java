package net.madvirus.spring4.chap01;

import java.util.ArrayList;
import java.util.List;

/**
 * 스프링을 사용하지 않고 객체 조립/사용하기
 */
public class Main {

	public static void main(String[] args) {
		MavenBuildRunner buildRunner = new MavenBuildRunner();
		buildRunner.setMavenPath("E:\\B_Util\\6.maven\\apache-maven-3.6.3");
		
		Project sampleProject = new Project();
		List<String> srcDirs = new ArrayList<String>();
		srcDirs.add("src");
		srcDirs.add("srcResources");
		sampleProject.setSrcDirs(srcDirs);
		sampleProject.setBinDir("bin");
		sampleProject.setBuildRunner(buildRunner);
		
		sampleProject.build();
	}
}
