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
        context.currentCatalog = rootCatalog

        return this
    }

    override fun run(): IEngine {
        while(!context.abortFlag) {
            processorChain.stream().forEach { it.process(context) }
        }

        return this
    }
}
