package com.tbc.courses;

public enum Level {
	BASIC, INTERMEDIATE, ADVANCED;

	public String getIkey() {
		return "Level." + this.name();
	}
}
