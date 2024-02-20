package org.example.entitys.creatures;


import org.example.Coordinates;
import org.example.Entity;
import org.example.Map;

import java.util.Objects;

public abstract class Creature extends Entity {
    private int speed;
    private int HP = 2;

    public Creature(Coordinates coordinates, int speed, int HP) {
        super(coordinates);
        this.speed = speed;
        this.HP = HP;
    }
    public Creature(){};

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getHP() {
        return HP;
    }

    public void findNearestHerbivoreAndMove(Map map) {

    }



    public void attack(Coordinates fromCoordinates,Coordinates targetCoordinates, Map map) {

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Creature creature = (Creature) o;
        return speed == creature.speed && HP == creature.HP;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), speed, HP);
    }
}
