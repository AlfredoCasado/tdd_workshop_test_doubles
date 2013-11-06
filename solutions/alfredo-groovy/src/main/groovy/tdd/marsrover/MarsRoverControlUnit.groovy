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
		
		commandProcessor.forEachAction { actionToExcecuteOn ->
			actionToExcecuteOn(engine)
		}
	}

}

class CommandProcessor {

	def commands

	def forEachAction(function) {

		def last_command = commands[0]
		def time = 0

		commands.each { command ->
			if (command != last_command) {
				function createAction(last_command, time)
				time = 0
			} 
			
			time++
		}

		function createAction(last_command, time)
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