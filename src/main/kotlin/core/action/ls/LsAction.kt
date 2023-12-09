package core.action.ls

import core.action.IAction
import core.action.common.path.PathResolver
import model.context.Context
import model.command.Command
import model.command.LsCommand
import model.node.Catalog

class LsAction(
    private val pathResolver: PathResolver
) : IAction {
    override fun run(command: Command, context: Context) {
        val lsCommand = command as LsCommand

        lsCommand.paths.stream()
            . forEach { showPath(it, context) }

    }

    private fun showPath(it: String, context: Context) {
        val tmpCatalog: Catalog = pathResolver.resolve(it, context) as Catalog

        tmpCatalog.childrenNodes.stream()
            .forEach { print("\t${it.getName()}") }

        println()
    }


}
