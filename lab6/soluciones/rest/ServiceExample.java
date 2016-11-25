/**
 * 
 */
package es.uc3m.tiw.lab6.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import es.uc3m.tiw.lab1.domains.User;

/**
 * @author David Palomar
 *
 */
@Path("example")
public class ServiceExample {
	/**
	 * The access url will be:
	 * For getText() -- http://localhost:8080/laboratories/rest/example/test 
	 * For getDatos() -- http://localhost:8080/laboratories/rest/example/test/23/john 

	 */
	    
	    @Context
	    private UriInfo context;

	    /**
		 * Default constructor 
		 */
		public ServiceExample() {
			// TODO Auto-generated constructor stub
		}

	    /**
	     * URL invoked by GET : http://localhost:8080/laboratories/rest/example/test
	     * and return "Everything OK"
	     * @return Everything OK
	     */
	    @GET
	    @Path("test")
	    @Produces(MediaType.TEXT_PLAIN)
	    public String getText() {
	        return "Everything OK";
	    }
	    /**       
       * Example in which data is passed by GET and {@link PathParam}.
       * The first parameter is automatically converted to Integer
       * dispite of always coming in String format through HTTP.
	     * The URL will be: http://localhost:8080/laboratories/rest/example/test/10/hi
	     * @param number
	     * @param word
	     * @return  Message with the entered data
	     */
	    @GET
	    @Path("test/{number}/{word}")
	    @Produces(MediaType.TEXT_PLAIN)
	    public String getDatos(@PathParam("number")Integer number,@PathParam("word")String word) {
	        
	        return "The data entered are: number="+number+" word= "+word;
	    }
	    /**
	     * Example of using QUERY-STRING.
	     * The URL will be: http://localhost:8080/laboratories/rest/example/test/query?number=10&word=hi
	     * @param number
	     * @param word
	     * @return Message with the entered data
	     */
	    @GET
	    @Path("test/query")
	    @Produces(MediaType.TEXT_PLAIN)
	    public String getDataByQueryString(@QueryParam(value="number") Integer number,@QueryParam(value = "word") String word){
	    	 return "The data introduced by query-string are: number="+number+" word= "+word;
	    }
	    
	    /**
      
       * Example in which POST accesses and consumes plaintext but returns an object {@link User}
       * Which is converted to XML
	     * The URL is: http://localhost:8080/laboratories/rest/example/user/10/john/xml
	     * @param age
	     * @param name
	     * @return XML document from user 
	     */
	    @POST
	    @Path("user/{age}/{name}/xml")
	    @Consumes(MediaType.TEXT_PLAIN)
	    @Produces(MediaType.TEXT_XML)
	    public User getXML(@PathParam("age")Integer age,@PathParam("name") String name){
	    	return new User(age,name);
	    }
	    /**
       * Example that is accessed by POST through a form but is returned an object {@link User}
       * Which is converted to JSON
	     * The URL is: http://localhost:8080/laboratories/rest/example/user/10/john/json
	     * @param age
	     * @param name
	     * @return JSON document from user
	     */
	    @POST
	    @Path("user/{age}/{name}/json")
	    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	    @Produces(MediaType.APPLICATION_JSON)
	    public User getJSON(@PathParam("age")Integer age,@PathParam("name") String name){
	    	return new User(age,name);
	    }

}
