
package fabrique.dto.lignedecommande;

import dto.lignedecommande.ResumeLigneDeCommande;
import entites.LigneDeCommande;
import java.util.List;

/**
 *
 * @author rsmon
 */
public interface FabResumeLigneDeCommande {

    List<ResumeLigneDeCommande> creerListeResumeLigneCommande(List<LigneDeCommande> pListeLignesDeCommandes);

    ResumeLigneDeCommande       creerResumeLigneDeCommande(LigneDeCommande pLigneDeCommande);
    
}
