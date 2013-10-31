package tdd.samples;


import org.junit.Test;
import static org.mockito.Mockito.*;

public class DomoticSystemMockitoTest {
    
    
    @Test
    public void test_activate_security() {
        
        WindowController windowSpy = mock(WindowController.class);
        DoorsController doorsSpy = mock(DoorsController.class);
        
        DomoticSystem domotic = new DomoticSystem(windowSpy, doorsSpy);
        domotic.activateSecurity();
        
        verify(windowSpy).close();
        verify(doorsSpy).close();
        
    }
    
}
