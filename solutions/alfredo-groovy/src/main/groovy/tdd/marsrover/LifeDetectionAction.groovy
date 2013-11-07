package tdd.marsrover

class LifeDetectionAction {
	def lifeDetector, positionSystem

	def execute() {
		if (lifeDetector.detect()) positionSystem.currentPosition()
	}
}