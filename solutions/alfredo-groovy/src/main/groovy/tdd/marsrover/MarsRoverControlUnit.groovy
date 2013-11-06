package tdd.marsrover

interface Engine {
    
    def left(time)
    def right(time)
    def fordward(time)
    def backward(time)
    
} 

class MarsRoverControlUnit {

	def commandProcessor = new CommandProcessor()
	def engine

	def move(theCommands) {
		commandProcessor.actionsToExecute(theCommands) { action ->
			action(engine)
		}
	}

}

class CommandProcessor {

	def actionsFactory = new ActionsFactory()

	def actionsToExecute(commands, function) {

		def last_command = commands[0]
		def time = 0

		commands.each { command ->
			if (command != last_command) {
				function actionsFactory.buildActionFor(last_command, time)
				time = 0
			} 
			
			time++
		}

		function actionsFactory.buildActionFor(last_command, time)
	}

}

class ActionsFactory {
	
	def buildActionFor(command, time) {
		switch(command) {
			case 'f': return {engine -> engine.fordward(time)}
			case 'b': return {engine -> engine.backward(time)} 
			case 'l': return {engine -> engine.right(time)}
			case 'r': return {engine -> engine.left(time)}	
		}
	}

}