package tdd.marsrover;

import java.util.List;

class MarsRoverControlUnit {
    
    private static final char NO_MOVEMENT = 'n';
	private Engine engine = null;
	private LifeDetector lifeDetector;
	List<Boolean> listLifeDetected;

	public MarsRoverControlUnit(){}
	
	
    public MarsRoverControlUnit(Engine engine, LifeDetector l) {
        this.engine = engine;
        lifeDetector = l;
    }


	public MarsRoverControlUnit(Engine engineSpy) {
		this.engine=engineSpy;
	}
	
	
	void move(String commands) {
    	char previousCommand = NO_MOVEMENT;
    	int seconds = 0;
    	for(int i = 0; i < commands.length(); i++) { 		
    		char command = commands.charAt(i);
    		if (previousCommand != NO_MOVEMENT) {
    			if (command != previousCommand) {
        			doMovement(previousCommand, seconds);
        			seconds = 0;
        		}
    		}
    		previousCommand = command;
    		seconds++; 			    		    		
    	}
    	doMovement(previousCommand, seconds);
    }

	private void doMovement(char previousCommand, int seconds) {
		if (previousCommand == 'f')
			engine.fordward(seconds);
		if (previousCommand == 'l')
			engine.left(seconds);
		if (previousCommand == 'r')
			engine.right(seconds);
		if (previousCommand == 'b')
			engine.backward(seconds);
		if(previousCommand == 'c')
			lifeDetector.detect();
	}
    
    
    
    
}
