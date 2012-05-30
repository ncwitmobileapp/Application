package com.ncwitmobileapp.shared;

import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName("com.ncwitmobileapp.server.TechicksmemberService")

public interface TechicksmemberRequestFactory extends RequestFactory {

	TechicksmemberRequest techicksmemberRequest();

}
