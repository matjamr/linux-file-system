package core.invoker.touch

import com.github.javafaker.Faker
import core.invoker.Invoker
import core.invoker.common.path.PathResolver2
import core.util.ConditionalFileProvider
import model.command.*
import model.command.touch.TouchCommand
import model.context.Context
import model.node.Catalog
import model.node.File

class TouchInvoker(
    private val pathResolver: PathResolver2
): Invoker {

    override fun run(command: Command, context: Context) {
        val touchCommand = command as TouchCommand

        if(touchCommand.fileLocations.size == 1) {
            val toDir: Catalog = pathResolver.resolve("./"+touchCommand.fileLocations[0].getLastPart(), context, ConditionalFileProvider()) as Catalog
            toDir.childrenNodes.add(File(touchCommand.fileLocations[0].getLastPart(), toDir, Faker().lorem().sentence(1000)))
        }

        for (newFileLocation in touchCommand.fileLocations) {
            val toDir: Catalog = pathResolver.resolve(newFileLocation.getPath(), context, ConditionalFileProvider()) as Catalog

            if(toDir.findByName(newFileLocation.getLastPart()).isPresent)
                throw RuntimeException("node with given name already exists")

            toDir.childrenNodes.add(File(newFileLocation.getLastPart(), toDir, Faker().lorem().sentence(1000)))
        }
    }
}
