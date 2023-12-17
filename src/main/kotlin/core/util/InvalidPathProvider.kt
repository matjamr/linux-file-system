package core.util

import model.node.INode

class InvalidPathProvider: Provider {
    override fun provide(nodeName: String, node: INode): INode {
        throw RuntimeException("Node $node does not contain $nodeName")
    }
}
