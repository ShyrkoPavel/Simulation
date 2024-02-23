package org.example.entitys.creatures;

//import org.example.BFS;

import org.example.BreadthFirstSearch;
import org.example.Coordinates;
import org.example.entitys.Grass;
import org.example.Map;

import java.util.List;

public class Herbivore extends Creature {

    public Herbivore(Coordinates coordinates, int speed, int HP) {
        super(coordinates, speed, HP);
    }

    public Herbivore() {
    }


    public void findNearestGrassAndMove(Map map) {
        List<Coordinates> pathToGrass = BreadthFirstSearch.findPathToEntity(map, this.coordinates, entity -> entity instanceof Grass);
        Coordinates nearestGrass = pathToGrass.isEmpty() ? null : pathToGrass.get(0);

        if (nearestGrass != null) {
            if (map.getEntity(nearestGrass) instanceof Grass) {
                attack(this.coordinates, nearestGrass, map);
            } else {
                map.moveEntity(this.coordinates, nearestGrass);
            }
        }
    }


    @Override
    public void attack(Coordinates fromCoordinates, Coordinates targetCoordinates, Map map) {

        if (map.getEntity(fromCoordinates) instanceof Herbivore) {
           // Herbivore herbivore = (Herbivore) map.getEntity(fromCoordinates);
            ((Herbivore) map.getEntity(fromCoordinates)).setHP(((Herbivore) map.getEntity(fromCoordinates)).getHP()+1);
            map.moveEntity(fromCoordinates, targetCoordinates);
        }
    }

}




