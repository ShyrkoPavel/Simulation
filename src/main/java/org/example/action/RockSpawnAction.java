package org.example.action;

import org.example.Coordinates;
import org.example.entitys.Rock;
import org.example.Map;

public class RockSpawnAction extends SpawnAction<Rock>{
    @Override
    protected Rock spawnEntity(Coordinates c) {
        return new Rock(c);
    }

    public RockSpawnAction(Map map) {
        float chanceSpawn = 0.15f;
        super.countTypeOnMap = (int) (map.getSizeMap() * chanceSpawn);
    }
}
