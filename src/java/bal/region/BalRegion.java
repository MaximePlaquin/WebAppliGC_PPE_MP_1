package bal.region;

import entites.Region;

public interface BalRegion {
    
    Float caAnnuel(Region region, int pAnnee );
    Float caAnneeEnCours(Region region);
    int nbClient(Region region);
}

