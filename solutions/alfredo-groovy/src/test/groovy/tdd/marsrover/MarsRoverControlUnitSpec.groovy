package tdd.marsrover

import spock.lang.*

class MarsRoverControlUnitSpec extends Specification {

	def engineSpy = Mock(Engine)
	def marsRover = new MarsRoverControlUnit(engine: engineSpy)


	def "can move fordward once"() {
		when: marsRover.move("f")
		then: 1 * engineSpy.fordward(1)
	}

	def "can move backward once"() {
		when: marsRover.move("b")
		then: 1 * engineSpy.backward(1)
	}

}