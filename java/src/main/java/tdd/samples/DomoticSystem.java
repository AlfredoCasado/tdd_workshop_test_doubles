package tdd.samples;

interface WindowController {
    public void close();
}

interface DoorsController {
    public void close();
}

class DomoticSystem {
    
    private WindowController windows;
    private DoorsController doors;
    
    public DomoticSystem(WindowController windows, DoorsController doors) {
        this.windows = windows;
        this.doors = doors;
    }
            
    public void activateSecurity() {
        doors.close();
        windows.close();
    }
}
