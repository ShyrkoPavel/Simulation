package org.example;

import org.example.entitys.Entity;

import java.util.*;

public class Map {

    HashMap<Coordinates, Entity> entityHashMap = new HashMap<>();

    public void setEntityHashMap(Coordinates coordinates, Entity entity) {

        entity.coordinates = coordinates;
        entityHashMap.put(coordinates, entity);

    }

    public List<Entity> getAllEntities() {
        return new ArrayList<>(entityHashMap.values());
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return entityHashMap.get(coordinates) == null; // Проверка наличия сущности на клетке
    }


    public Entity getEntity(Coordinates coordinates) {
        return entityHashMap.get(coordinates);
    }


    public void removeEntity(Coordinates coordinates) {

        entityHashMap.remove(coordinates);

    }


    public void moveEntity(Coordinates from, Coordinates to) {

        Entity entity = getEntity(from);

        removeEntity(from);

        setEntityHashMap(to, entity);


    }

    public List<Coordinates> getNeighbors(Coordinates coord, Map map) {
        List<Coordinates> neighbors = new ArrayList<>();

        int file = coord.file;
        int rank = coord.rank;

        for (int i = rank - 1; i <= rank + 1; i++) {
            for (int j = file - 1; j <= file + 1; j++) {
                Coordinates neighbour = new Coordinates(j, i);

                if (isValidCoordinate(neighbour, map)) {

                    neighbors.add(neighbour);
                }
            }
        }

        return neighbors;
    }

    public boolean isValidCoordinate(Coordinates coord, Map map) {
        int x = coord.file;
        int y = coord.rank;

        if (x < 1 || x > 9 || y < 1 || y > 9) {
            return false;
        }

        return true;
    }

    public <T> HashMap<Coordinates, T> getEntitiesOfType(Class<T> typeEntity) {
        HashMap<Coordinates, T> result = new HashMap<>();
        for (HashMap.Entry<Coordinates, Entity> entry : entityHashMap.entrySet()) {
            if (typeEntity.isInstance(entry.getValue())) {
                //noinspection unchecked
                result.put(entry.getKey(), (T) entry.getValue());
            }
        }
        return result;
    }

    public int getSizeMap() {
        return 18;
    }
}
