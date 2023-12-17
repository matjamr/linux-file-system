package core.parser

import model.command.CdCommand
import model.command.Command
import model.command.SupportedCommands.CD
import java.lang.RuntimeException
import java.util.function.Predicate

class CpParser : Parser {
    override fun parse(command: String): Command {
        val splitCommand = command.split(" ")


        if(splitCommand.size > 2) {
            throw RuntimeException("Invalid template for cd command should be: [cd %dest%]")
        }

        val destination: String = splitCommand[1]

        return CdCommand(CD.commandName,
            destination)
    }
}