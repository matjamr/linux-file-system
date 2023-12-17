package core.invoker.more

import core.invoker.Invoker
import core.invoker.common.path.PathResolver2
import core.util.ConditionalFileProvider
import core.util.CreateDirProvider
import core.util.InvalidPathProvider
import model.command.*
import model.context.Context
import model.node.Catalog
import model.node.File

class MoreInvoker(
    private val pathResolver: PathResolver2
): Invoker {

    override fun run(command: Command, context: Context) {
        val touchCommand = command as MoreCommand

        val file: File = pathResolver.resolve(touchCommand.dest, context, InvalidPathProvider()) as File

        println("File content:")
        println(file.content)
    }
}
