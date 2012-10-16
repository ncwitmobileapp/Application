package com.ncwitmobileapp.server;

import java.util.List;
import java.util.logging.Logger;

import org.mortbay.log.Log;

import com.ncwitmobileapp.annotation.ServiceMethod;


public class TechicksmemberService {
	
	private static DataStore db = new DataStore();
	
	private static final Logger log =
	        Logger.getLogger(DeviceInfo.class.getName());
	
	@ServiceMethod
	public static Techicksmember createTechicksmember(Techicksmember member) {
		log.info("CreateTechicksmember called");
		return db.updateTechicksmember(member);
	}

	@ServiceMethod
	public static Techicksmember getAuthenticatedTechicksmember(String userName, String password) {
		 log.info("Called authenticateTechicksmember - trying to return member");
		 log.info("userName = " + userName + " PassWord = " + password);
		// return ("Success");
		 
		DataStore db = new DataStore();
		Techicksmember member = db.find(userName);
		log.info("Returning from Database");
		
		if (member==null){
			log.info("No MAtch On Login");
			return member;
		}  else{
			    if (member.getUserPassword().equals(password)){
			    log.info("Valid user id entered");
		        } else {
			        log.info("password is invlaid");
			        member = null;
		   }
		}
			
		return member;
		
	}
	
	
	@ServiceMethod
	public Techicksmember readTechicksmember(String username) {
		DataStore db=new DataStore();
		return db.find(username);
	}

	@ServiceMethod
	public Techicksmember updateTechicksmember(Techicksmember techicksmember) {
		DataStore db=new DataStore();
		db.updateTechicksmember(techicksmember);
		return db.find(techicksmember.getUserName());
	}

	@ServiceMethod
	public void deleteTechicksmember(Techicksmember techicksmember) {
		DataStore db=new DataStore();
		db.delete(techicksmember.getId());

	}

	@ServiceMethod
	public List<Techicksmember> queryTechicksmembers() {
		DataStore db=new DataStore();
		return db.findAll();
	}
}
