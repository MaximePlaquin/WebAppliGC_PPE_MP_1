package dao.produit;

import entites.Produit;
import java.util.List;

/**
 *
 * @author rsmon
 */

public interface DaoProduit {

    Produit getProduit(String pRefProd);
    List<Produit> getTousLesProduits();
}
