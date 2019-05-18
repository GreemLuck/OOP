package project.Model;

public interface Hittable {
    boolean getHit(Shot shot);
    void die();
}
