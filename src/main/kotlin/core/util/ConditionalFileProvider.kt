package core.util

import model.node.INode

class ConditionalFileProvider: Provider {
    override fun provide(nodeName: String, node: INode): INode {
        return node
    }
}
