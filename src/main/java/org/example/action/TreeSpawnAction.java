package org.example.action;

import org.example.Coordinates;
import org.example.entitys.Tree;
import org.example.Map;

public class TreeSpawnAction extends SpawnAction<Tree>{
    @Override
    protected Tree spawnEntity(Coordinates c) {
        return new Tree(c);
    }

    public TreeSpawnAction(Map map) {
        float chanceSpawn = 0.19f;
        super.countTypeOnMap = (int) (map.getSizeMap() * chanceSpawn);
    }
}
