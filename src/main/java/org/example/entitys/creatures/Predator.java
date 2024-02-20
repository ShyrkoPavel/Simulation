package org.example.entitys.creatures;

import org.example.*;

import java.util.List;

public class Predator extends Creature {
    private int powerOfAttack = 2;

    public Predator(Coordinates coordinates, int speed, int HP, int powerOfAttack) {
        super(coordinates, speed, HP);
        this.powerOfAttack = powerOfAttack;

    }

    public Predator() {
    }


    public void findNearestHerbivoreAndMove(Map map) {

        List<Coordinates> pathToHerbivore = BreadthFirstSearch.findPathToEntity(map, this.coordinates, entity -> entity instanceof Herbivore);
        Coordinates nearestHerbivore = pathToHerbivore.isEmpty() ? null : pathToHerbivore.get(0);

        if (nearestHerbivore != null) {
            if (map.getEntity(nearestHerbivore) instanceof Herbivore) {
                attack(nearestHerbivore, map);

            } else {
                map.moveEntity(this.coordinates, nearestHerbivore);
            }
        }
    }


    public void attack(Coordinates target, Map map) {
        Herbivore h = ((Herbivore) map.getEntity(target));
        if (target != null) {
            h.setHP(h.getHP() - this.powerOfAttack);
        }

        if (h.getHP() <= 0) {
            map.removeEntity(target);
            map.moveEntity(this.coordinates, target);

        }

    }

}

