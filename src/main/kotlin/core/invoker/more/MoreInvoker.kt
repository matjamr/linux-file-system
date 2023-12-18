package core.invoker.more

import core.invoker.Invoker
import core.invoker.common.path.PathResolver2
import core.util.InvalidPathProvider
import model.command.*
import model.command.more.MoreCommand
import model.context.Context
import model.node.File

class MoreInvoker(
    private val pathResolver: PathResolver2
): Invoker {

    override fun run(command: Command, context: Context) {
        val touchCommand = command as MoreCommand

        val file: File = pathResolver.resolve(touchCommand.dest.getPath(), context, InvalidPathProvider()) as File

        println("File content:")
        println(file.content)
    }
}
