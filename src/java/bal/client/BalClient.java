
package bal.client;
import dto.commande.ResumeCommande;
import entites.Client;
import java.util.List;

public interface BalClient {
    
    Float                 caAnnuel(Client pClient, int pAnnee);
    Float                 caMensuel(Client pClient, int pAnnee, int pMois);
    Float                 caAnneeEnCours(Client pClient);
    Float                   resteARegler (Client pClient);
    
//    List<ResumeCommande>  getResumesCommandeClient(Client client); 
//    List<ResumeCommande>  getResumesCommandeClient(Client client, int pAnnee);
//    List<ResumeCommande>  getResumesCommandeClient(Client client, int pAnnee, int pMois);
    
}
