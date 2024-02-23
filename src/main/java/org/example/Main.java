package org.example;


public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        Simulation simulation = new Simulation();
        Render render = new Render();
        simulation.initWorld();

        while (simulation.herbivoresExist()) {
            simulation.startSimulation(render);
            System.out.println("_______________________________");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}
