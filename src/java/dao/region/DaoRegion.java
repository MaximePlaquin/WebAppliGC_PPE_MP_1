package dao.region;

import entites.Region;
import java.util.List;

public interface DaoRegion {

    List<Region>  getToutesLesRegions();
    Region getLaRegion(String CodeReg);
}

