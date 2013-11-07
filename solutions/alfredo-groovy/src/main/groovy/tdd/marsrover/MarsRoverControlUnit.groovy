package tdd.marsrover

class MarsRoverControlUnit {

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