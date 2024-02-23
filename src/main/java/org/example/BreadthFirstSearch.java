package org.example;

import org.example.entitys.Entity;
import org.example.entitys.creatures.Herbivore;
import org.example.entitys.Grass;

import java.util.*;
import java.util.function.Predicate;

public class BreadthFirstSearch {
    public static List<Coordinates> findPathToEntity(Map map, Coordinates start, Predicate<Entity> entityCondition) {
        Queue<Coordinates> queue = new LinkedList<>();
        HashMap<Coordinates, Coordinates> parentMap = new HashMap<>();
        Set<Coordinates> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();
            Entity currentEntity = map.getEntity(current);

            if (entityCondition.test(currentEntity)) {
                return reconstructPath(parentMap, current);
            }

            for (Coordinates neighbor : map.getNeighbors(current, map)) {
                if (!visited.contains(neighbor) && isSquareTraversable(map, neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }

        return Collections.emptyList(); // No path found
    }
    private static boolean isSquareTraversable(Map map, Coordinates coordinates) {
        Entity entity = map.getEntity(coordinates);
        return entity == null || (entity instanceof Herbivore) ||  (entity instanceof Grass);
    }

    private static List<Coordinates> reconstructPath(HashMap<Coordinates, Coordinates> parentMap, Coordinates current) {
        List<Coordinates> path = new ArrayList<>();
        while (parentMap.containsKey(current)) {
            path.add(current);
            current = parentMap.get(current);
        }
        Collections.reverse(path);
        return path;
    }

}





