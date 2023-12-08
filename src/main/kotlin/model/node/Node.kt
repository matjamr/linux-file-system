package model.node

import model.memento.Memento

class Node(
    private var parent: Node?,
    private var name: String
) : INode {
    override fun getName(): String = name

    override fun getParent(): Node? = parent

    override fun hasParent(): Boolean = parent == null

    override fun clone(): Nothing {
        TODO("Not yet implemented")
    }

    override fun createMemento(): Memento {
        TODO("Not yet implemented")
    }

    override fun restore(): Memento {
        TODO("Not yet implemented")
    }

    override fun toString(): String = name


}
