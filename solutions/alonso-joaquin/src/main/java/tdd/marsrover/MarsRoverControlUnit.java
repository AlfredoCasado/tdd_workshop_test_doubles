package tdd.marsrover;

import java.util.LinkedList;
import java.util.List;

class MarsRoverControlUnit {
    
    private final Engine engine;
    private final Sensor sensor;

    public MarsRoverControlUnit(Engine engine, Sensor sensor) {
        this.engine = engine;
        this.sensor = sensor;
    }

 
    void move(String commands) {
    	List<Par> result = generaPares(commands);
    	for(Par curPar: result) {
    		char curCommand = curPar.cadena;
    		int sum = curPar.numero;
    		
	    	if (curCommand == 'f') {
	    		engine.fordward(sum);
	    	} 
	    	if (curCommand == 'b') {
	    		engine.backward(sum);
	    	} 
	    	if (curCommand == 'l') {
	    		engine.left(sum);
	    	} 
	    	if (curCommand == 'r') {
	    		engine.right(sum);
	    	} 
    	}
    }
    
    private static class Par {
    	private char cadena;
    	private int numero;
    	
    	Par(char cadena, int numero){
    		this.cadena = cadena;
    		this.numero = numero;
    	}
    }
    
    private List<Par> generaPares(String cadena) {
    	String auxCadena = cadena;
    	List<Par> result = new LinkedList<Par>();
    	Par curPar = new Par('\0', 0);
    	
    	if (cadena.length() > 0) {
	    	do {
	    		char curChar = auxCadena.charAt(0);
	    		auxCadena = auxCadena.substring(1);
	    		
	    		if (curChar == curPar.cadena) {
	    			curPar.numero ++;
	    		} else {
	    			result.add(curPar);
	    			curPar = new Par(curChar, 1);
	    		}
	    		
	    	} while(auxCadena.length() > 0);
	    	
	    	result.add(curPar);
    	}
    	return result;
    }
    
    
    
    
    
}
