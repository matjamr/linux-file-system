package core.parser

import model.command.Command
import model.command.ls.LsCommand
import model.command.SupportedCommands.LS
import model.command.param.IParam
import model.command.param.Param
import model.node.Catalog
import model.path.IPath
import model.path.Path
import model.path.PathProxy
import java.util.function.Predicate

class LsParser(
    private val isPathPredicate: Predicate<String>
) : Parser {

    override fun parse(command: String): Command {
        val actualParamNames: MutableList<IParam<Catalog>> = mutableListOf()
        var tmpParam: IParam<Catalog>? = null
        val splittedCommand: List<String> = command.split(" ")
        val preparedSplittedCommand = splittedCommand.stream()
            .skip(1)
            .toList()

        val paths: MutableList<IPath> = mutableListOf()

        for(part: String in preparedSplittedCommand) {
            if(part.startsWith("-")) {
                tmpParam = LS.findParamByName(part)
            } else {
                paths.add(PathProxy(Path(part)))
            }

            if(tmpParam != null) {
                actualParamNames.add(Param(
                    tmpParam.getName(),
                    null,
                    tmpParam.getRunnable(),
                    tmpParam.getDescription(),
                    false
                ))
            }

        }

        if (paths.isEmpty()) {
            paths.add(PathProxy(Path(("."))))
        }

        return LsCommand(
            "ls",
            actualParamNames,
            paths
        )
    }
}
