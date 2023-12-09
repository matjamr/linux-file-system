package core.action.ls

import core.action.Runnable
import model.node.Catalog

class ARunnable: Runnable<Catalog> {
    override fun run(node: Catalog) {
        println("A runnable")
    }
}
