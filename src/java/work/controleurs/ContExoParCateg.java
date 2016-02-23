

package work.controleurs;

import bal.categorieproduit.BalCategorieProduit;
import dao.categorieproduit.DaoCategorieProduit;
import entites.CategorieProduit;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Maxime Plaquin
 */

@Named
@RequestScoped
public class ContExoParCateg implements Serializable{
   
 @Inject  
 private DaoCategorieProduit daoCategorieProduit;
 @Inject   
 private BalCategorieProduit balCategorieProduit;
    
 private PieChartModel camembert;
   
  @PostConstruct
  public void init(){
    
   camembert=new PieChartModel();
   
    for (CategorieProduit cp: daoCategorieProduit.getToutesLesCategories()){
       
        camembert.set(cp.getNomCateg(), balCategorieProduit.caCategorieProduit(cp));    
    }
  }

 
  
  //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
  
   public PieChartModel getCamembert() {
        return camembert;
    }
  //</editor-fold>
}
