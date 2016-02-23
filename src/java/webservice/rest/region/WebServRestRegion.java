/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice.rest.region;

import dao.region.DaoRegion;
import dto.region.ResumeRegion;
import entites.Region;
import fabrique.dto.region.FabResumeRegion;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("region")

public class WebServRestRegion {
    
    @Inject FabResumeRegion fab;
    @Inject ResumeRegion dto;
    @Inject DaoRegion dao;
    
    
    
     @GET
    @Path("numero/{codeReg}")
    @Produces({"application/xml","application/json"})
     
     
    public ResumeRegion CodeRegion (@PathParam("codeReg")String codeReg) {
         
            ResumeRegion rr = fab.creerResumeRegion(codeReg);
       return rr;
    }


  @GET
    @Path("toutes")
    @Produces({"application/xml","application/json"})
       public List<ResumeRegion> getLesResumesRegions(){
    
     List<Region> lesRegions=dao.getToutesLesRegions();
    
     
     for(Region r : lesRegions ){
         
        fab.creerResumeRegion(r);
     }
     
         List<ResumeRegion> lesResumesRegions=fab.getToutLesResumesRegions(lesRegions);
     return lesResumesRegions;

}

}