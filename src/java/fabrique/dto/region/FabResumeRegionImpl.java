/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrique.dto.region;

import bal.region.BalRegion;
import dao.region.DaoRegion;
import dto.region.ResumeRegion;
import entites.Region;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author Administrateur
 */
@Singleton
public class FabResumeRegionImpl implements FabResumeRegion{
    
    @Inject DaoRegion dao;
    @Inject BalRegion bal;
    
     
    
    @Override
      public ResumeRegion creerResumeRegion(Region pRegion){
    
      ResumeRegion rr=new ResumeRegion();
      
      rr.setCodeReg(pRegion.getCodeRegion());
      rr.setNomReg(pRegion.getNomRegion());
      

      rr.setCaAnnuel(bal.caAnneeEnCours(pRegion));
      rr.setNbclient(bal.nbClient(pRegion));
     
      
      return rr;
    } 
    

    @Override
     public ResumeRegion creerResumeRegion(String codeReg){
     return creerResumeRegion(dao.getLaRegion(codeReg));
    }
     
       @Override
    public List<ResumeRegion> getToutLesResumesRegions(List<Region> desRegions){
    
     List<ResumeRegion> lc=new LinkedList<ResumeRegion>();
     
     for (Region r: desRegions ){ lc.add(creerResumeRegion(r));}
     
     return lc;
   }
     
     

         
         
     }
     
   

       
       
       
    
    
    
    

  
    
    

