
package com.ncwitmobileapp.server;

import java.sql.Time;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//this class is an entity for the application, it holds all the information related to any Techick Member

@Entity
public class Techicksmember extends Object
{
	private static final String VALID = null;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String userName;
	private Boolean NCWITmember;
	private String userPassword;
	private String emailAddress;
	private String referralCode;
	private int    birthday;
	private String securityQuestion;
	private String securityAnswer;//security answer is insensitive
	private String firstName;
	private String lastName;
	private Time timestamp;
	private List<Award> awards;
	

	public Boolean getNCWITmember()
	{
		return NCWITmember;
	}
	
	public String getUserName()
	{
		return this.userName;
		
	}
	
	public Long getId()
	{
		return id;
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	public String getReferralCode()
	{
		return referralCode;
	}

	public int getBirthday()
	{
		return birthday;
	}
	
	public String getUserPassword()
	{
		return userPassword;
	}
	
	public String getSecurityQuestion()
	{
		return securityQuestion;
	}
	public String getSecurityAnswer()
	{
		return securityAnswer;
	}
	public String getfirstName()
	{
		return firstName;
	}
	
	public String getlastName()
	{
		return lastName;
	}
	public Time getTimestamp()
	{
		return timestamp;
	}
	public List<Award> getAwards()
	{
		return awards;
	}
	public Techicksmember()
	{
	
	}
	
	

	//The following methods are for Registration  
	public void setNCWITmember(boolean NCWITmember)//Registration: should handled the setting of whether they are or not NCWIT Members
	{
		//Method to be handled by NCWIT data representative
		this.NCWITmember=NCWITmember;
		
	}
	
	public void setUserName(String name)//passed parameters First and Last name concatenated
	{
			this.userName=name;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public void setUserPassword(String password)
	{
		this.userPassword=password;
	}
	
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress=emailAddress;
	}
	public void setfirstName(String firstName)
	{
		this.firstName=firstName;
	}
	public void setlastName(String lastName)
	{
		this.lastName=lastName;
	}
	
	public void setReferralCode(String referralCode)
	{
		if (getNCWITmember()==true)
		{
			referralCode = VALID;//for registration if a referral code is valid, no need check.
		}
		this.referralCode=referralCode;
	}
	public void setBirthday(int birthday) //format birthday as an integer of format MMDDYYYY
	{
		this.birthday=birthday;
		
	}
	public void setSecurityQuestion(String securityQuestion)
	{
		this.securityQuestion=securityQuestion;
	}
	public void setSecurityAnswer(String securityAnswer)
	{
		this.securityAnswer= securityAnswer.toLowerCase();
	}
	public void setTimestamp(Time timestamp)
	{
		this.timestamp=timestamp;
	}
	
	public List<Award> setAwards(Award award)
	{
		 awards.add(award);
		 return(awards);	
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		if(NCWITmember == true)
		{
			builder.append("NCWIT Member: ");
		}
		else
		{
			builder.append("Regular Member: ");
		}
		builder.append(userName);
		builder.append(emailAddress);
		return builder.toString();
		
		
	}
	
	
}
	 
