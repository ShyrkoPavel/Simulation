package org.example.action;

import org.example.Coordinates;
import org.example.entitys.Grass;
import org.example.Map;

public class GrassSpawnAction extends SpawnAction<Grass>{
    @Override
    protected Grass spawnEntity(Coordinates c) {
        return new Grass(c);
    }

    public GrassSpawnAction(Map map) {
        float chanceSpawn = 0.18f;
        super.countTypeOnMap = (int) (map.getSizeMap() * chanceSpawn);
    }
}
