package core.invoker.cd

import core.invoker.Invoker
import core.invoker.common.path.PathResolver
import model.context.Context
import model.command.CdCommand
import model.command.Command
import model.node.Catalog

class CdInvoker(
    private val pathResolver: PathResolver
): Invoker {

    override fun run(command: Command, context: Context) {
        val cdCommand: CdCommand = command as CdCommand

        context.currentCatalog = pathResolver.resolve(cdCommand.dest, context) as Catalog
    }
}
