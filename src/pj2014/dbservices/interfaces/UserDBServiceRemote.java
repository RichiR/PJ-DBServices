package pj2014.dbservices.interfaces;


import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;

import pj2014.patrepo.entities.User;

public interface UserDBServiceRemote {

  public abstract User createUser(User user);

  public abstract User updateUser(User us, String firstName, String lastName,
      String password);

  public abstract boolean deleteUser(int Userid);
  
  public abstract boolean deleteAllUsers();
  
  @Path("/checkUser/")
  @Consumes("application/json")
  public abstract boolean checkUser(String userInput);

}