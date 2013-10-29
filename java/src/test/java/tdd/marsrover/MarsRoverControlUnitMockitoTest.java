
package tdd.marsrover;

import org.junit.*;
import static org.mockito.Mockito.*;

public class MarsRoverControlUnitMockitoTest {
    
    @Test public void 
    can_move_fordward_once() {
    
        Engine engineSpy = mock(Engine.class);
        MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineSpy);
        
        marsRover.move("f");
        
        verify(engineSpy).fordward(1);
        
    }
}
