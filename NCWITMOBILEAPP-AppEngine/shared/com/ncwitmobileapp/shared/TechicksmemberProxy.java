package com.ncwitmobileapp.shared;

import com.google.web.bindery.requestfactory.shared.ProxyForName;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyForName(value = "com.ncwitmobileapp.server.Techicksmember", locator = "com.ncwitmobileapp.server.TechicksmemberLocator")
public interface TechicksmemberProxy extends ValueProxy {

	Boolean getNCWITmember();

	String getUserName();

	Long getId();

	String getEmailAddress();

	String getReferralCode();

	int getBirthday();

	String getUserPassword();

	String getSecurityQuestion();

	String getSecurityAnswer();

	void setNCWITmember(boolean NCWITmember);

	void setUserName(String name);

	void setUserPassword(String password);

	void setEmailAddress(String emailAddress);

	void setReferralCode(String referralCode);

	void setBirthday(int birthday);

	void setSecurityQuestion(String securityQuestion);

	void setSecurityAnswer(String securityAnswer);

}
