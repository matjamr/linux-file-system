package input

import core.parser.Parser
import model.command.Command

class ActionInputHandler(
    val commandParser: Parser
): InputHandler<Command> {
    override fun getInput(): Command {
        val stringInput:String = readln()
        val command: Command = commandParser.parse(stringInput)

        return null!!
    }
}
