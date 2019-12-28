public class Rover {
    private String e;
    private Area area;

    public void land(Area area, int x, int y, String e) {
        this.e = e;
        area.setX(x);
        area.setY(y);
        this.area = area;
    }

    public String getPosition() {
        return ""+ area.getX() + "" + area.getY() + "" + e;
    }

    public void move() {
    }
}
