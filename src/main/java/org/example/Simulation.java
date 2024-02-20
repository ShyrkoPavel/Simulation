package org.example;

import org.example.action.*;
import org.example.action.RockSpawnAction;
import org.example.entitys.creatures.Herbivore;
import org.example.entitys.creatures.Predator;


import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final Map map;

    public Simulation() {
        map = new Map();
    }


    protected void startSimulation(Render renderer) {

        nextTurn(renderer);
    }

    protected boolean nextTurn(Render renderer) {
        if (herbivoresExist() || predatorsExist()) {
            MoveAction moveAction = new MoveAction();
            moveAction.perform(map);

            renderer.render(map);

            return true;
        } else {
            return false;
        }
    }

    protected void initWorld() {
        for (Action action : getInitActions()) {
            action.perform(map);
        }
    }

    private List<Action> getInitActions() {
        List<Action> initActions = new ArrayList<>();
        initActions.add(new GrassSpawnAction(map));
        initActions.add(new HerbivoreSpawnAction(map));
        initActions.add(new PredatorSpawnAction(map));
        initActions.add(new RockSpawnAction(map));
        initActions.add(new TreeSpawnAction(map));
        return initActions;
    }

    protected boolean herbivoresExist() {
        return !map.getEntitiesOfType(Herbivore.class).isEmpty();
    }

    protected boolean predatorsExist() {
        return !map.getEntitiesOfType(Predator.class).isEmpty();
    }

}
