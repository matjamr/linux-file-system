package core.invoker.mv

import core.invoker.Invoker
import core.invoker.common.path.PathResolver2
import core.util.CreateDirProvider
import core.util.InvalidPathProvider
import model.command.Command
import model.command.mv.MvCommand
import model.context.Context
import model.node.Catalog

class MvInvoker(
    private val pathResolver: PathResolver2
) : Invoker {
    override fun run(command: Command, context: Context) {
        val mvCommand = command as MvCommand
        val fromNode = pathResolver.resolve(mvCommand.from.getPath(), context, InvalidPathProvider())

        var a = CreateDirProvider()
        a.from = fromNode

        val toNode = pathResolver.resolve(mvCommand.to.getPath(), context, a)
        (fromNode.getParent()!! as Catalog).remove(fromNode)
    }

}
