package tdd.marsrover;

import org.junit.*;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.jmock.Sequence;

public class MarsRoverControlUnitJMockTest {
    Mockery context = new Mockery();
    Sequence sequence = context.sequence("seq");
    
    @Test public void 
    can_move_once_b() {
        final Engine engineMock = context.mock(Engine.class);
        final Sensor sensorMock =context.mock(Sensor.class);
        final MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineMock, sensorMock);
        
        context.checking(new Expectations() {{
            oneOf(engineMock).backward(1); 
        	
        }});
        
        marsRover.move("b");

        
        context.assertIsSatisfied();
    }
    
    @Test public void 
    can_move_once_f() {
        final Engine engineMock = context.mock(Engine.class);
        final Sensor sensorMock =context.mock(Sensor.class);
        final MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineMock, sensorMock);
        
        context.checking(new Expectations() {{
            oneOf(engineMock).fordward(1);         	
        }});
        
        marsRover.move("f");

        
        context.assertIsSatisfied();
    }
    @Test public void 
    can_move_once_l() {
        final Engine engineMock = context.mock(Engine.class);
        final Sensor sensorMock =context.mock(Sensor.class);
        final MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineMock, sensorMock);
        
        context.checking(new Expectations() {{
            oneOf(engineMock).left(1); 
        	
        }});
        
        marsRover.move("l");

        
        context.assertIsSatisfied();
    }
    @Test public void 
    can_move_once_r() {
        final Engine engineMock = context.mock(Engine.class);
        final Sensor sensorMock =context.mock(Sensor.class);
        final MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineMock, sensorMock);
        
        context.checking(new Expectations() {{
            oneOf(engineMock).right(1); 
        	
        }});
        marsRover.move("r");
        context.assertIsSatisfied();
    }
    
    @Test public void 
    can_move_twice_f() {
        final Engine engineMock = context.mock(Engine.class);
        final Sensor sensorMock =context.mock(Sensor.class);
        final MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineMock, sensorMock);
        
        context.checking(new Expectations() {{
            oneOf(engineMock).fordward(2); 
        }});
        marsRover.move("ff");
        context.assertIsSatisfied();
    }
    
    @Test public void 
    can_move_twice_fb() {
        final Engine engineMock = context.mock(Engine.class);
        final Sensor sensorMock =context.mock(Sensor.class);
        final MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineMock, sensorMock);
        
        context.checking(new Expectations() {{
            oneOf(engineMock).fordward(2); 
            oneOf(engineMock).backward(2); 
        }});
        marsRover.move("ffbb");
        context.assertIsSatisfied();
    }
    
    @Test public void 
    can_move_twice_lr() {
        final Engine engineMock = context.mock(Engine.class);
        final Sensor sensorMock =context.mock(Sensor.class);
        final MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineMock, sensorMock);
        
        context.checking(new Expectations() {{
            oneOf(engineMock).left(2); 
            oneOf(engineMock).right(2); 
        }});
        marsRover.move("llrr");
        context.assertIsSatisfied();
    }
    
    @Test public void 
    can_move_twice_lrlr() {
        final Engine engineMock = context.mock(Engine.class);
        final Sensor sensorMock =context.mock(Sensor.class);
        final MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineMock, sensorMock);
        
        context.checking(new Expectations() {{
            oneOf(engineMock).left(2); 
            oneOf(engineMock).right(2);
            oneOf(engineMock).left(2); 
            oneOf(engineMock).right(2);
        }});
        marsRover.move("llrrllrr");
        context.assertIsSatisfied();
    }
    
    @Test public void 
    can_move_twice_lrlr_otherorder() {
        final Engine engineMock = context.mock(Engine.class);
        final Sensor sensorMock =context.mock(Sensor.class);
        final MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineMock, sensorMock);
        
        context.checking(new Expectations() {{
            oneOf(engineMock).left(2); inSequence(sequence); 
            oneOf(engineMock).right(2); inSequence(sequence);
            oneOf(engineMock).left(2); inSequence(sequence);
            oneOf(engineMock).right(2); inSequence(sequence);
        }});
        marsRover.move("llrrllrr");
        context.assertIsSatisfied();
    }
    
    @Test public void 
    empty_commands() {
        final Engine engineMock = context.mock(Engine.class);
        final Sensor sensorMock =context.mock(Sensor.class);
        final MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineMock, sensorMock);
        marsRover.move("");
        context.assertIsSatisfied();
    }
    
    @Test public void 
    invalid_commands() {
        final Engine engineMock = context.mock(Engine.class);
        final Sensor sensorMock =context.mock(Sensor.class);
        final MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineMock, sensorMock);
        marsRover.move("jjxx");
        context.assertIsSatisfied();
    }
    
    @Test public void 
    detect_life_2_times() {
        final Engine engineMock = context.mock(Engine.class);
        final Sensor sensorMock =context.mock(Sensor.class);
        final MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineMock, sensorMock);
        
        context.checking(new Expectations() {{
            oneOf(engineMock).left(2); inSequence(sequence); 
            oneOf(engineMock).right(2); inSequence(sequence);
            oneOf(sensorMock).detect(); inSequence(sequence);
            oneOf(engineMock).left(2); inSequence(sequence);
            oneOf(engineMock).right(2); inSequence(sequence);
            oneOf(sensorMock).detect(); inSequence(sequence);
        }});
        marsRover.move("llrrcllrrc");
        context.assertIsSatisfied();
    }

}
