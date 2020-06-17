package marathon.obstacles;

import marathon.competitors.Competitor;
import marathon.competitors.Runner;

public class Cross extends Obstacle {

    private float dist;

    public Cross(float dist) {
        this.dist = dist;
    }

    public boolean doIt(Competitor c) {
        return ((Runner) c).doRun(dist);
    }
}
