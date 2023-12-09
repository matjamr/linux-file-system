package core.action

import model.node.Catalog
import model.node.INode

interface Runnable<T : INode> {
    fun run(node: T)
}
