import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;


public class MarsRoverTest {
    @Test
    public void shouldLandTheRoverOnArea(){
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "E");
        String position = rover.getPosition();
        assertThat(position).isEqualTo("55E");
    }

    @Test
    public void shouldMoveForward(){
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "E");
        rover.move();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("65E");
    }

    @Test
    public void name(){
        Rover rover = new Rover();
        RoverCon roverCon = new RoverCon();
        String mission = "10,10,5,5,E,M,L,M,R";
        String position = roverCon.excute(mission);
        assertThat(position).isEqualTo("66E");
    }
}
