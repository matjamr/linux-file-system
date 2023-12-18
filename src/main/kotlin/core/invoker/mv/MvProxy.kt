package core.invoker.mv

import core.invoker.Invoker
import core.invoker.common.path.PathResolver2
import core.util.InvalidPathProvider
import model.command.Command
import model.command.mv.MvCommand
import model.command.touch.TouchCommand
import model.context.Context
import model.node.File

class MvProxy(private val mvInvoker: MvInvoker, private val pathResolver: PathResolver2): Invoker {
    override fun run(command: Command, context: Context) {

        if(command !is MvCommand)
            throw RuntimeException("Unknown error occured")

        val node = pathResolver.resolve(command.from.getPath(), context, InvalidPathProvider())

        var errorThrown = true
        try {
            val toNode = pathResolver.resolve(command.to.getPath(), context, InvalidPathProvider())
            errorThrown = false
        } catch (e: RuntimeException) {
            errorThrown = true
        } finally {
            if(!errorThrown) {
                throw RuntimeException("Node with given name already exists")
            }
        }

        mvInvoker.run(command, context)
    }
}
