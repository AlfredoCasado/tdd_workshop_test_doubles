package tdd.marsrover

interface Engine {
    
    def left(time)
    def right(time)
    def fordward(time)
    def backward(time)
    
} 

class MarsRoverControlUnit {

	def engine

	def move(commands) {
		if ( commands == "f") engine.fordward(1)
		else if ( commands == "l") engine.right(1)
		else engine.backward(1)
	}

}