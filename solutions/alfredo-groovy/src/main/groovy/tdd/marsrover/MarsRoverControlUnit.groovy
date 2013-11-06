package tdd.marsrover

interface Engine {
    
    def left(time)
    def right(time)
    def fordward(time)
    def backward(time)
    
} 

class MarsRoverControlUnit {

	def static createWith(engine) {
		new MarsRoverControlUnit(
			commandProcessor: new CommandProcessor(
				actionsFactory: new ActionsFactory(engine: engine)
			)
		)
	}
	
	def commandProcessor
	
	def move(theCommands) {
		commandProcessor.actionsToExecute(theCommands) { action ->
			action.execute()
		}
	}

}

class CommandProcessor {

	def actionsFactory

	def actionsToExecute(commands, function) {

		def last_command = commands[0], time = 0

		commands.each { command ->
			if (command != last_command) {
				function actionsFactory.buildActionFor(last_command, time)
				time = 0
			} 
			
			time++
			last_command = command
		}

		function actionsFactory.buildActionFor(last_command, time)
	}

}

class ActionsFactory {

	def engine
	
	def buildActionFor(command, time) {
		switch(command) {
			case 'f': return createEngineMovement('fordward', time)
			case 'b': return createEngineMovement('backward', time)
			case 'l': return createEngineMovement('right', time)
			case 'r': return createEngineMovement('left', time)
		}
	}

	private createEngineMovement(movement, time) {
		new EngineMoveAction(engine: engine, time: time, movement: movement)
	}

}

class EngineMoveAction {
	def time, movement, engine
	
	def execute() { engine."$movement"(time) }
}
