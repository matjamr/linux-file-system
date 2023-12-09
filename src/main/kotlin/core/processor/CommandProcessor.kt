package core.processor

import core.extractor.Extractor
import model.context.Context
import model.command.Command
import model.command.SupportedCommands

class CommandProcessor(
    val commandNameExtractor: Extractor<String, String>
): Processor {
    override fun process(context: Context) {
        val commandName: String = commandNameExtractor.extract(context.input)
        val supportedCommand: SupportedCommands = getCommand(commandName)
        val actualCommand: Command = supportedCommand.parser.parse(context.input)

        supportedCommand.action.run(actualCommand, context)
    }

    private fun getCommand(commandName: String): SupportedCommands {
        return SupportedCommands.values().toList().stream()
            .filter { it.commandName == commandName }
            .findFirst()
            .orElseThrow { RuntimeException("No command with given name") }

    }
}
