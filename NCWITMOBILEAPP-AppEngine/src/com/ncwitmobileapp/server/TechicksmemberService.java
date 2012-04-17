package com.ncwitmobileapp.server;
import java.util.List;

public class TechicksmemberService 
{
	
	static Datastore db = new Datastore();
	public static Techicksmember createTechicksmember() 
	{
		return db.update(new Techicksmember());      
	
	}
	
	public static Techicksmember readTechicksmember(String user)
	{
		return db.find(user);
	}
	
	public static Techicksmember updateTechicksmeber(Techicksmember member){
		return db.update(member);
	}
	
	public static void deleteTechicksmember(String user){
		db.delete(user);
	}
	
	public static List<Techicksmember> queryTechicksmembers() {
		return db.findAll();
	}
}
