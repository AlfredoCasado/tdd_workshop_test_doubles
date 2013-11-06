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
			action.executeOn(engine)
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
			case 'f': return new MoveFordwardAction(time: time)
			case 'b': return new MoveBackwardAction(time: time)
			case 'l': return new MoveLeftAction(time: time)
			case 'r': return new MoveRightAction(time: time)
		}
	}

}

class MoveFordwardAction {
	def time
	def executeOn(engine) { engine.fordward(time) }
}

class MoveBackwardAction {
	def time
	def executeOn(engine) { engine.backward(time) }
}

class MoveLeftAction {
	def time
	def executeOn(engine) { engine.right(time) }
}

class MoveRightAction {
	def time
	def executeOn(engine) { engine.left(time) }
}