package org.example.action;

import org.example.Coordinates;
import org.example.entitys.creatures.Herbivore;
import org.example.Map;

public class HerbivoreSpawnAction extends SpawnAction<Herbivore>{
    @Override
    protected Herbivore spawnEntity(Coordinates c) {
        return new Herbivore();
    }

    public HerbivoreSpawnAction(Map map) {
        float chanceSpawn = 0.14f;
        super.countTypeOnMap = (int) (map.getSizeMap() * chanceSpawn);
    }
}
