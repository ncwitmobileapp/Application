package com.ncwitmobileapp.server;

import java.util.List;
import com.ncwitmobileapp.server.TechicksmemberService;
import com.ncwitmobileapp.annotation.ServiceMethod;


public class NCWITMOBILEAPPService {

	@ServiceMethod
	public Techicksmember createTechicksmember() {
		return TechicksmemberService.createTechicksmember();
		
	}

	@ServiceMethod
	public Techicksmember readTechicksmember(String user) {
		return TechicksmemberService.readTechicksmember(user);
		
	}

	@ServiceMethod
	public Techicksmember updateTechicksmember(Techicksmember techicksmember) {
		return TechicksmemberService.updateTechicksmeber(techicksmember);
		
	}

	@ServiceMethod
	public void deleteTechicksmember(String user) {
		TechicksmemberService.deleteTechicksmember(user);

	}

	@ServiceMethod
	public List<Techicksmember> queryTechicksmembers() {
		return TechicksmemberService.queryTechicksmembers();
	}

}
