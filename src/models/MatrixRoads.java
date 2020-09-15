
package models;

import java.util.ArrayList;

/**
 * 
 * @author Andres santiago <Andrecksantiago@gmail.com>
 */
public class MatrixRoads {
    
    private static int counter;
    private ArrayList<City> listCities;
    private int[][] matrixCities;
    
    private static City createNewCity(String namecity){
        counter++;
        return new City(counter, namecity);
    }
    
    public void addNewCity(City city){
        listCities.add(city);
        int[][] newMatrix = new int[listCities.size() + 1][listCities.size() + 1];
        for (int i = 0; i < listCities.size(); i++) {
            for (int j = 0; j < listCities.size(); j++) {
                newMatrix[i][j] = matrixCities[i][j];
            }
        }
        matrixCities = newMatrix;
    }
    
    public void addNewRoadBetweenCities(City cityA, City cityB, int valueRoad){
        int idA = cityA.getIdCity();
        int idB = cityB.getIdCity();
        matrixCities[idA][idB] = valueRoad;
        matrixCities[idB][idA] = valueRoad;
    }

}
