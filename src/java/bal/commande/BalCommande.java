package bal.commande;

import dto.commande.ResumeCommande;
import entites.Commande;

public interface BalCommande {
    
    Float   montantCommandeHT(Commande pCommande);
    Float   montantCommandeTTC(Commande pCommande);
    
    boolean estReglee(Commande pCommande);
    
//    ResumeCommande  getResumeCommande(Commande c);
}


