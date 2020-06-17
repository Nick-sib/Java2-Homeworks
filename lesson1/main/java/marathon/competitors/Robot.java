package marathon.competitors;

public class Robot implements Runner, Jumper, CompetitorData{

    private String name = "атлет";
    private boolean onDistance = true;

    private float maxRunDistance = 650.0f; //м робот на аккумуляторах без солнечных батарей и тд
    private float maxJumpHeight  = 1.42f;   //м прыжок ввысоту лёгкого робота

    public Robot(String name) {
        this.name = name;
    }

    public Robot(String name, float maxRunDistance, float maxJumpHeight ) {
        this.name = name;
        this.maxRunDistance = maxRunDistance <= this.maxRunDistance? maxRunDistance : this.maxRunDistance;
        this.maxJumpHeight = maxJumpHeight <= this.maxJumpHeight? maxJumpHeight : this.maxJumpHeight;
    }

    public boolean isOnDistance() {
        return onDistance;
    }

    public void info() {
        if (onDistance)
            System.out.printf("Робот %s еще держится\n", name);
        else
            System.out.printf("Робот %s покинул полосу препятствий\n", name);
    }

    public boolean doJump(float value) {
        maxRunDistance -= value*2;//потратил энергии
        onDistance = (maxJumpHeight >= value) && (maxRunDistance > 0);
        if (onDistance)
            System.out.printf("Робот %s перепрыгнул %.2f метров\n", name, value);
        else
            System.out.printf("Робот %s сощел с дистанции\n", name);

        return onDistance;
    }

    public boolean doRun(float value) {
        maxRunDistance -= value;
        onDistance = (maxRunDistance > 0);
        if (onDistance)
            System.out.printf("Робот %s пробежал %.2f метров\n", name, value);
        else
            System.out.printf("Робот %s сощел с дистанции\n", name);

        return onDistance;
    }
}
