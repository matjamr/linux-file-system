package core.invoker.cp

import core.invoker.Invoker
import core.invoker.common.path.PathResolver2
import core.util.ConditionalFileProvider
import core.util.CreateDirProvider
import core.util.InvalidPathProvider
import model.context.Context
import model.command.CdCommand
import model.command.Command
import model.command.CpCommand
import model.command.MvCommand
import model.node.Catalog
import model.node.File

class CpInvoker(
    private val pathResolver: PathResolver2
): Invoker {

    override fun run(command: Command, context: Context) {
        val cpCommand = command as CpCommand
        val fromFile: File = pathResolver.resolve(cpCommand.from, context, InvalidPathProvider()) as File
        val toDir: Catalog = pathResolver.resolve(cpCommand.to, context, ConditionalFileProvider()) as Catalog

        val clonedFile = fromFile.clone()

        clonedFile.setName(command.to.split("/").last())

        toDir.childrenNodes.add(clonedFile)
    }
}
