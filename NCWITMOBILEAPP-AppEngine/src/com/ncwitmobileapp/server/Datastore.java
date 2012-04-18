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

public class Datastore {


  /**
   * Remove this object from the data store.
   */
  public void delete(String Username) {
    PersistenceManager pm = PMF.get().getPersistenceManager();
    try {
      Techicksmember item = pm.getObjectById(Techicksmember.class, Username);
      pm.deletePersistent(item);
    } finally {
      pm.close();
    }
  }

 
    @SuppressWarnings("unchecked")
    public Techicksmember find(String Username) {
      if (Username == null) {
        return null;
      }

      PersistenceManager pm = PMF.get().getPersistenceManager();
      try {
        Query query = pm.newQuery("select from " + Techicksmember.class.getName()
            + " where Username==" + Username.toString() + " && EmailAddress=='" + Techicksmember.getEmailAddress() + "'");
        List list = (List) query.execute();
        return (Techicksmember) (list.size() == 0 ? null : list.get(0));
      } catch (RuntimeException e) {
        System.out.println(e);
        throw e;
      } finally {
        pm.close();
      }
    }

@SuppressWarnings("unchecked")
public List findAll() {
  PersistenceManager pm = PMF.get().getPersistenceManager();
  try {
      Query query = pm.newQuery("select from " + Techicksmember.class.getName()
          + " where emailAddress=='" + Techicksmember.getEmailAddress() + "'");
      List list = (List) query.execute();
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
  public Techicksmember update(Techicksmember item) {
    //set the user id (not sure this is where we should be doing this)
    item.setName(item.getName());
    item.setEmailAddress(item.getEmailAddress());
    item.setBirthday(item.getBirthday());
    item.setNCWITmember(item.getNCWITmember());
    item.setPassword(item.getPassword());
    item.setReferralCode(item.getReferralCode());
    item.setSecurityAnswer(item.getSecurityAnswer());
    item.setSecurityQuestion(item.getSecurityQuestion());
  
    
    
    
    PersistenceManager pm = PMF.get().getPersistenceManager();
    try {
      pm.makePersistent(item);
      return item;
    } finally {
      pm.close();
    }
  }

  
}
