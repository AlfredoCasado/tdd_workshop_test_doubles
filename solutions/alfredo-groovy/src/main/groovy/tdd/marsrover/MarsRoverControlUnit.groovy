package tdd.marsrover

interface Engine {
    
    def left(time)
    def right(time)
    def fordward(time)
    def backward(time)
    
} 

class MarsRoverControlUnit {

	def engine

	def actions = [
		"f": {engine.fordward(1)},
		"b": {engine.backward(1)},
		"l": {engine.right(1)},
		"r": {engine.left(1)}
	]

	def move(commands) {
		actions[commands]()
	}

}