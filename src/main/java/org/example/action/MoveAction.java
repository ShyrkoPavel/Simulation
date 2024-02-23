package org.example.action;

import org.example.entitys.Entity;
import org.example.entitys.creatures.Herbivore;
import org.example.entitys.creatures.Predator;
import org.example.Map;

public class MoveAction extends Action {

    @Override
    public void perform(Map map) {
        for (Entity entity : map.getAllEntities()) {
                if (entity instanceof Predator) {
                    ((Predator) entity).findNearestHerbivoreAndMove(map);

                } else if (entity instanceof Herbivore) {
                    ((Herbivore) entity).findNearestGrassAndMove(map);
                }
            }


    }
}

