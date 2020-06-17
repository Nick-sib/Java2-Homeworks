package marathon;

import marathon.competitors.*;
import marathon.obstacles.Cross;
import marathon.obstacles.Obstacle;
import marathon.obstacles.Wall;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static final String[] HUMANS_NAME = {"Давид", "Давлат", "Дамир", "Дана", "Даниил"};
    private static final String[] CATS_NAME = {"Дымок", "Уголек", "Апельсин", "Лисенок", "Персик"};
    private static final String[] ROBOTS_NAME = {"T-800", "C-3PO", "Бишоп", "Дэвид", "Марвин"};



    public static void main(String[] args) {
        Random random = new Random();
        int countCompetitors = 2 + random.nextInt(8);


        ArrayList<Competitor> competitors = new ArrayList();
        for (int i = 0; i < countCompetitors; i++) {
            switch (random.nextInt(3)) {
                case 0: competitors.add(
                            new Human(
                                HUMANS_NAME[random.nextInt(HUMANS_NAME.length)],
                                3000*random.nextFloat(),
                                5*random.nextFloat()));
                    break;
                case 1: competitors.add(
                        new Cat(
                                CATS_NAME[random.nextInt(CATS_NAME.length)],
                                3000*random.nextFloat(),
                                5*random.nextFloat()));
                    break;
                case 2: competitors.add(
                        new Robot(
                                ROBOTS_NAME[random.nextInt(ROBOTS_NAME.length)],
                                3000*random.nextFloat(),
                                5*random.nextFloat()));
                    break;

            }
        }


        int countObstacle = 1 + random.nextInt(4);
        ArrayList<Obstacle> obstacles = new ArrayList<>();

        for (int i = 0; i < countCompetitors; i++) {
            switch (random.nextInt(2)) {
                case 0:  obstacles.add(new Cross(1000*random.nextFloat()));
                    break;
                case 1: obstacles.add(new Wall(random.nextFloat()));
                    break;
            }
        }


        for (Competitor c:competitors ) {
            for (Obstacle o:obstacles ) {
                if(!o.doIt(c))
                    break;
            }
        }

        System.out.println("\n=========================\n");

        for (Competitor c: competitors )
            ((CompetitorData) c).info();
    }
}
