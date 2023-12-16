package core.invoker.mv

import core.invoker.Invoker
import core.invoker.common.path.PathResolver
import model.context.Context
import model.command.Command
import model.command.MvCommand
import model.node.Catalog
import model.node.File
import model.node.INode
import kotlin.RuntimeException

class MvInvoker(
    private val pathResolver: PathResolver
) : Invoker {
    override fun run(command: Command, context: Context) {
        val mvCommand = command as MvCommand
        val fromNode = pathResolver.resolve(mvCommand.from, context)

        when (fromNode) {
            is File -> {
                fromNode.setName(mvCommand.to)
            }

            is Catalog -> {
                moveCatalog(mvCommand, context, fromNode)
            }

            else -> {
                throw RuntimeException("Invalid data passed to mv")
            }
        }

    }

    private fun moveCatalog(mvCommand: MvCommand, context: Context, fromNode: INode) {

        val node: INode = try {
            pathResolver.resolve(mvCommand.to, context)
        } catch (e: RuntimeException) {
            pathResolver.resolvePathWithDirectoryCreate(mvCommand.to, context)
        }

        val childrenNodes = (fromNode.getParent() as Catalog).childrenNodes

        (node as Catalog).childrenNodes.addAll((fromNode as Catalog).childrenNodes)


        childrenNodes.remove(fromNode)
    }
}
