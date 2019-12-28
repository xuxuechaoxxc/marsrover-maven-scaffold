public class RoverCon {
    public String excute(String mission) {
        Rover rover = new Rover();
        String[] commands = mission.split(",");
        int areaWith = Integer.parseInt(commands[0]);
        int areaHeight = Integer.parseInt(commands[1]);
        int x = Integer.parseInt(commands[2]);
        int y = Integer.parseInt(commands[3]);
        Area area = new Area(areaWith, areaHeight);
        for (int i = 4; i < commands.length; i++) {
            if (commands[i].equals("L")) {
                rover.turnLeft();
            }
            if (commands[i].equals("R")) {
                rover.turnRight();
            }
            if (!commands[i].equals("L") && !commands[i].equals("R") && !commands[i].equals("M")) {
                rover.land(area, x, y, commands[i]);
            }
            if (commands[i].equals("M")) {
                rover.move();
            }
        }
            return rover.getPosition();
        }
    }
