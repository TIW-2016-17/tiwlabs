/**
 * 
 */
package es.uc3m.tiw.lab6.config;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author David Palomar
 *
 */
@ApplicationPath("rest")
public class ApplicationConfig extends Application {

	public Set<Class<?>> getClasses() {
        return getRestClasses();
    }
    
	//Auto-generated from RESTful web service wizard
    private Set<Class<?>> getRestClasses() {
		Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
		
		resources.add(es.uc3m.tiw.lab6.rest.ServiceExample.class);
		return resources;    
    }
}
