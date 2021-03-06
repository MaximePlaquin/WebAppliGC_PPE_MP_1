package dao.client;

import entites.Client;
import java.io.Serializable;
import java.util.List;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class DaoClientImpl implements DaoClient,Serializable {   
    
  @PersistenceContext EntityManager em;
    
    @Override
    public Client getLeClient(Long pNumcli) {
        
       return em.find(Client.class, pNumcli);
    }

    @Override
    public List<Client> getTousLesClients() {
       
        return em.createQuery("Select c From Client c order by c.nomCli").getResultList();
    }
}


