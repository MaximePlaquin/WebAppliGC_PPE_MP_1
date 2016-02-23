package dao.produit;
import entites.Produit;
import java.io.Serializable;
import java.util.List;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class DaoProduitImpl  implements DaoProduit, Serializable{

    @PersistenceContext EntityManager em;
    
    
    @Override
    public Produit getProduit(String pRefProd) {
        return em.find(Produit.class, pRefProd);
    }
    
    @Override
    public List<Produit> getTousLesProduits() {
        return em.createQuery("Select p From Produit p order by p.refProd").getResultList();
    }
}
