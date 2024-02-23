package org.example;

import java.util.Objects;

public class Coordinates {
    public final  int file ;
    public final  int rank ;

    public Coordinates(int file, int rank) {
        this.file = file;
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return file == that.file && rank == that.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }


    @Override
    public String toString() {
        return "Coordinates{" +
                "file=" + file +
                ", rank=" + rank +
                '}';
    }
}
