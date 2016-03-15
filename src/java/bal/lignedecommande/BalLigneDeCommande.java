/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bal.lignedecommande;

import entites.LigneDeCommande;

/**
 *
 * @author Administrateur
 */
public interface BalLigneDeCommande {

    Float prixUnitaire(LigneDeCommande lgdc);
    Float mntHTlgdc(LigneDeCommande lgdc);
    Float mntTTClgdc(LigneDeCommande lgdc);
       
}
