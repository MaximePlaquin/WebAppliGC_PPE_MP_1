package dao.tranchetarifaire;
import entites.TrancheTarifaire;
import java.util.List;

public interface DaoTrancheTarifaire {

    TrancheTarifaire             getLaTrancheTarifaire(int pIdTranche);
    List<TrancheTarifaire>       getTouteLesTranches();   
}



