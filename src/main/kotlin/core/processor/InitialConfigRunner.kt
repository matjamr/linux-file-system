package core.processor

import model.context.Context

class InitialConfigRunner: Processor {
    override fun process(context: Context) {
//        println("Some loading phase... will do in the future like reading executing .bashrc etc")
//        context.currentNode = NodeFinder.findNodeByName(context.rootCatalog, context.currentUser.name)
        context.currentNode = context.currentCatalog
        context.rootNode = context.currentCatalog
    }
}
