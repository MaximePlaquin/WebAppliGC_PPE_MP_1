package bal.commande;


import bal.tranchetarifaire.BalTrancheTarifaire;
import dao.tva.DaoTva;
import dto.commande.ResumeCommande;
import entites.Commande;
import entites.LigneDeCommande;
import entites.Produit;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class BalCommandeImpl implements BalCommande,Serializable{
       
    @Inject DaoTva      daoTva;
    @Inject BalTrancheTarifaire balTT;
    
    @Override
    public Float montantCommandeHT(Commande pCommande) {
        
        Float montant=0F;
        
        if(pCommande!=null){
          for(LigneDeCommande lgdc: pCommande.getLesLignesDeCommande()){
              
           Produit p = lgdc.getLeProduit();
           Float qte = lgdc.getQteCom();
           Float Prixprod = balTT.prixProd(p, qte);
        
           montant+=qte*Prixprod;
          }
        }
        else montant=null;
        
        return montant;
    } 
    
    @Override
    public Float montantCommandeTTC(Commande pCommande) {
         
        return montantCommandeHT(pCommande)*(1+daoTva.getTauxTVA());
    }
  
    @Override
    public boolean estReglee(Commande pCommande) {
        return pCommande.getEtatCom().equalsIgnoreCase("R");
    }
    
    
//    @Override
//    public ResumeCommande        getResumeCommande(Commande c){
//    
//       return new ResumeCommande(
//                   
//                 c.getNumCom(),
//                 c.getDateCom(),
//                 c.getEtatCom(),
//                 montantCommandeHT(c),
//                 montantCommandeTTC(c)       
//             ) ;
//    }
}


