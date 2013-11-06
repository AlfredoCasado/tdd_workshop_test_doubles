package tdd.marsrover

import spock.lang.*

class MarsRoverControlUnitSpec extends Specification {

	def engineSpy = Mock(Engine)
	def marsRover = MarsRoverControlUnit.createWith(engineSpy)

	@Unroll
	def "can move in direction specified by command #command once"() {
		when: marsRover.move(command)
		then: 
			1 * engineSpy."$method_expected_to_be_called_on_engine"(1)
			0 * engineSpy._

		where:
			command 	| method_expected_to_be_called_on_engine
			
			"f"			| "fordward"
			"b"			| "backward"
			"l"			| "right"
			"r"			| "left"
	}

	@Unroll
	def "can move several times in one direction using command: #command"() {
		when: marsRover.move(command)
		then: 
			1 * engineSpy."$method_expected_to_be_called_on_engine"(command.length())
			0 * engineSpy._

		where:
		command 		| method_expected_to_be_called_on_engine
			
		"ff"			| "fordward"
		"bbb"			| "backward"
		"lll"			| "right"
		"rrrr"			| "left"
	}

	def "can move fordward and then left"() {
		when: marsRover.move("fl")
		then: 1 * engineSpy.fordward(1)
		then: 1 * engineSpy.right(1)
	}	

	def "can move fordward twice and then left twice"() {
		when: marsRover.move("ffll")
		then: 1 * engineSpy.fordward(2)
		then: 1 * engineSpy.right(2)
	}	

	def "can move complex moves"() {
		when: marsRover.move("fffllbbbrr")
		then: 1 * engineSpy.fordward(3)
		then: 1 * engineSpy.right(2)
		then: 1 * engineSpy.backward(3)
		then: 1 * engineSpy.left(2)
	}	


}