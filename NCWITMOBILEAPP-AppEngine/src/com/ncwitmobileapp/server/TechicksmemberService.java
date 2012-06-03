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
	public static Techicksmember readTechicksmember(Long id) {
		return null;
	}

	@ServiceMethod
	public static Techicksmember updateTechicksmember(Techicksmember techicksmember) {
		return null;
	}

	@ServiceMethod
	public static void deleteTechicksmember(Techicksmember member) {
		db.delete(member.getId());
		return ;

	}

	@ServiceMethod
	public static  List<Techicksmember> queryTechicksmembers() {
		log.info("Calling findAll");
		return db.findAll();
	}

}
