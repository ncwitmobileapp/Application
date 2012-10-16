package com.ncwitmobileapp.server;

import com.ncwitmobileapp.common.Level;

public class Award {
	private String year;
	private int level;
	
	public Award() {
		this.setLevel(Level.NOLEVEL);
	}
	
	public int getLevel() 
	{
		return(this.level);
	}
	
	public String getYear()
	{
		return(this.year);
	}
	
	public void setLevel(int level)
	{
		this.level =  (int) level;
	}

	public void setYear(String year)
	{
		this.year = year;
	}
}
