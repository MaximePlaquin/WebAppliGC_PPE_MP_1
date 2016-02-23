package bal.categorieproduit;

import bal.produit.BalProduit;
import bal.tranchetarifaire.BalTrancheTarifaire;
import dao.categorieproduit.DaoCategorieProduit;
import entites.CategorieProduit;
import entites.Commande;
import entites.LigneDeCommande;
import entites.Produit;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BalCategorieProduitImpl implements BalCategorieProduit, Serializable{

@Inject DaoCategorieProduit daoCategorieProduit;
@Inject BalTrancheTarifaire balTT;

@Override
    public Float caCategorieProduit(CategorieProduit pCategProd){
       
       Float ca=0F;
       
       for(Produit pro : pCategProd.getLesProduits()){
       
           for(LigneDeCommande ldc : pro.getLesLignesDeCommande()){
           
                Commande cmd = ldc.getLaCommande();
                
               
                if(cmd.getEtatCom().equals("R")){ 
            
                    ca+=balTT.prixProd(pro, ldc.getQteCom());
                }
              
           }
           
       }
       
       return ca;
    }

@Override
 public Float caCodeCategorieProduit(String cpcodeCateg){
       
       Float ca=0F;
       
       CategorieProduit categ = daoCategorieProduit.getLaCategorie(cpcodeCateg);
       ca =  caCategorieProduit(categ);
     
       
       return ca;
    }
}
   
