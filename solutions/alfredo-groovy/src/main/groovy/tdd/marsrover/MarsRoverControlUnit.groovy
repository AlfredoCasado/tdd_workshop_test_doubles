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
		def commandProcessor = new CommandProcessor(commands: commands)
		commandProcessor.actions().each { actionToExcecuteOn ->
			actionToExcecuteOn(engine)
		}
	}

}

class CommandProcessor {

	def commands

	def actions() {

		def actions = []
		def last_command = commands[0]
		def time = 0

		commands.each { command ->
			if (command != last_command) {
				actions << createAction(last_command, time)
				time = 0
			} 
			
			time++
		}

		actions << createAction(last_command, time)
	}

	private createAction(command, time) {
		switch(command) {
			case 'f': return {engine -> engine.fordward(time)}
			case 'b': return {engine -> engine.backward(time)} 
			case 'l': return {engine -> engine.right(time)}
			case 'r': return {engine -> engine.left(time)}	
		}
	}
}