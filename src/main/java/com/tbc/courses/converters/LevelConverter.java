package com.tbc.courses.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import com.tbc.courses.Level;

@FacesConverter(forClass=Level.class)
public class LevelConverter implements javax.faces.convert.Converter{
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Level level = Level.valueOf(arg2);
		return level;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return arg2.toString();
	}
	
}
