package webservice.rest.commande;

import dao.client.DaoClient;
import dao.commande.DaoCommande;
import dto.commande.ResumeCommande;
import dto.lignedecommande.ResumeLigneDeCommande;
import entites.Client;
import entites.Commande;
import entites.LigneDeCommande;
import fabrique.dto.commande.FabResumesCommandes;
import fabrique.dto.lignedecommande.FabResumeLigneDeCommande;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Administrateur
 */
 @Stateless
 @Path("commande")
 
public class WebServRestCommande {
    
  @Inject FabResumesCommandes fab;
  @Inject ResumeCommande dto;
  @Inject DaoCommande dao;
  @Inject FabResumeLigneDeCommande fabrc;
  @Inject DaoClient daoclient;
  
   @GET
    @Path("{numCom}")
    @Produces({"application/xml","application/json"})
    public ResumeCommande CommandeNumCom(@PathParam("numCom")Long numCom) {

       
         ResumeCommande rc= fab.creerResumeCommande(numCom);
       
   return rc;
       
      
    }
   
    @GET
    @Path("toutes")
    @Produces({"application/xml","application/json"})
       public List<ResumeCommande> getLesResumesCommandes(){
    
     List<Commande> lesCommandes=dao.getToutesLesCommandes();
    
     
     for(Commande cmd : lesCommandes ){
         
        fab.creerResumeCommande(cmd);
     }
     
     List<ResumeCommande> lesResumesCommandes=fab.getResumesCommande(lesCommandes);
     return lesResumesCommandes;
       
     
    }
    
  
    
    /*    @GET
     * @Path("lignesdecommande/{numCom}")
     * @Produces({"application/xml","application/json"})
     * 
     * public List<ResumeLigneDeCommande> getLesLignesDeCommandes(@PathParam("numCom")Long numCom){
     * 
     * Commande cmd = dao.getCommande(numCom);
     * List<LigneDeCommande> ldc = cmd.getLesLignesDeCommande();
     * 
     * 
     * rldc.
     * return rldc;
     * 
     * 
     * }*/
    
    @GET
    @Path("client/{numCli}")
    @Produces({"application/xml","application/json"})
    
    public List<ResumeCommande> getResumesCommandeClient(@PathParam("numCli")Long numCli){
     
     
     Client cli = daoclient.getLeClient(numCli);
     //List<Commande> c = cli.getLesCommandes();
     List<ResumeCommande> rdc = fab.getResumesCommandeClient(cli);
     
     return rdc;
 }
    
    
}
