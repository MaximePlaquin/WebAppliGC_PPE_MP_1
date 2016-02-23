package bal.client;
import dto.commande.ResumeCommande;
import entites.Client;
import java.util.List;
import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;


@Singleton 
@Alternative

public class BalClientMock  implements BalClient{
    
    
    @Override
    public Float                 caAnnuel(Client pClient, int pAnnee) {
        Float ca=0f;
        for(int m= 1; m<=12;m++) { ca+=caMensuel(null,2014,m);}
        return ca;
    }

    @Override
    public Float                 caMensuel(Client pClient, int pAnnee, int pMois) {
        
        
        Float ca=0f;
        switch(pMois){
            case  1: ca=200f;break; 
            case  2: ca=150f;break; 
            case  3: ca=250f;break; 
            case  4: ca=300f;break;
            case  5: ca=220f;break; 
            case  6: ca=380f;break;
            case  7: ca=200f;break; 
            case  8: ca=100f;break; 
            case  9: ca=350f;break; 
            case 10: ca=250f;break;
            case 11: ca=400f;break; 
            case 12: ca=300f;break;         
        }
        return ca;
    }                

//    @Override
//    public List<ResumeCommande> getResumesCommandeClient(Client client) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public List<ResumeCommande> getResumesCommandeClient(Client client, int pAnnee) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public List<ResumeCommande> getResumesCommandeClient(Client client, int pAnnee, int pMois) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

    @Override
    public Float caAnneeEnCours(Client pClient) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
     @Override
    public Float resteARegler(Client pClient) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
