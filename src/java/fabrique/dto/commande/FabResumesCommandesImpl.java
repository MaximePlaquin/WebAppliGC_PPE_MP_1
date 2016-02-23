package fabrique.dto.commande;

import bal.commande.BalCommande;
import dao.client.DaoClient;
import dao.commande.DaoCommande;
import dto.commande.ResumeCommande;
import entites.Client;
import entites.Commande;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author rsmon
 */

@Singleton
public class FabResumesCommandesImpl implements FabResumesCommandes {
   
   @Inject  DaoCommande daoCommande; 
   @Inject  BalCommande balCommande;
   @Inject DaoClient daoClient;              
   
   
   @Override
    public ResumeCommande creerResumeCommande(Commande commande){
    
     ResumeCommande rc= new ResumeCommande();
     
     rc.setNumcom(commande.getNumCom()); 
     rc.setDatecom(commande.getDateCom());
     rc.setNumcli(commande.getLeClient().getNumCli());
     rc.setNomcli(commande.getLeClient().getNomCli());
     rc.setAdrcli(commande.getLeClient().getAdrCli());
     rc.setCoderegion(commande.getLeClient().getLaRegion().getCodeRegion());
     rc.setNomregion(commande.getLeClient().getLaRegion().getNomRegion());
     rc.setEtatcom(commande.getEtatCom());
     
     rc.setMontantHT(balCommande.montantCommandeHT(commande));
     rc.setMontantTTC(balCommande.montantCommandeTTC(commande));
    
     return rc;
    
    }
   
   
   @Override
   public ResumeCommande creerResumeCommande(Long numcom){
  
     return creerResumeCommande(daoCommande.getCommande(numcom));
   }
 
    
   @Override
   public List<ResumeCommande>  getResumesCommandeClient(Client client) {
       
        return getResumesCommande(daoCommande.getLesCommandesduClient(client));
   }
   
   @Override
   public List<ResumeCommande> getResumesCommandeClient (Long pclient){
       return getResumesCommandeClient(daoClient.getLeClient(pclient));
   }
    
   @Override
   public List<ResumeCommande>  getResumesCommandeClient(Client client, int pAnnee) {
       
        return getResumesCommande(daoCommande.getLesCommandesduClient(client, pAnnee));
   }

   @Override
   public List<ResumeCommande>  getResumesCommandeClient(Client client, int pAnnee, int pMois) {
        
        return getResumesCommande(daoCommande.getLesCommandesduClient(client, pAnnee,pMois));     
   }

   @Override
   public List<ResumeCommande> getResumesCommande(List<Commande> desCommandes){
    
     List<ResumeCommande> lc=new LinkedList<ResumeCommande>();
     
     for (Commande c: desCommandes ){ lc.add(creerResumeCommande(c));}
     
     return lc;
   }    
}
