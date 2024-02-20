package org.example.action;


import org.example.Coordinates;
import org.example.entitys.creatures.Predator;
import org.example.Map;

public class PredatorSpawnAction extends SpawnAction<Predator>{
    @Override
    protected Predator spawnEntity(Coordinates c) {
        return new Predator();
    }

    public PredatorSpawnAction(Map map) {
        float chanceSpawn = 0.07f;
        super.countTypeOnMap = (int) (map.getSizeMap() * chanceSpawn);
    }

}
