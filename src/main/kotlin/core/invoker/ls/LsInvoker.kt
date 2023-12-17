package core.invoker.ls

import core.invoker.Invoker
import core.invoker.common.path.PathResolver2
import core.util.InvalidPathProvider
import model.context.Context
import model.command.Command
import model.command.LsCommand
import model.node.Catalog

class LsInvoker(
    private val pathResolver: PathResolver2
) : Invoker {
    override fun run(command: Command, context: Context) {
        val lsCommand = command as LsCommand

        lsCommand.paths.stream()
            . forEach { showPath(it, context) }

    }

    private fun showPath(it: String, context: Context) {
        val tmpCatalog: Catalog = pathResolver.resolve(it, context, InvalidPathProvider()) as Catalog

        tmpCatalog.childrenNodes.stream()
            .forEach { print("\t${it.getName()}") }

        println()
    }


}
