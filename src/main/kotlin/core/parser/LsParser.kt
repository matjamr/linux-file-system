package core.parser

import model.command.Command
import model.command.LsCommand
import model.command.SupportedCommands.LS
import model.command.param.IParam
import model.command.param.Param
import java.lang.RuntimeException

class LsParser : Parser {

    override fun parse(command: String): Command {
        val actualParamNames: MutableList<IParam> = mutableListOf()
        var tmpParam: IParam? = null
        val splittedCommand: List<String> = command.split(" ")
        val preparedSplittedCommand = splittedCommand.stream()
            .skip(1)
            .toList()

        val paths: MutableList<String> = mutableListOf()
        val pathRegex = Regex("^(\\.|\\.\\.)?/?(/([a-zA-Z0-9_-]+/)*[a-zA-Z0-9_-]+/?)?\$")

        for(part: String in preparedSplittedCommand) {
            try {
                tmpParam = LS.findParamByName(part)
            } catch (e: RuntimeException) {
                if (pathRegex.matches(part)) {
                    paths.add(part)
                } else {
                    throw e
                }
            }

            actualParamNames.add(Param(tmpParam!!.getName(),
                null,
                tmpParam.getRunnable(),
                tmpParam.getDescription(),
                false
            ))
        }

        return LsCommand(
            "ls",
            actualParamNames,
            paths
        )
    }
}
