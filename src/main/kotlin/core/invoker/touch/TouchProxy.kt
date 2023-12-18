package core.invoker.touch

import core.invoker.Invoker
import core.invoker.common.path.PathResolver2
import core.util.ConditionalFileProvider
import model.command.Command
import model.command.touch.TouchCommand
import model.context.Context
import model.node.Catalog
import model.node.File
import model.node.INode
import java.util.*

class TouchProxy(private val touchInvoker: TouchInvoker, private val pathResolver: PathResolver2): Invoker {
    override fun run(command: Command, context: Context) {
        checkIfValid(command, context)
        touchInvoker.run(command, context)
    }

    private fun checkIfValid(command: Command, context: Context) {
        if(command !is TouchCommand)
            throw RuntimeException("Unknown error occured")


        for (newFileLocation in command.fileLocations) {
            val toDir: INode = pathResolver.resolve(newFileLocation.getPath(), context, ConditionalFileProvider())

            if(toDir !is Catalog)
                throw RuntimeException("Invalid path")

            val node: Optional<INode> = toDir.findByName(newFileLocation.getLastPart())

            if(node.isPresent && node.get() is File)
                throw RuntimeException("File already exists")

        }
    }
}
