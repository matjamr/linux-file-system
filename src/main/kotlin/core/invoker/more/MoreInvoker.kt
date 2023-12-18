package core.invoker.more

import core.invoker.Invoker
import core.invoker.common.path.PathResolver2
import core.util.InvalidPathProvider
import model.command.*
import model.command.more.MoreCommand
import model.context.Context
import model.node.File
import java.util.*

class MoreInvoker(
    private val pathResolver: PathResolver2
): Invoker {

    override fun run(command: Command, context: Context) {
        val touchCommand = command as MoreCommand

        val file: File = pathResolver.resolve(touchCommand.dest.getPath(), context, InvalidPathProvider()) as File


        var i = file.content.length / 1000
        var j = 0

        do {
            clear()
            println(file.content.substring(1000*j, 1000*(j+1)))
            println("\n\n--More--(${100/5*j} Press enter to continue Q to quit")
            var input: String = readln()
            if(input.strip() != "")
                break
            j++;
        } while (j+1 <= i)

    }

    fun clear() {
//        var os: String = System.getProperty("os.name");
//
//        if (os.contains("Windows"))
//        {
//            Runtime.getRuntime().exec("cls");
//        }
//        else
//        {
//            Runtime.getRuntime().exec("clear");
//        }
    }
}
