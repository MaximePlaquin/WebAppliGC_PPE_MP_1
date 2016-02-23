
package fabrique.dto.lignedecommande;

import dao.tva.DaoTva;
import dto.lignedecommande.ResumeLigneDeCommande;
import entites.LigneDeCommande;
import entites.Produit;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author rsmon
 */

@Singleton
public class FabResumeLigneDeCommandeImpl implements FabResumeLigneDeCommande, Serializable {
    
    @Inject DaoTva daoTva;
    
    @Override
    public ResumeLigneDeCommande creerResumeLigneDeCommande(LigneDeCommande pLigneDeCommande){
     
     ResumeLigneDeCommande rlgc= new ResumeLigneDeCommande(); 
     
     Produit produit= pLigneDeCommande.getLeProduit();
     
     rlgc.setRefProd(produit.getRefProd()); 
     rlgc.setDesigProd(produit.getDesigProd());
     rlgc.setMontantHT(rlgc.getPrixProd()*rlgc.getQteCom());
     rlgc.setMontantTTC(rlgc.getMontantHT()*daoTva.getTauxTVA());
     rlgc.setQteCom(pLigneDeCommande.getQteCom());
     
     return rlgc;
    }
    
    
    @Override
    public List<ResumeLigneDeCommande> creerListeResumeLigneCommande(List<LigneDeCommande> pListeLignesDeCommandes){
    
       List<ResumeLigneDeCommande>  listeRlgc= new LinkedList<ResumeLigneDeCommande>();

       for(LigneDeCommande lgc : pListeLignesDeCommandes){
       
           listeRlgc.add(creerResumeLigneDeCommande(lgc));
       }       
      
       return listeRlgc;

    }
    
}
