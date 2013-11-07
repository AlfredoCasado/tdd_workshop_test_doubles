package tdd.marsrover

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