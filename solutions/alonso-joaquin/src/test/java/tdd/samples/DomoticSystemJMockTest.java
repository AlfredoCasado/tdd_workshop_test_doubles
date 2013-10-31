package tdd.samples;

import org.junit.Test;

import org.jmock.Mockery;
import org.jmock.Expectations;

public class DomoticSystemJMockTest {
    
    Mockery context = new Mockery();
    
    @Test
    public void test_activate_security() {
        
        final WindowController windowMock = context.mock(WindowController.class);
        final DoorsController doorsMock = context.mock(DoorsController.class);
        
        context.checking(new Expectations() {{
            oneOf(windowMock).close();
            oneOf(doorsMock).close();
        }});
        
        DomoticSystem domotic = new DomoticSystem(windowMock, doorsMock);
        
        domotic.activateSecurity();
        
        context.assertIsSatisfied();
    }
    
}
