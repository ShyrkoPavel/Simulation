package org.example.action;

import org.example.Coordinates;
import org.example.Entity;
import org.example.Map;

public abstract class SpawnAction<T extends Entity> extends Action {
    protected int countTypeOnMap;

    public void perform(Map map) {
        int currentRate = 0;
        while (currentRate < countTypeOnMap) {
            Coordinates coordinates = getEmptyRandomCoordinates(map);
            map.setEntityHashMap(coordinates, spawnEntity(coordinates));
            currentRate++;
        }
    }

    public Coordinates getEmptyRandomCoordinates(Map map) {
        while (true) {
            int x = (int) (Math.random() * 9);
            int y = (int) (Math.random() * 9);
            Coordinates coordinates = new Coordinates(y, x);
            if (map.isSquareEmpty(coordinates) && map.isValidCoordinate(coordinates, map)) {
                return coordinates;
            }
        }
    }

    protected abstract T spawnEntity(Coordinates c);
}
