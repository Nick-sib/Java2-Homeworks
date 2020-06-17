package marathon.competitors;

public class Human implements Runner, Jumper, CompetitorData{

    private String name = "атлет";
    private boolean onDistance = true;

    private float maxRunDistance = 2500.0f; //м рекорд суточного пробега марафонца, википедия
    private float maxJumpHeight  = 2.4f;    //м прыжок ввысоту с разбега олимпийца, без шеста

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, float maxRunDistance, float maxJumpHeight ) {
        this.name = name;
        this.maxRunDistance = maxRunDistance <= this.maxRunDistance? maxRunDistance : this.maxRunDistance;
        this.maxJumpHeight = maxJumpHeight <= this.maxJumpHeight? maxJumpHeight : this.maxJumpHeight;
    }

    public boolean isOnDistance() {
        return onDistance;
    }

    public void info() {
        if (onDistance)
            System.out.printf("%s еще держится\n", name);
        else
            System.out.printf("%s покинул полосу препятствий\n", name);
    }

    public boolean doJump(float value) {
        maxRunDistance -= 2.0f;//потратил на разгон
        onDistance = (maxJumpHeight >= value) && (maxRunDistance > 0);
        if (onDistance)
            System.out.printf("%s перепрыгнул %.2f метров\n", name, value);
        else
            System.out.printf("%s сощел с дистанции\n", name);

        return onDistance;
    }

    public boolean doRun(float value) {
        maxRunDistance -= value;
        onDistance = (maxRunDistance > 0);
        if (onDistance)
            System.out.printf("%s пробежал %.2f метров\n", name, value);
        else
            System.out.printf("%s сощел с дистанции\n", name);

        return onDistance;
    }
}
