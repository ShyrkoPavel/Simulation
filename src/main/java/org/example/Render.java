package org.example;



import org.example.entitys.creatures.Herbivore;
import org.example.entitys.creatures.Predator;
import org.example.entitys.Grass;
import org.example.entitys.Rock;

public class Render {
    public static final String wolfEmoji = "\uD83D\uDC3A";
    public static final String hareEmoji = "\uD83D\uDC07";
    public static final String rockEmoji = "\uD83D\uDDFB";
    public static final String treeEmoji = "\uD83C\uDF32";
    public static final String grassEmoji = "\uD83C\uDF31";


    public void render(Map map) {


        for (int rank = 9; rank >= 1; rank--) {
            String line = "";

            for (int file = 1; file <= 9; file++) {
                Coordinates coordinates = new Coordinates(file, rank);
                if (map.isSquareEmpty(coordinates)) {
                    line += "...";

                } else {
                    line += getEntityFigure(map.getEntity(coordinates));
                }
            }

            System.out.println(line);

        }
    }

    private String getEntityFigure(Entity entity) {
        String result;
        if (entity instanceof Herbivore) {
            return hareEmoji + ".";
        } else if (entity instanceof Predator) {
            return wolfEmoji + ".";
        } else if (entity instanceof Rock) {
            return rockEmoji + ".";
        } else if(entity instanceof Grass){
            return grassEmoji + ".";
        }else
            return treeEmoji + ".";
    }
}
