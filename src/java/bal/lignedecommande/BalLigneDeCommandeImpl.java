
package bal.lignedecommande;

import bal.tranchetarifaire.BalTrancheTarifaire;
import dao.produit.DaoProduit;
import dao.tva.DaoTva;
import dto.lignedecommande.ResumeLigneDeCommande;
import entites.LigneDeCommande;
import entites.Produit;
import entites.TrancheTarifaire;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class BalLigneDeCommandeImpl implements BalLigneDeCommande, Serializable {
    
@Override
public Float prixUnitaire (LigneDeCommande lgdc ){
    
    Float prix = 0f;
    
    Produit prod = lgdc.getLeProduit();
    Float qte = lgdc.getQteCom();
    
    for (TrancheTarifaire tt :  prod.getLesTranchesTarifaire()){
        
        if (qte>= tt.getQteDebutTranche() && qte<=tt.getQteFinTranche()){
            prix = tt.getPrixUnitaire();
            break;
        }
    }
    return prix;
}    
public Float mntHTlgdc (LigneDeCommande lgdc){
    
    return prixUnitaire(lgdc)*lgdc.getQteCom();
    
}
// mntHT*T


}


