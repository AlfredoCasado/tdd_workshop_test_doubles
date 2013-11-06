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

	def engine
	
	def buildActionFor(command, time) {
		switch(command) {
			case 'f': return new EngineMoveAction(engine: engine, time: time, movement: 'fordward')
			case 'b': return new EngineMoveAction(engine: engine, time: time, movement: 'backward')
			case 'l': return new EngineMoveAction(engine: engine, time: time, movement: 'right')
			case 'r': return new EngineMoveAction(engine: engine, time: time, movement: 'left')
		}
	}

}

class EngineMoveAction {
	def time, movement, engine
	
	def execute() { engine."$movement"(time) }
}
