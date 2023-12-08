package core.engine

import core.processor.Processor
import core.util.node.NodeFinder
import model.Context
import model.memento.Catalog

class Engine(
    private var processorChain: List<Processor>
): IEngine {
    lateinit var context: Context
    override fun init(catalog: Catalog) {
        context = Context(catalog)
    }

    override fun run() {
        while(!context.abortFlag) {
            processorChain.stream().forEach { it.process(context) }
        }
    }
}
