package tdd.stubsample

import spock.lang.*

interface GradesRepository {
	def grades(student) 
}

class GradesEvaluator {

  def gradesRepository 

  def averageGrade(student) { 0 } 

}

class CalculateAverageGradeSpec extends Specification {
  
	def "calculate average grade"() {
      		given: 
        		def gradesRepositoryStub = Mock(GradesRepository) {
          			grades('student') >> [OOP: 8,algorithms: 6,FP: 6,databases: 10]
        		}

        		def gradesEvaluator = new GradesEvaluator(gradesRepository: gradesRepositoryStub)

  		expect: 
  			gradesEvaluator.averageGrade('student') == 7.5
  	}	

}
