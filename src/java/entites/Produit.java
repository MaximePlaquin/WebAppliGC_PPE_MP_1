package entites;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Produit implements Serializable {
    
    @Id
    private String refProd;
   
    private String desigProd;
   
   
    @OneToMany(mappedBy = "leProduit")
    private List<LigneDeCommande>lesLignesDeCommande=new LinkedList<LigneDeCommande>();
    
    @OneToMany(mappedBy = "leProduit")
    private List<TrancheTarifaire>lesTranchesTarifaire=new LinkedList<TrancheTarifaire>();
   
    @JoinColumn(name="CODECATEG")
    @ManyToOne
    private CategorieProduit laCategorie;
     
    public Produit (){ }

    public Produit(String refProd,String desigProd,  CategorieProduit categProd) {
       
        this.refProd   = refProd;
        this.desigProd = desigProd;
      
        this.laCategorie= categProd;
    }
    
    public void afficher(){
    
        System.out.printf("%-10s  %-20s  ",refProd,desigProd);
    }

    public List<TrancheTarifaire> getLesTranchesTarifaire() {
        return lesTranchesTarifaire;
    }

    public void setLesTranchesTarifaire(List<TrancheTarifaire> lesTranchesTarifaire) {
        this.lesTranchesTarifaire = lesTranchesTarifaire;
    }

    public CategorieProduit getLaCategorie() {
        return laCategorie;
    }
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    public String getRefProd() {
        return refProd;
    }
    public void   setRefProd(String refProd) {
        this.refProd = refProd;
    }
    public String getDesigProd() {
        return desigProd;
    }
    public void   setDesigProd(String desigProd) {
        this.desigProd = desigProd;
    }
    public List<LigneDeCommande> getLesLignesDeCommande() {
        return lesLignesDeCommande;
    }
    public void   setLesLignesDeCommande(List<LigneDeCommande> lesLignesDeCommande) {
        this.lesLignesDeCommande = lesLignesDeCommande;
    }
 
    //</editor-fold>
}
    
