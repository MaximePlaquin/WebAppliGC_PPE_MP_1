/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.region;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@XmlRootElement
public class ResumeRegion {
    
  private String codeReg;  
  private String  nomReg;
  private Float caAnnuel;
  private int nbclient;

  //<editor-fold defaultstate="collapsed" desc="GETTERS AND SETTERS">
  public String getNomReg() {
      return nomReg;
  }

    public Float getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Float caAnnuel) {
        this.caAnnuel = caAnnuel;
    }
  
  
  public void setNomReg(String nomReg) {
      this.nomReg = nomReg;
  }

    public int getNbclient() {
        return nbclient;
    }

    public void setNbclient(int nbclient) {
        this.nbclient = nbclient;
    }

  
  

    public String getCodeReg() {
        return codeReg;
    }

    public void setCodeReg(String codeReg) {
        this.codeReg = codeReg;
    }


  
    //</editor-fold>

    
}
