package model.node

class Node(
    private var parent: Node?,
    private var name: String
) : INode {
    override fun getName(): String = name

    override fun getParent(): Node? = parent

    override fun hasParent(): Boolean = parent == null
}
