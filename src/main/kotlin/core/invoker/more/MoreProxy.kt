package core.invoker.more

import core.invoker.Invoker
import core.invoker.common.path.PathResolver2
import core.util.InvalidPathProvider
import model.command.*
import model.command.more.MoreCommand
import model.command.mv.MvCommand
import model.context.Context
import model.node.Catalog
import model.node.File
import model.node.INode

class MoreProxy(
    private val moreInvoker: MoreInvoker,
    private val pathResolver: PathResolver2
): Invoker {

    override fun run(command: Command, context: Context) {
        if(command !is MoreCommand)
            throw RuntimeException("Unknown error occured")

        val file: INode = pathResolver.resolve(command.dest.getPath(), context, InvalidPathProvider())

        if(file is Catalog) {
            throw RuntimeException("You can only more file")
        }

        moreInvoker.run(command, context)
    }
}
