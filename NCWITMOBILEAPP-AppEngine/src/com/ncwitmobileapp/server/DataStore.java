package com.ncwitmobileapp.server;


import com.google.android.c2dm.server.PMF;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

import java.util.Calendar;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletContext;

public class DataStore {


  /**
   * Remove this object from the data store.
   */
  public void delete(Long id) {
    PersistenceManager pm = PMF.get().getPersistenceManager();
    try {
      Techicksmember item = pm.getObjectById(Techicksmember.class, id);
      pm.deletePersistent(item);
    } finally {
      pm.close();
    }
  }

 
    @SuppressWarnings("unchecked")
    public Techicksmember find(String userName) {
      if (userName == null) {
        return null;
      }

      PersistenceManager pm = PMF.get().getPersistenceManager();
      try {
    	  
    	  Query q = pm.newQuery(Techicksmember.class);
    	  q.setFilter("userName == userNameParam");
    	  q.declareParameters("String userNameParam");
	      List<Techicksmember> results = (List<Techicksmember>) q.execute(userName);
    	  return (Techicksmember) (results.isEmpty() ? null : results.get(0));      	
   	       
       } catch (RuntimeException e) {
        System.out.println(e);
        throw e;
      } finally {
        pm.close();
      }
    }

@SuppressWarnings("unchecked")
public List <Techicksmember> findAll() {
  PersistenceManager pm = PMF.get().getPersistenceManager();
  try {
      Query query = pm.newQuery("select from " + Techicksmember.class.getName());
      List<Techicksmember> list = (List<Techicksmember>)query.execute();
      if (list.size() == 0) {
          list.size();
        }

    return list;
  } catch (RuntimeException e) {
    System.out.println(e);
    throw e;
  } finally {
    pm.close();
  }
}

  /**
   * Persist this object in the datastore.
   */
  public Techicksmember updateTechicksmember(Techicksmember item) {
    //set the user id (not sure this is where we should be doing this)
    item.setUserName(item.getUserName());
    item.setEmailAddress(item.getEmailAddress());
    item.setBirthday(item.getBirthday());
    item.setNCWITmember(item.getNCWITmember());
    item.setUserPassword(item.getUserPassword());
    item.setReferralCode(item.getReferralCode());
    item.setSecurityAnswer(item.getSecurityAnswer());
    item.setSecurityQuestion(item.getSecurityQuestion());
    item.setfirstName(item.getfirstName());
    item.setlastName(item.getlastName());
    
    PersistenceManager pm = PMF.get().getPersistenceManager();
    try {
      pm.makePersistent(item);
      return item;
    } finally {
      pm.close();
    }
  }

  
}
