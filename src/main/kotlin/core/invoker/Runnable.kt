package core.invoker

import model.node.INode

interface Runnable<T : INode> {
    fun run(node: T)
}
