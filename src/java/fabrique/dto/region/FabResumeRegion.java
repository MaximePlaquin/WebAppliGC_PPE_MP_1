/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrique.dto.region;

import dto.region.ResumeRegion;
import entites.Region;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface FabResumeRegion {
    
ResumeRegion creerResumeRegion (Region region);
ResumeRegion creerResumeRegion(String codeReg);
List<ResumeRegion> getToutLesResumesRegions(List<Region> desRegions);
    
}
