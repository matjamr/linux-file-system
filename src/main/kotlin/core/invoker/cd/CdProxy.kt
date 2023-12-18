package core.invoker.cd

import core.invoker.Invoker
import core.invoker.common.path.PathResolver2
import core.util.InvalidPathProvider
import model.context.Context
import model.command.cd.CdCommand
import model.command.Command
import model.node.File
import model.node.INode

class CdProxy(
    private val cdInvoker: CdInvoker,
    private val pathResolver: PathResolver2
): Invoker {

    override fun run(command: Command, context: Context) {
        val cdCommand: CdCommand = command as CdCommand



        var node: INode = pathResolver.resolve(cdCommand.dest.getPath(), context, InvalidPathProvider())

        if(node is File)
            throw RuntimeException("Cannot cd file")

        cdInvoker.run(command, context)
    }
}
