package com.ncwitmobileapp.shared;

import java.util.List;


import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;


@ServiceName(value = "com.ncwitmobileapp.server.NCWITMOBILEAPPService", locator = "com.ncwitmobileapp.server.NCWITMOBILEAPPServiceLocator")
@SuppressWarnings("requestfactory")
public interface NCWITMOBILEAPPRequest extends RequestContext {

	Request<TechicksmemberProxy> createTechicksmember();
	
	Request<String> getAuthenticatedTechicksmember(String name, String password);

	Request<TechicksmemberProxy> readTechicksmember(Long id);

	Request<TechicksmemberProxy> updateTechicksmember(
			TechicksmemberProxy techicksmember);

	Request<Void> deleteTechicksmember(TechicksmemberProxy techicksmember);

	Request<List<TechicksmemberProxy>> queryTechicksmembers();

}
