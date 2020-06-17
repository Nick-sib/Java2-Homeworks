package marathon.competitors;

public class Cat implements Runner, Jumper, CompetitorData{

    private String name = "котяра";
    private boolean onDistance = true;

    private float maxRunDistance = 200.0f; //м суточной пробег хорошо замотивированного кота
    private float maxJumpHeight  = 2.3f;   //м прыжок ввысоту с разбега

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, float maxRunDistance, float maxJumpHeight ) {
        this.name = name;
        this.maxRunDistance = maxRunDistance <= this.maxRunDistance? maxRunDistance : this.maxRunDistance;
        this.maxJumpHeight = maxJumpHeight <= this.maxJumpHeight? maxJumpHeight : this.maxJumpHeight;
    }

    public boolean isOnDistance() {
        return onDistance;
    }

    public void info() {
        if (onDistance)
            System.out.printf("кот %s еще держится\n", name);
        else
            System.out.printf("кот %s покинул полосу препятствий\n", name);
    }

    public boolean doJump(float value) {
        maxRunDistance -= 0.5f;//потратил на разгон
        onDistance = (maxJumpHeight >= value) && (maxRunDistance > 0);
        if (onDistance)
            System.out.printf("Кот %s перепрыгнул %.2f метров\n", name, value);
        else
            System.out.printf("Кот %s сощел с дистанции\n", name);

        return onDistance;
    }

    public boolean doRun(float value) {
        maxRunDistance -= value;
        onDistance = (maxRunDistance > 0);
        if (onDistance)
            System.out.printf("Кот %s пробежал %.2f метров\n", name, value);
        else
            System.out.printf("Кот %s сощел с дистанции\n", name);

        return onDistance;
    }
}
