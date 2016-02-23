package dao.categorieproduit;
import entites.CategorieProduit;
import java.io.Serializable;
import java.util.List;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class DaoCategorieProduitImpl  implements DaoCategorieProduit, Serializable{
    
    @PersistenceContext EntityManager em;
    
@Override
public CategorieProduit getLaCategorie(String cpcodeCateg){
     return em.find(CategorieProduit.class, cpcodeCateg);
    }

@Override
public List<CategorieProduit> getToutesLesCategories(){
     return em.createQuery("Select cp From CategorieProduit cp order by cp.codeCateg").getResultList();
    }

}

