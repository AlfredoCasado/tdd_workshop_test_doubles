package tdd.marsrover

class MarsRoverBuilder {

	def static aMarsRover() { new MarsRoverBuilder() }

	def engine, lifeDetector, positionSystem

	def withEngine(engine) {
		this.engine = engine
		return this
	}
	
	def withLifeDetector(lifeDetector) {
		this.lifeDetector = lifeDetector
		return this
	}
	
	def withPositionSystem(positionSystem) {
		this.positionSystem = positionSystem
		return this
	}

	def build() {
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
}