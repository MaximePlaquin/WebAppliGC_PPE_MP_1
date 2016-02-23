/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bal.tranchetarifaire;

import dao.tranchetarifaire.DaoTrancheTarifaire;
import entites.Produit;
import entites.TrancheTarifaire;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class BalTrancheTarifaireImpl implements BalTrancheTarifaire, Serializable {
    
    @Inject DaoTrancheTarifaire  daoTrancheTarifaire;
    
    @Override
       public Float prixProd(Produit pProduit, Float qte){
     Float prixProd=0F;
              for(TrancheTarifaire tf : pProduit.getLesTranchesTarifaire()){

                  if((qte>=tf.getQteDebutTranche())&& (qte<=tf.getQteFinTranche())){
               
               prixProd=tf.getPrixUnitaire();break;
               
           }

       }
        return prixProd;
    }
    
    
    
}
