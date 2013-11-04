
package tdd.marsrover;

import org.junit.*;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MarsRoverControlUnitMockitoTest {
    
    @Test public void 
    can_move_fordward_once() {
    
        Engine engineSpy = mock(Engine.class);
        MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineSpy);
        
        marsRover.move("f");
        
        verify(engineSpy).fordward(1);
        
    }
    
    @Test public void 
    can_move_right_once() {
        Engine engineSpy = mock(Engine.class);
        MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineSpy);
        
        marsRover.move("l");
        
        verify(engineSpy).left(1);
   	
    }
    
    @Test public void 
    can_move_forward_twice() {
        Engine engineSpy = mock(Engine.class);
        MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineSpy);
        
        marsRover.move("ff");
        
        verify(engineSpy).fordward(2);
    }
    
    @Test public void 
    can_move_left_once() {
        Engine engineSpy = mock(Engine.class);
        MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineSpy);
        
        marsRover.move("r");
        
        verify(engineSpy).right(1);
    }
    
    
    @Test public void 
    can_move_back_once() {
        Engine engineSpy = mock(Engine.class);
        MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineSpy);
        
        marsRover.move("b");
        
        verify(engineSpy).backward(1);
    }
    
    @Test public void 
    can_group_movements() {
  
        Engine engineSpy = mock(Engine.class);
        InOrder order = Mockito.inOrder(engineSpy);
        
        MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineSpy, null);
               
        marsRover.move("fffll");

        order.verify(engineSpy).fordward(3);
        order.verify(engineSpy).left(2);
    }
    
    @Test public void 
    can_detect_life() {
  
        Engine engineSpy = mock(Engine.class);
        Engine engineSpy2 = mock(Engine.class);
        LifeDetector lifeDectectorSpy = mock(LifeDetector.class);
        
        MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineSpy, lifeDectectorSpy);
               
        marsRover.move("fffcll");

        InOrder order = Mockito.inOrder(engineSpy);
        order.verify(engineSpy).fordward(3);
        //order.verify(lifeDectectorSpy).detect();
        order.verify(engineSpy).left(2);
    }
}
