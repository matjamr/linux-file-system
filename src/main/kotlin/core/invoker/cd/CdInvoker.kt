package core.invoker.cd

import core.invoker.Invoker
import core.invoker.common.path.PathResolver2
import core.util.InvalidPathProvider
import model.context.Context
import model.command.CdCommand
import model.command.Command
import model.node.Catalog

class CdInvoker(
    private val pathResolver: PathResolver2
): Invoker {

    override fun run(command: Command, context: Context) {
        val cdCommand: CdCommand = command as CdCommand

        context.currentNode = pathResolver.resolve(cdCommand.dest, context, InvalidPathProvider())
    }
}
