package com.ncwitmobileapp.server;

import java.util.List;
import java.util.logging.Logger;

import com.ncwitmobileapp.annotation.ServiceMethod;

public class NCWITMOBILEAPPService {
	
	 private static final Logger log = Logger.getLogger(NCWITMOBILEAPPService.class.getName());

	  public NCWITMOBILEAPPService() {
	  }

	@ServiceMethod
	public static String getAuthenticatedTechicksmember(String userName, String password) {
		 log.info("Called authenticateTechicksmember");
		 log.info("userName = " + userName + " password = " + password);
		 return ("Success");
	}
}
