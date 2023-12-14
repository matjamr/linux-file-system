package core.invoker.ls

import core.invoker.Runnable
import model.node.Catalog

class RRunnable: Runnable<Catalog> {
    override fun run(node: Catalog) {
        println("Runnable R")
    }

}
