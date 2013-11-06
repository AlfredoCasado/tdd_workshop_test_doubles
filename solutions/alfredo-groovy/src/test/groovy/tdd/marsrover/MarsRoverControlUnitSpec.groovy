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

}