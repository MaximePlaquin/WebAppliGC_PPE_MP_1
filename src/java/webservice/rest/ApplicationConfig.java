/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice.rest;


import java.util.Set;
import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;

/**
 *
 * @author Administrateur
 */
@ApplicationPath("rest")
public class ApplicationConfig extends Application {
    
    
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources){
        resources.add(service.ClientFacadeREST.class);
        resources.add(service.RegionFacadeREST.class);
        resources.add(webservice.rest.commande.WebServRestCommande.class);
        resources.add(webservice.rest.region.WebServRestRegion.class);
       
    }
}
