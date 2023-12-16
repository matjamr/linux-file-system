package core.parser

import model.command.Command
import model.command.MvCommand
import model.command.SupportedCommands
import java.lang.RuntimeException

class MvParser : Parser {
    override fun parse(command: String): Command {
        val splittedCommand: List<String> = command.split(" ")

        val preparedSplittedCommand = splittedCommand.stream()
            .skip(1)
            .toList();

        if(preparedSplittedCommand.size < 2) {
            throw RuntimeException("Invalid path exception")
        }

        val from = preparedSplittedCommand[0]
        val to = preparedSplittedCommand[1]

        return MvCommand(
            "mv",
            from,
            to
        )
    }
}
