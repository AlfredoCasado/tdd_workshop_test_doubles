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
		'f': {time -> engine.fordward(time)},
		'b': {time -> engine.backward(time)},
		'l': {time -> engine.right(time)},
		'r': {time -> engine.left(time)}
	]

	def move(commands) {

		def last_command = commands[0]
		def time = 0

		commands.each { command ->
			if (command != last_command) {
				actions[last_command](time)
				time = 0
			} else {
				time++
			}
		}

		actions[last_command](time)

	}



	

}