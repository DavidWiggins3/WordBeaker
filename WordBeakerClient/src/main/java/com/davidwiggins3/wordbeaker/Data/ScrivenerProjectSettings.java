package com.davidwiggins3.wordbeaker.Data;

public class ScrivenerProjectSettings extends ProjectSettings {

	private boolean onlyFilesMarkedWithIncludeInCompile = true;
	
	public ScrivenerProjectSettings(String projectTitle, String projectPath, String projectFileName, boolean onlyFilesMarkedWithIncludeInCompile) throws IllegalArgumentException {
		super(projectTitle, projectPath, projectFileName);
		if (!projectFileName.endsWith(".scrivx")) {
			throw new IllegalArgumentException();
		}
		setOnlyFilesMarkedWithIncludeInCompile(onlyFilesMarkedWithIncludeInCompile);
	}

	@Override
	public void setProjectFileName(String projectFileName) throws IllegalArgumentException {
		if (!projectFileName.endsWith(".scrivx")) {
			throw new IllegalArgumentException();
		}
	}

	public boolean isOnlyFilesMarkedWithIncludeInCompile() {
		return onlyFilesMarkedWithIncludeInCompile;
	}

	public void setOnlyFilesMarkedWithIncludeInCompile(boolean onlyFilesMarkedWithIncludeInCompile) {
		this.onlyFilesMarkedWithIncludeInCompile = onlyFilesMarkedWithIncludeInCompile;
	}

}
