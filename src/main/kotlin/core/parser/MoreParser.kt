package core.parser

import model.command.Command
import model.command.more.MoreCommand
import model.path.Path
import model.path.PathProxy
import java.lang.RuntimeException

class MoreParser : Parser {
    override fun parse(command: String): Command {
        val splitCommand = command.split(" ")


        if(splitCommand.size > 2) {
            throw RuntimeException("Invalid template for cd command should be: [more %dest%]")
        }

        val destination: String = splitCommand[1]

        return MoreCommand("more",
            PathProxy(Path(destination)))
    }
}
