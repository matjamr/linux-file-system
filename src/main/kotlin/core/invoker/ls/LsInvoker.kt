package core.invoker.ls

import core.invoker.Invoker
import core.invoker.common.path.PathResolver2
import core.util.InvalidPathProvider
import model.context.Context
import model.command.Command
import model.command.ls.LsCommand
import model.node.Catalog
import model.path.IPath

class LsInvoker(
    private val pathResolver: PathResolver2
) : Invoker {
    override fun run(command: Command, context: Context) {
        val lsCommand = command as LsCommand

        lsCommand.paths.stream()
            . forEach { showPath(it, context) }

    }

    private fun showPath(it: IPath, context: Context) {
        val tmpCatalog: Catalog = pathResolver.resolve(it.getPath(), context, InvalidPathProvider()) as Catalog

        println("$tmpCatalog")
        tmpCatalog.childrenNodes.stream()
            .forEach { println("\t${it.getName()}") }

        println()
    }


}
