package core.processor

import core.util.node.NodeFinder
import model.Context

class InitialConfigRunner: Processor {
    override fun process(context: Context) {
//        println("Some loading phase... will do in the future like reading executing .bashrc etc")
        context.currentNode = NodeFinder.findNodeByName(context.catalog.childrenNodes, context.currentUser.name)
    }
}
