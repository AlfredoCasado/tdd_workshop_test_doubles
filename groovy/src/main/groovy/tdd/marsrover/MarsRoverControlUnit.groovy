package tdd.marsrover

interface Engine {
    
    def left(time)
    def right(time)
    def fordward(time)
    def backward(time);
    
} 

class MarsRoverControlUnit {

	def engine

	def move(commands) {
		throw new UnsupportedOperationException("Not yet implemented")
	}

}