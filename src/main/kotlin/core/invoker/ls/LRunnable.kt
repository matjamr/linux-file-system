package core.invoker.ls

import core.invoker.Runnable
import model.node.Catalog

class LRunnable: Runnable<Catalog> {
    override fun run(node: Catalog) {
        println("l runnable")
    }
}
