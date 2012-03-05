package com.tbc.courses.gui;

import java.io.Serializable;

public class UserBean implements Serializable {
	private static final long serialVersionUID = -2281980728889477402L;
	// DI via Spring
	UserBo userBo;

	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}

	public String printMsgFromSpring() {

		return userBo.getMessage();

	}

}