package entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TrancheTarifaire implements Serializable {
    
    @Id
    private int idTranche;
    private int qteDebutTranche;
    private int qteFinTranche;
    private float prixUnitaire;
    

    
    //@JoinColumn(name="leProduit")
    @ManyToOne
    private Produit leProduit;
    
    

    public TrancheTarifaire() {}

    public TrancheTarifaire(int idTranche, int qteDebutTranche,int qteFinTranche,float prixUnitaire ) {
       
        this.idTranche = idTranche;
        this.qteDebutTranche  = qteDebutTranche;
        this.qteFinTranche  = qteFinTranche;
        this.prixUnitaire  = prixUnitaire;

        
    }

 
    public void afficher(){ System.out.printf("%-10s %-20s",idTranche,qteDebutTranche,qteFinTranche,prixUnitaire);}
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    
    public int getIdTranche() {
        return idTranche;
    }
    public void   setIdTranche(int idTranche) {
        this.idTranche = idTranche;
    }
    public int getQteDebutTranche() {
        return qteDebutTranche;
    }
    public void   setQteDebutTranche(int qteDebutTranche) {
        this.qteDebutTranche = qteDebutTranche;
    }
    
    public int getQteFinTranche() {
        return qteFinTranche;
    }
    public void   setQteFinTranche(int qteFinTranche) {
        this.qteFinTranche = qteFinTranche;
    }
    
      public float getPrixUnitaire() {
        return prixUnitaire;
    }
    public void   setPrixUnitaireTranche(int prixUnitaireTranche) {
        this.prixUnitaire = prixUnitaireTranche;
    }
    
    //</editor-fold>
}


