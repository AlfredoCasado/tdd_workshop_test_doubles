package tdd.marsrover

class EngineMoveAction {
	def time, movement, engine
	
	def execute() { engine."$movement"(time) }
}
