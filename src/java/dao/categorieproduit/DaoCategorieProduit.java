
package dao.categorieproduit;

import entites.CategorieProduit;
import java.util.List;

public interface DaoCategorieProduit {

CategorieProduit getLaCategorie(String codeCateg);
List<CategorieProduit> getToutesLesCategories();
}
