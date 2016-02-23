package dto.commande;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ResumeCommande {
    
  private Long    numcom;
  private Date    datecom;
  private String  etatcom;
  private Float   montantHT;
  private Float   montantTTC;
  private Long    numcli;
  private String  nomcli;
  private String  adrcli;
  private String  coderegion;
  private String  nomregion;
    //<editor-fold defaultstate="collapsed" desc="getters et setters">
    public Long getNumcom() {
        return numcom;
    }
    
    public void setNumcom(Long numcom) {
        this.numcom = numcom;
    }
    
    public Date getDatecom() {
        return datecom;
    }
    
    public void setDatecom(Date datecom) {
        this.datecom = datecom;
    }
    
    public String getEtatcom() {
        return etatcom;
    }
    
    public void setEtatcom(String etatcom) {
        this.etatcom = etatcom;
    }
    
    public Float getMontantHT() {
        return montantHT;
    }
    
    public void setMontantHT(Float montantHT) {
        this.montantHT = montantHT;
    }
    
    public Float getMontantTTC() {
        return montantTTC;
    }
    
    public void setMontantTTC(Float montantTTC) {
        this.montantTTC = montantTTC;
    }
    
    //</editor-fold>

    public Long getNumcli() {
        return numcli;
    }

    public void setNumcli(Long numcli) {
        this.numcli = numcli;
    }

    public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    public String getAdrcli() {
        return adrcli;
    }

    public void setAdrcli(String adrcli) {
        this.adrcli = adrcli;
    }

    public String getCoderegion() {
        return coderegion;
    }

    public void setCoderegion(String coderegion) {
        this.coderegion = coderegion;
    }

    public String getNomregion() {
        return nomregion;
    }

    public void setNomregion(String nomregion) {
        this.nomregion = nomregion;
    }
}



