
package bal.produit;

import entites.Produit;

public interface BalProduit {
    
    Float caAnnuelProduit(Produit pProduit, int pAnnee);
    Float caAnnuelProduit(Produit pProduit, int pAnnee, int pMois);   

}
