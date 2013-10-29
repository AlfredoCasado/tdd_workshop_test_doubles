package tdd.marsrover;

import org.junit.*;

import org.jmock.Mockery;
import org.jmock.Expectations;

public class MarsRoverControlUnitJMockTest {
    
    Mockery context = new Mockery();
    
    @Test public void 
    can_move_fordward_once() {
    
        final Engine engineMock = context.mock(Engine.class);
        final MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineMock);
        
        context.checking(new Expectations() {{
            oneOf(engineMock).fordward(1);
        }});
        
        
        marsRover.move("f");
        
        context.assertIsSatisfied();
    }
}
