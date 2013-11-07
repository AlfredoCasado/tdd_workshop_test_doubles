package tdd.marsrover

class CommandProcessor {

	def actionsFactory

 	def actionsToExecute(commands, function) {
 
 		def last_command = commands[0], time = 0
 
 		commands.each { command ->
 
			if (notAMove(command)) function actionsFactory.buildActionFor(command)
 			
 			if (command != last_command) {
 				function actionsFactory.buildActionFor(last_command,time)		
 				time=0
 			}
 			
 			time++
 			last_command = command
 		}
 
 		if (isAMove(last_command)) function actionsFactory.buildActionFor(last_command, time)
 	}

	private notAMove(command) { command == 'c' }
	private isAMove(command) {command != 'c'}

}