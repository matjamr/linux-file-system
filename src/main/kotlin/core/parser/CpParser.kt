package core.parser

import model.command.cd.CdCommand
import model.command.Command
import model.command.SupportedCommands.CD
import model.path.Path
import model.path.PathProxy
import java.lang.RuntimeException

class CpParser : Parser {
    override fun parse(command: String): Command {
        val splitCommand = command.split(" ")

        if(splitCommand.size > 2) {
            throw RuntimeException("Invalid template for cd command should be: [cd %dest%]")
        }

        val destination: String = splitCommand[1]

        return CdCommand(CD.commandName,
            PathProxy(Path(destination)))
    }
}
