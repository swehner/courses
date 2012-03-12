package com.tbc.courses;

import java.io.Serializable;

public class ListCriteria implements Serializable{
	private static final long serialVersionUID = 1L;
	private boolean sortAsc;

	public boolean getSortAsc(){
		return sortAsc;
	}

	public void setSortAsc(boolean sortAsc) {
		this.sortAsc = sortAsc;
	}
	
	public void toggleSort(){
		this.sortAsc = !this.sortAsc;
	}
	
}
