package model.node

import model.memento.Memento
abstract class Node(
    private var parent: INode?,
    private var name: String
) : INode {
    override fun getName(): String = name

    override fun getParent(): INode? = parent

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
