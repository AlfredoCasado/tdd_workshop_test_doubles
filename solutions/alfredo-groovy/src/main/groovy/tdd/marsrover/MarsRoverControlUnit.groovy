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
		'f': "fordward",
		'b': "backward",
		'l': "right",
		'r': "left"
	]

	def move(commands) {

		def last_command = commands[0]
		def time = 0

		commands.each { command ->
			if (command != last_command) {
				def action createAction(actions[command], time)
				action.call()
				time = 0
			} else {
				time++
			}
		}

		actions[last_command](time)
	}

	private createCommand(movement, time) {
		return {
			engine."$movement"(time)
		}
	}

}