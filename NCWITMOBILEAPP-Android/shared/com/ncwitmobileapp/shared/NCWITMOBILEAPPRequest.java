package com.ncwitmobileapp.shared;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName(value = "com.ncwitmobileapp.server.NCWITMOBILEAPPService", locator = "com.ncwitmobileapp.server.NCWITMOBILEAPPServiceLocator")
public interface NCWITMOBILEAPPRequest extends RequestContext {

	Request <String> getAuthenticatedTechicksmember(String userName, String password);
	
}
