
package com.ncwitmobileapp.server;

import java.util.List;
import java.util.logging.Logger;

import com.ncwitmobileapp.annotation.ServiceMethod;




public class NCWITMOBILEAPPService {
	
	 private static final Logger log = Logger.getLogger(NCWITMOBILEAPPService.class.getName());

	  public NCWITMOBILEAPPService() {
	  }

	@ServiceMethod
	public Techicksmember createTechicksmember() {
		// TODO Auto-generated method stub
		return null;
	}

	@ServiceMethod
	public static String getAuthenticatedTechicksmember(String userName, String password) {
		 log.info("Called authenticateTechicksmember");
		 log.info("userName = " + userName + " PassWord = " + password);
		// return ("Success");
		 
		DataStore db = new DataStore();
		Techicksmember member = db.find(userName);
		log.info("Returning from Database");
		if (member==null){
			log.info("No MAtch On Login");
			return "Member not existant";
		}
		if (member.getUserPassword().equals(password)){
			log.info("Valid user id entered");
			return "Identity validated!";
		}
		
		return "Identity Invalidated";
		
	}
	
	
	
	@ServiceMethod
	public Techicksmember readTechicksmember(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@ServiceMethod
	public Techicksmember updateTechicksmember(Techicksmember techicksmember) {
		// TODO Auto-generated method stub
		return null;
	}

	@ServiceMethod
	public void deleteTechicksmember(Techicksmember techicksmember) {
		// TODO Auto-generated method stub

	}

	@ServiceMethod
	public List<Techicksmember> queryTechicksmembers() {
		// TODO Auto-generated method stub
		return null;
	}

}
