package core.action.ls

import core.action.Runnable
import model.node.Catalog

class LRunnable: Runnable<Catalog> {
    override fun run(node: Catalog) {
        println("l runnable")
    }
}
