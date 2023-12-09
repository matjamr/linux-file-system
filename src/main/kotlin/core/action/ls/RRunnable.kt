package core.action.ls

import core.action.Runnable
import model.node.Catalog

class RRunnable: Runnable<Catalog> {
    override fun run(node: Catalog) {
        println("Runnable R")
    }

}
