
package models;

/**
 * 
 * @author Andres santiago <Andrecksantiago@gmail.com>
 */
public class City {
    
    private int idCity;
    private String nameCity;

    public City(int idCity, String nameCity) {
        this.idCity = idCity;
        this.nameCity = nameCity;
    }

    public int getIdCity() {
        return idCity;
    }

    public String getNameCity() {
        return nameCity;
    }
    
    
}
