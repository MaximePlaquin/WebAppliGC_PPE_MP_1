package dao.region;

import entites.Region;
import java.io.Serializable;
import java.util.List;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class DaoRegionImpl  implements DaoRegion,Serializable {

    @PersistenceContext EntityManager em;
    
    @Override
    public List<Region> getToutesLesRegions() {
     
        return em.createQuery("Select r from Region r").getResultList();
    }  
    
     @Override
    public Region getLaRegion(String codeRegion) {
        return em.find(Region.class, codeRegion);
    }
}





