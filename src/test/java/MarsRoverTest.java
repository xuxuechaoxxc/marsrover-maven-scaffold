import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.api.Assertions.assertThat;


public class MarsRoverTest {

    @Test
    public void shouldLandTheRoverOnArea(){
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, Rover.EAST);
        String position = rover.getPosition();
        assertThat(position).isEqualTo("55E");
    }

    @Test
    public void shouldMoveForwardWhenDirectionToEast(){
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, Rover.EAST);
        rover.move();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("65E");
    }

    @Test
    public void shouldTurnLeft(){
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, Rover.EAST);
        rover.turnLeft();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("55N");
    }

    @Test
    public void name(){
        Rover rover = new Rover();
        RoverCon roverCon = new RoverCon();
        String mission = "10,10,5,5,E,M,L,M,R";
        String position = roverCon.excute(mission);
        assertThat(position).isEqualTo("66E");
    }

    @Rule
    public ExpectedException exceptedException = ExpectedException.none();

    @Test
    public void shouldWarningWhenLandOutOfArea(){
        exceptedException.expect(IllegalArgumentException.class);
        exceptedException.expectMessage("x=20 is out of area width 10");
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,20,30, Rover.SOUTH);
    }
}

