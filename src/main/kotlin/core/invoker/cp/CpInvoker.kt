package core.invoker.cp

import core.invoker.Invoker
import core.invoker.common.path.PathResolver2
import core.util.ConditionalFileProvider
import core.util.InvalidPathProvider
import model.context.Context
import model.command.Command
import model.command.cp.CpCommand
import model.node.Catalog
import model.node.File

class CpInvoker(
    private val pathResolver: PathResolver2
): Invoker {

    override fun run(command: Command, context: Context) {
        val cpCommand = command as CpCommand
        val fromFile: File = pathResolver.resolve(cpCommand.from.getPath(), context, InvalidPathProvider()) as File
        val toDir: Catalog = pathResolver.resolve(cpCommand.to.getPath(), context, ConditionalFileProvider()) as Catalog

        val clonedFile = fromFile.clone()

        clonedFile.setName(command.to.getLastPart())

        toDir.childrenNodes.add(clonedFile)
    }
}
