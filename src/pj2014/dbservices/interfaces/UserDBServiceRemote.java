package pj2014.dbservices.interfaces;


import javax.ejb.Remote;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import pj2014.patrepo.entities.User;
@Remote
@Path("/UserDBService")
public interface UserDBServiceRemote {
	
  @POST
  @Path("/createUser")
  @Produces("application/json")
  @Consumes("application/json")
  public abstract User createUser(User user);
  
  @PUT
  @Path("/updateUser")
  @Produces("application/json")
  @Consumes("application/json")
  public abstract User updateUser(User us, String firstName, String lastName,
      String password);
  
  @DELETE
  @Path("/deleteUser")
  @Consumes("application/json")
  public abstract boolean deleteUser(int Userid);
  
  @DELETE
  @Path("/deleteAllUser")
  public abstract boolean deleteAllUsers();
  
  @Path("/checkUser")
  @Produces("application/json")
  public abstract User checkUser(@QueryParam("vorname")String firstName, @QueryParam("name")String lastName, @QueryParam("passwort")String password);

}