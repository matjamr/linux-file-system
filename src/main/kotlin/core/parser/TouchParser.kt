package core.parser

import model.command.Command
import model.command.touch.TouchCommand
import model.path.Path
import model.path.PathProxy

class TouchParser : Parser {
    override fun parse(command: String): Command {
        val splitCommand = command.split(" ")
            .stream()
            .skip(1)
            .map { PathProxy(Path(it)) }
            .toList()

        return TouchCommand("touch", splitCommand)
    }
}
