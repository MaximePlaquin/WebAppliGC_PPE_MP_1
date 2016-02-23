package fabrique.dto.commande;

import dto.commande.ResumeCommande;
import entites.Client;
import entites.Commande;
import java.util.List;

/**
 *
 * @author rsmon
 */
public interface FabResumesCommandes {

    List<ResumeCommande> getResumesCommandeClient(Client client);

    List<ResumeCommande> getResumesCommandeClient(Client client, int pAnnee);

    List<ResumeCommande> getResumesCommandeClient(Client client, int pAnnee, int pMois);

    ResumeCommande       creerResumeCommande(Commande commande);

    ResumeCommande       creerResumeCommande(Long numcom);    

    List<ResumeCommande> getResumesCommande(List<Commande> desCommandes);
   
    List<ResumeCommande> getResumesCommandeClient (Long pclient);
    

    
}
