package tdd.marsrover

interface LifeDetector { def detect() }
interface PositionSystem {def currentPosition() }
interface Engine {
    
    def left(time)
    def right(time)
    def fordward(time)
    def backward(time)
    
} 

class MarsRoverControlUnit {

	def static createWith(engine, lifeDetector, positionSystem) {
		
		new MarsRoverControlUnit(
			
			commandProcessor: new CommandProcessor(
				
				actionsFactory: new ActionsFactory(
					engine: engine,
					positionSystem: positionSystem,
					lifeDetector: lifeDetector
				)

			)
		)
	
	}
	
	def commandProcessor
	
	def move(theCommands) {
		def detectedsLifeForms = []
		
		commandProcessor.actionsToExecute(theCommands) { action ->
			def positionOfLifeForm = action.execute()
			
			if (positionOfLifeForm) 
				detectedsLifeForms << positionOfLifeForm
		}

		return detectedsLifeForms
	}

}

class CommandProcessor {

	def actionsFactory

	def actionsToExecute(commands, function) {

		def last_command = commands[0], time = 0

		commands.each { command ->

			if (notAMove(command)) function actionsFactory.buildActionFor(command)
			
			if (command != last_command) {
				function actionsFactory.buildActionFor(last_command,time)		
				time=0
			}
			
			time++
			last_command = command
		}

		if (isAMove(last_command)) function actionsFactory.buildActionFor(last_command, time)
	}

	private notAMove(command) { command == 'c' }
	private isAMove(command) {command != 'c'}

}

class ActionsFactory {

	def engine
	def lifeDetector
	def positionSystem
	
	def buildActionFor(command, time=0) {
		switch(command) {
			case 'f': return createEngineMovement('fordward', time)
			case 'b': return createEngineMovement('backward', time)
			case 'l': return createEngineMovement('right', time)
			case 'r': return createEngineMovement('left', time)
			case 'c': return new LifeDetectionAction(positionSystem: positionSystem, lifeDetector: lifeDetector)
			default: throw new RuntimeException("no action associated with command: $command")
		}
	}

	private createEngineMovement(movement, time) {
		new EngineMoveAction(engine: engine, time: time, movement: movement)
	}

}

class LifeDetectionAction {
	def lifeDetector, positionSystem

	def execute() {
		if (lifeDetector.detect()) positionSystem.currentPosition()
	}
}

class EngineMoveAction {
	def time, movement, engine
	
	def execute() { engine."$movement"(time) }
}
