package core.parser

import model.command.CdCommand
import model.command.Command
import model.command.SupportedCommands.CD
import model.command.TouchCommand
import java.lang.RuntimeException
import java.util.function.Predicate

class TouchParser : Parser {
    override fun parse(command: String): Command {
        val splitCommand = command.split(" ")
            .stream()
            .skip(1)
            .toList()

        return TouchCommand("touch", splitCommand)
    }
}
