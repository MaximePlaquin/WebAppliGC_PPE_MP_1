package bal.region;

import bal.commande.BalCommande;
import entites.Client;
import entites.Commande;
import entites.Region;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Singleton;
import static utilitaires.UtilDate.*;

@Singleton
public class BalRegionImpl  implements BalRegion, Serializable{

    @Inject
    private BalCommande balCommande;
    
    @Override
    public Float caAnnuel(Region pRegion, int pAnnee) {
       
        Float ca=0f;
       
        if( pRegion!= null ){
         
            for (Client cli : pRegion.getLesClients()) {
        
              for (Commande cmd : cli.getLesCommandes()){
            
                if( dansAnnee(cmd.getDateCom(), pAnnee)&& balCommande.estReglee(cmd)){
                  
                  ca+=balCommande.montantCommandeHT(cmd);
                }
              }
            }
        }
        else ca=null;

        return ca;
    }

    @Override
    public Float caAnneeEnCours(Region region) {
        return this.caAnnuel(region, anneeCourante());
    }   
    
    
    @Override 
    public int nbClient(Region region){
        int nbclient=0;
        for(Client cli : region.getLesClients()){
           nbclient = nbclient+1;
          
        }
      return nbclient;

        }
    }



