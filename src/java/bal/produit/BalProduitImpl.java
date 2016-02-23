
package bal.produit;
import bal.tranchetarifaire.BalTrancheTarifaire;
import dao.produit.DaoProduit;
import entites.Commande;
import entites.LigneDeCommande;
import entites.Produit;
import java.io.Serializable;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Singleton;
import static utilitaires.UtilDate.*;

@Singleton
public class BalProduitImpl  implements BalProduit, Serializable{
    
    @Inject DaoProduit  daoProduit;
    @Inject BalTrancheTarifaire balTT;
    
    @Override
    public Float caAnnuelProduit(Produit pProduit, int pAnnee) {
        
        Float ca=0F;
        
        for (LigneDeCommande lgdc: pProduit.getLesLignesDeCommande()){
        
          Commande cmd     = lgdc.getLaCommande();
          Date     dateCmd = cmd.getDateCom();
          String   etatCmd = cmd.getEtatCom();
          Float qte = lgdc.getQteCom();
          
          
          if( annee(dateCmd)==pAnnee && etatCmd.equalsIgnoreCase("R") ){
          
            ca+=balTT.prixProd(pProduit, qte)*qte;
          }
          
            
        }
        return ca;
    }
    
    @Override
    public Float caAnnuelProduit(Produit pProduit, int pAnnee, int pMois) {
         Float ca=0F;
        
        for (LigneDeCommande lgdc: pProduit.getLesLignesDeCommande()){
        
          Commande cmd     = lgdc.getLaCommande();
          Date     dateCmd = cmd.getDateCom();
          String   etatCmd = cmd.getEtatCom();
          Float qte = lgdc.getQteCom();
          
          if( dansAnneeEtMois(dateCmd, pAnnee, pMois) 
              &&  
              etatCmd.equalsIgnoreCase("R")
            )
          {
          
            ca+=balTT.prixProd(pProduit, qte)*qte;
          }
               
        }
        return ca;
    }
    

   
  
   
   
   
    
}
