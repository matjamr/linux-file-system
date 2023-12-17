package core.invoker.touch

import core.invoker.Invoker
import core.invoker.common.path.PathResolver2
import core.util.ConditionalFileProvider
import core.util.CreateDirProvider
import core.util.InvalidPathProvider
import model.command.*
import model.context.Context
import model.node.Catalog
import model.node.File

class TouchInvoker(
    private val pathResolver: PathResolver2
): Invoker {

    override fun run(command: Command, context: Context) {
        val touchCommand = command as TouchCommand


        for (newFileLocation in touchCommand.fileLocations) {
            val toDir: Catalog = pathResolver.resolve(newFileLocation, context, ConditionalFileProvider()) as Catalog
            toDir.childrenNodes.add(File(newFileLocation.split("/").last(), toDir, ""))
        }
    }
}
