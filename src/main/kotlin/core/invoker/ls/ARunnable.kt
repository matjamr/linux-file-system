package core.invoker.ls

import core.invoker.Runnable
import model.node.Catalog

class ARunnable: Runnable<Catalog> {
    override fun run(node: Catalog) {
        println("A runnable")
    }
}
