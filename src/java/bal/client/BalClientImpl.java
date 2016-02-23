package bal.client;
import bal.commande.BalCommande;
import dao.commande.DaoCommande;
import dto.commande.ResumeCommande;
import entites.Client;
import entites.Commande;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import static utilitaires.UtilDate.anneeCourante;

@Singleton 

public class BalClientImpl  implements BalClient,Serializable{
    
    @Inject BalCommande  balCommande;
    @Inject DaoCommande  daoCommande;
    
    @Override
    public Float                 caAnnuel(Client pClient, int pAnnee) {
        
        Float ca=0f;
        for (Commande cmd : daoCommande.getLesCommandesduClient(pClient, pAnnee)){
           
               if(cmd.getEtatCom().equals("R")) ca+=balCommande.montantCommandeHT(cmd); 
        }
        return ca;
    }
    
    @Override
    public Float caAnneeEnCours(Client pClient) {
        return caAnnuel(pClient,anneeCourante());
    }

    @Override
    public Float                 caMensuel(Client pClient, int pAnnee, int pMois) {
       
        Float ca=0f;
        for (Commande cmd : daoCommande.getLesCommandesduClient(pClient, pAnnee, pMois)){
            
              if(cmd.getEtatCom().equals("R")) ca+=balCommande.montantCommandeHT(cmd);
        }
        return ca;
    } 
    
//    @Override
//    public List<ResumeCommande>  getResumesCommandeClient(Client client) {
//       
//        return getResumesCommande(daoCommande.getLesCommandesduClient(client));
//    }  
    
//    private List<ResumeCommande> getResumesCommande(List<Commande> desCommandes){
//    
//     List<ResumeCommande> lc=new LinkedList<ResumeCommande>();
//     
//     for (Commande c: desCommandes ){ 
//         lc.add(balCommande.getResumeCommande(c));
//     }
//     
//     return lc;
//    }
    
//    @Override
//    public List<ResumeCommande>  getResumesCommandeClient(Client client, int pAnnee) {
//       
//        return getResumesCommande(daoCommande.getLesCommandesduClient(client, pAnnee));
//    }
//
//    @Override
//    public List<ResumeCommande>  getResumesCommandeClient(Client client, int pAnnee, int pMois) {
//        
//        return getResumesCommande(daoCommande.getLesCommandesduClient(client, pAnnee,pMois));
//        
//    }             
    
       @Override
    public Float resteARegler(Client pClient) {
       
       Float valeur=0F;
       
       for ( Commande cmd : pClient.getLesCommandes()) {
       
         if (! balCommande.estReglee(cmd) ){
             valeur+= balCommande.montantCommandeTTC(cmd);
         }
       }
       return valeur;
       
    }
       
      

   
}
