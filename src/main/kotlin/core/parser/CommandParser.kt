package core.parser

import core.dispatcher.Dispatcher
import core.parser.extractor.Extractor
import model.command.Command
import model.command.action.IAction
import model.command.param.IParam

class CommandParser(
    val nameExtractor: Extractor<String, String>,
    val paramsExtractor: Extractor<List<IParam>, String>,
    val actionDispatcher: Dispatcher
): Parser {
    override fun parse(command: String): Command {
        val commandName: String = nameExtractor.extract(command)

        return Command(
            commandName,
            paramsExtractor.extract(command),
            actionDispatcher.dispatch(commandName)
        )
    }
}
