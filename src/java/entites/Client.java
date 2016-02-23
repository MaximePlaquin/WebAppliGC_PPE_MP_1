package entites;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
public class Client implements Serializable {
  
    @Id
    private Long   numCli;
    private String nomCli;
    private String adrCli;
    private Float tauxRemCli;
    @JoinColumn(name="CODEREG")
    @ManyToOne
    private Region laRegion;
    
    
    @OneToMany(mappedBy = "leClient", cascade=CascadeType.ALL)
    private List<Commande> lesCommandes=new LinkedList<Commande>();

    public Client() {}

    public Client(Long numCli,String nomCli, String adrCli,Float tauxRemCli, Region laRegion) {
        
        this.numCli = numCli;
        this.nomCli = nomCli;
        this.adrCli = adrCli;
        this.tauxRemCli = tauxRemCli;
        this.laRegion = laRegion;
    }

    @Override
    public String toString() {return nomCli ;}
    
    public void afficher(){System.out.printf("%4d %-20s %-60s",numCli,nomCli,adrCli);}
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    
    public Long getNumCli() {
        return numCli;
    }
    public void setNumCli(Long numCli) {
        this.numCli = numCli;
    }
    
    public String getNomCli() {
        return nomCli;
    }
    public void setNomCli(String nomCli) {
        this.nomCli = nomCli;
    }
    
    public String getAdrCli() {
        return adrCli;
    }
    public void setAdrCli(String adrCli) {
        this.adrCli = adrCli;
    }

    public Float getTauxRemCli() {
        return tauxRemCli;
    }

    public void setTauxRemCli(Float tauxRemCli) {
        this.tauxRemCli = tauxRemCli;
    }
    
    
    
    public Region getLaRegion() {
        return laRegion;
    }
    
    public void setLaRegion(Region laRegion) {
        this.laRegion = laRegion;
    }
    
    @XmlTransient
    public List<Commande> getLesCommandes() {
        return lesCommandes;
    }
    
    public void setLesCommandes(List<Commande> lesCommandes) {
        this.lesCommandes = lesCommandes;
    }
    //</editor-fold>
}



