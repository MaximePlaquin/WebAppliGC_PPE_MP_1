package entites;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class CategorieProduit implements Serializable {
   
    @Id
    private String codeCateg;
    private String nomCateg;
    
   
    @OneToMany(mappedBy = "laCategorie", cascade=CascadeType.ALL)
    private List<Produit> lesProduits= new LinkedList<Produit>();
     
    public CategorieProduit() {}

    public CategorieProduit(String codeCateg, String nomCateg) {
        this.codeCateg = codeCateg;
        this.nomCateg = nomCateg;
    }
    
    public void afficher(){
    
        System.out.printf("%-8s %-20s",codeCateg,nomCateg);
    }
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    public String getCodeCateg() {
        return codeCateg;
    }
    public void setCodeCateg(String codeCateg) {
        this.codeCateg = codeCateg;
    }
    public String getNomCateg() {
        return nomCateg;
    }
    public void setNomCateg(String nomCateg) {
        this.nomCateg = nomCateg;
    }
    public List<Produit> getLesProduits() {
        return lesProduits;
    }
    public void setLesProduits(List<Produit> lesProduits) {
        this.lesProduits = lesProduits;
    }
    //</editor-fold>
}



