package dao.tranchetarifaire;

import entites.TrancheTarifaire;
import java.io.Serializable;
import java.util.List;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class DaoTrancheTarifaireImpl implements DaoTrancheTarifaire, Serializable {   
    
   @PersistenceContext EntityManager em;
    
    @Override
    public TrancheTarifaire getLaTrancheTarifaire(int pIdTranche) {
        
       return em.find(TrancheTarifaire.class, pIdTranche);
    }

    @Override
    public List<TrancheTarifaire> getTouteLesTranches() {
       
        return em.createQuery("Select * From TrancheTarifaire").getResultList();
    }
}


