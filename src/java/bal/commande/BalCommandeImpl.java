package bal.commande;


import bal.lignedecommande.BalLigneDeCommande;
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
    @Inject BalLigneDeCommande balLGDC;
    
    @Override
    public Float montantCommandeHT(Commande pCommande) {
        
        Float montant=0F;
        
        if(pCommande!=null){
          for(LigneDeCommande lgdc: pCommande.getLesLignesDeCommande()){
              
              montant += balLGDC.mntHTlgdc(lgdc);
          }
        }
        else montant=null;
        
        return montant;
    } 
    
    @Override
    public Float montantCommandeTTC(Commande pCommande) {
         
        Float r = 0F;
        
        for (LigneDeCommande lgdc : pCommande.getLesLignesDeCommande()){
            
            r += balLGDC.mntTTClgdc(lgdc);
               
        }
        
        return r;
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


