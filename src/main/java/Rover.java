public class Rover {
    public static final String EAST = "E";
    public static final String NORTH = "N";
    public static final String WEST = "W";
    public static final String SOUTH = "S";
    private String e;
    private Area area;
    public void land(Area area, int x, int y, String e) {
        if (x > area.getX()) {
            throw new IllegalArgumentException("x=" + x + " is out of area width " + area.getX());
        }
        if (y > area.getY()) {
            throw new IllegalArgumentException("y=" + y + " is out of area height " + area.getY());
        }
        this.e = e;
        area.setX(x);
        area.setY(y);
        this.area = area;
    }

    public String getPosition() {
        return String.format("%d%d%s", area.getX(), area.getY(), e);
    }

    public void move() {
        if (this.e.equals("E")) {
            area.setX(area.getX() + 1);
        }
        if (this.e.equals("W")) {
            area.setX(area.getX() - 1);
        }
        if (this.e.equals("N")) {
            area.setY(area.getY() + 1);
        }
        if (this.e.equals("S")) {
            area.setY(area.getY() - 1);
        }
    }

    public void turnLeft() {
        if (e.equals(EAST)) {
            e = NORTH;
        } else if (e.equals(NORTH)) {
            e = WEST;
        } else if (e.equals(WEST)) {
            e = SOUTH;
        } else if (e.equals(SOUTH)) {
            e = EAST;
        }
        return;
    }
    public void turnRight() {
        if (e.equals(EAST)) {
            e = SOUTH;
        } else if (e.equals(SOUTH)) {
            e = WEST;
        } else if (e.equals(WEST)) {
            e = NORTH;
        } else if (e.equals(NORTH)) {
            e = EAST;
        }
        return;
    }
}
