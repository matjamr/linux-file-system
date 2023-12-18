package core.engine

import core.processor.Processor
import model.context.Context
import model.node.Catalog

class Engine(
    private var processorChain: List<Processor>
): IEngine {
    lateinit var context: Context
    override fun init(rootCatalog: Catalog): IEngine {
        context = Context()
        context.currentNode = rootCatalog
        context.rootNode = rootCatalog

        return this
    }

    override fun run(): IEngine {
        while(!context.abortFlag) {
            try {
                processorChain.stream().forEach { it.process(context) }
            } catch (e: RuntimeException) {
                println("\n\t${e.message}\n\n")
                e.printStackTrace()
            }
        }

        return this
    }
}
