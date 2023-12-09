package core.action.common

import core.action.Runnable
import model.node.Catalog

class ShowCatalogRunnable: Runnable<Catalog> {
    override fun run(node: Catalog) {
        println(node.getName())
        node.childrenNodes.stream()
            .forEach { println("\t${it.getName()}") }
    }
}
