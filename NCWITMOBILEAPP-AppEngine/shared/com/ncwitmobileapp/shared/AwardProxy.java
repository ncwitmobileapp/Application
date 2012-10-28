package com.ncwitmobileapp.shared;

import com.google.web.bindery.requestfactory.shared.ProxyForName;
import com.google.web.bindery.requestfactory.shared.ValueProxy;




@ProxyForName(value = "com.ncwitmobileapp.server.Award", locator = "com.ncwitmobileapp.server.AwardLocator")
public interface AwardProxy extends ValueProxy {
	
		
	int getLevel();	
		
	String getYear();		
		
	void setLevel(int level);

	void setYear(String year);
		
}