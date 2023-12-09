package core.action.cd

import core.action.IAction
import core.action.common.path.PathResolver
import model.context.Context
import model.command.CdCommand
import model.command.Command
import model.node.Catalog

class CdAction(
    private val pathResolver: PathResolver
): IAction {

    override fun run(command: Command, context: Context) {
        val cdCommand: CdCommand = command as CdCommand

        context.currentCatalog = pathResolver.resolve(cdCommand.dest, context) as Catalog
    }
}
