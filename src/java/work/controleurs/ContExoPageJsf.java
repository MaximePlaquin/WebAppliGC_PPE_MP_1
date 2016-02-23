package work.controleurs;

import bal.client.BalClient;
import bal.commande.BalCommande;
import bal.lignedecommande.BalLigneDeCommande;
import bal.tranchetarifaire.BalTrancheTarifaire;
import dao.commande.DaoCommande;
import entites.Commande;
import entites.LigneDeCommande;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Maxime Plaquin
 */

@Named
@SessionScoped
public class ContExoPageJsf implements Serializable{
  
    @Inject DaoCommande daoCommande;
    @Inject BalCommande balCommande;
    @Inject BalLigneDeCommande balLigneDeCommande;
    @Inject BalTrancheTarifaire balTrancheTarifaire;
    @Inject BalClient balClient;
    
    private Long   numcomRecherche;
    private Commande commande;
    
    private Float  caAnnuelCommande;
    private Float soldeClt;
    private Float caAnnuelClt;
    private Float mtnHT;
    private Float mtnTTC;
    private List <LigneDeCommande> lgdc;
    private Float mtnHTLgdc;
    private String messageTableau;

    
  public void prevalide(ComponentSystemEvent e){
      this.messageTableau = null;
  }
    
  @PostConstruct
  public void init(){
      System.out.println("Ok");
  }
    
    public void ecouteurRecherche(){
    
        if (numcomRecherche != null) {

            commande = daoCommande.getCommande(numcomRecherche);

            if (commande != null) {
                caAnnuelCommande = balCommande.montantCommandeTTC(commande);
                caAnnuelClt = this.balClient.caAnneeEnCours(commande.getLeClient());
                System.out.println(daoCommande.getCommande(numcomRecherche));
                soldeClt = this.balClient.resteARegler(commande.getLeClient());
                mtnHT = this.balCommande.montantCommandeHT(commande);
                mtnTTC = this.balCommande.montantCommandeTTC(commande);
                lgdc = this.commande.getLesLignesDeCommande();
                
            } else {

                commande = new Commande();
                caAnnuelCommande = null;

                FacesContext contexte = FacesContext.getCurrentInstance();
                contexte.addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                        null, "PAS COMMANDE CONNU AVEC CE NUMERO."));
            }
        }
        
    }

    //<editor-fold defaultstate="collapsed" desc="Get set">
    public DaoCommande getDaoCommande() {
        return daoCommande;
    }
    
    public void setDaoCommande(DaoCommande daoCommande) {
        this.daoCommande = daoCommande;
    }
    
    public BalCommande getBalCommande() {
        return balCommande;
    }
    
    public void setBalCommande(BalCommande balCommande) {
        this.balCommande = balCommande;
    }
    
    public BalLigneDeCommande getBalLigneDeCommande() {
        return balLigneDeCommande;
    }
    
    public void setBalLigneDeCommande(BalLigneDeCommande balLigneDeCommande) {
        this.balLigneDeCommande = balLigneDeCommande;
    }
    
    public BalTrancheTarifaire getBalTrancheTarifaire() {
        return balTrancheTarifaire;
    }
    
    public void setBalTrancheTarifaire(BalTrancheTarifaire balTrancheTarifaire) {
        this.balTrancheTarifaire = balTrancheTarifaire;
    }
    
    public BalClient getBalClient() {
        return balClient;
    }
    
    public void setBalClient(BalClient balClient) {
        this.balClient = balClient;
    }
    
    public Long getNumcomRecherche() {
        return numcomRecherche;
    }
    
    public void setNumcomRecherche(Long numcomRecherche) {
        this.numcomRecherche = numcomRecherche;
    }
    
    public Commande getCommande() {
        return commande;
    }
    
    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    
    public Float getCaAnnuelCommande() {
        return caAnnuelCommande;
    }
    
    public void setCaAnnuelCommande(Float caAnnuelCommande) {
        this.caAnnuelCommande = caAnnuelCommande;
    }
    
    public Float getSoldeClt() {
        return soldeClt;
    }
    
    public void setSoldeClt(Float soldeClt) {
        this.soldeClt = soldeClt;
    }
    
    public Float getCaAnnuelClt() {
        return caAnnuelClt;
    }
    
    public void setCaAnnuelClt(Float caAnnuelClt) {
        this.caAnnuelClt = caAnnuelClt;
    }
    
    public Float getMtnHT() {
        return mtnHT;
    }
    
    public void setMtnHT(Float mtnHT) {
        this.mtnHT = mtnHT;
    }
    
    public Float getMtnTTC() {
        return mtnTTC;
    }
    
    public void setMtnTTC(Float mtnTTC) {
        this.mtnTTC = mtnTTC;
    }
    
    public List<LigneDeCommande> getLgdc() {
        return lgdc;
    }
    
    public void setLgdc(List<LigneDeCommande> lgdc) {
        this.lgdc = lgdc;
    }
    
    public Float getMtnHTLgdc() {
        return mtnHTLgdc;
    }
    
    public void setMtnHTLgdc(Float mtnHTLgdc) {
        this.mtnHTLgdc = mtnHTLgdc;
    }
    
    public String getMessageTableau() {
        return messageTableau;
    }
    
    public void setMessageTableau(String messageTableau) {
        this.messageTableau = messageTableau;
    }
    //</editor-fold>
        


   

}

