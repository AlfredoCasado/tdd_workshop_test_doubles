package tdd.marsrover

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
			if (positionOfLifeForm) detectedsLifeForms << positionOfLifeForm
		}

		return detectedsLifeForms
	}

}