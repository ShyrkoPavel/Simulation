package org.example;

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


    /*
    ранк высота
    getNeighbors перебирает координаты в двух циклах по вертикале и горизонтале и возвращает соседние координаты
    начиная от текущих координат - 1, потом тек.координат, затем тек.координат +1
     exp. file=2, rank = 6 ---> сначада ранк 5, филе 1, потом ранк 5 филе 2, ранк 5 филе 3,
                                   ранк 6, филе 1, ранк 6 филе 2, ранк 6 филе 3,
                                   ранк 7, филе 1, ранк 7 филе 2, ранк 7 филе 3,

     */
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
            return false; // Вне границ карты
        }

        return true;
    }

      /*
     getEntitiesOfType возвращает карту, содержащую сущности определенного типа T по указанным координатам.
     Создается новая HashMap с координатами в качестве ключей и объектами типа T в качестве значений
     Итерируем по всем элементам в entityHashMap
     Для каждой сущности в entityHashMap проверяется, является ли сущность экземпляром класса, предоставленного в параметре typeEntity.
     Это делается с помощью метода isInstance, который проверяет, является ли данный объект экземпляром указанного класса.
       */

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
