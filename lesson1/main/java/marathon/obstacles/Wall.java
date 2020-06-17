package marathon.obstacles;

import marathon.competitors.Competitor;
import marathon.competitors.Jumper;
import marathon.competitors.Runner;

public class Wall extends Obstacle{
    private float height;

    public Wall(float height) {
        this.height = height;
    }

    public boolean doIt(Competitor c) {
        return ((Jumper) c).doJump(height);
    }
}
