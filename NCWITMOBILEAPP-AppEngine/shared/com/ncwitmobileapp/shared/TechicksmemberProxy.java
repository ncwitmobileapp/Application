package com.ncwitmobileapp.shared;

import com.google.web.bindery.requestfactory.shared.ProxyForName;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyForName(value = "com.ncwitmobileapp.server.Techicksmember", locator = "com.ncwitmobileapp.server.TechicksmemberLocator")
public interface TechicksmemberProxy extends ValueProxy {

	Boolean getNCWITmember();

	String getName();

	String getUsername();

	String getEmailAddress();

	String getReferalCode();

	int getBirthday();

	String getPassword();

	String getSecurityQuestion();

	String getSecurityAnswer();

	void setNCWITmember(boolean NCWITmember);

	void setName(String Name);

	void setPassword(String Password);

	void setEmailAddress(String EmailAddress);

	void setReferralCode(String ReferralCode);

	void setBirthday(int Birthday);

	void setSecurityQuestion(String SecurityQuestion);

	void setSecurityAnswer(String SecurityAnswer);

}
