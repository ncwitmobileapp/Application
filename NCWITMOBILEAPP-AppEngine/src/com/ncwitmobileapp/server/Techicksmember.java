
package com.ncwitmobileapp.server;


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
	
	private Boolean NCWITmember;
	private String Name;
	private String Password;
	private static String EmailAddress;
	private String ReferralCode;
	private int Birthday;
	private String SecurityQuestion;
	private String SecurityAnswer;//security answer is insensitive
	
	
	public Techicksmember()
	{
	
	}
	
	public Boolean getNCWITmember()
	{
		return NCWITmember;
	}
	
	public String getName()
	{
		return Name;
	}
	public String getUsername()
	{
		return EmailAddress;
		
	}
	public static  String getEmailAddress()
	{
		return EmailAddress;
	}
	public String getReferralCode()
	{
		return ReferralCode;
	}

	public int getBirthday()
	{
		return Birthday;
	}
	
	public String getPassword()
	{
		return Password;
	}
	
	public String getSecurityQuestion()
	{
		return SecurityQuestion;
	}
	public String getSecurityAnswer()
	{
		return SecurityAnswer;
	}
	

	//The following methods are for Registration  
	public void setNCWITmember(boolean NCWITmember)//Registration: should handled the setting of whether they are or not NCWIT Members
	{
		//Method to be handled by NCWIT data representative
		this.NCWITmember=NCWITmember;
		
	}
	
	public void setName(String Name)//passed parameters First and Last name concatenated
	{
		
		this.Name=Name;
	}
	public void setPassword(String Password)
	{
		this.Password=Password;
	}
	
	public void setEmailAddress(String EmailAddress)
	{
		this.EmailAddress=EmailAddress;
	}
	public void setReferralCode(String ReferralCode)
	{
		if (getNCWITmember()==true)
		{
			ReferralCode = VALID;//for registration if a referral code is valid, no need check.
		}
		this.ReferralCode=ReferralCode;
	}
	public void setBirthday(int Birthday) //format birthday as an integer of format MMDDYYYY
	{
		this.Birthday=Birthday;
		
	}
	public void setSecurityQuestion(String SecurityQuestion)
	{
		this.SecurityQuestion=SecurityQuestion;
	}
	public void setSecurityAnswer(String SecurityAnswer)
	{
		this.SecurityAnswer= SecurityAnswer.toLowerCase();
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
		builder.append(Name);
		builder.append(EmailAddress);
		return builder.toString();
		
		
	}
	
	
}
	 