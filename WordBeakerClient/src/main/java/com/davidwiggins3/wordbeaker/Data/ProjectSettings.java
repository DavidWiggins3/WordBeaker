package com.davidwiggins3.wordbeaker.Data;

public abstract class ProjectSettings {

	private String projectTitle;
	private String projectPath;
	private String projectFileName;

	public ProjectSettings(String projectTitle, String projectPath, String projectFileName) throws IllegalArgumentException {
		super();
		this.projectTitle = projectTitle;
		this.projectPath = projectPath;
		this.projectFileName = projectFileName;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectPath() {
		return projectPath;
	}

	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}

	public String getProjectFileName() {
		return projectFileName;
	}

	public abstract void setProjectFileName(String projectFileName) throws IllegalArgumentException;

}
