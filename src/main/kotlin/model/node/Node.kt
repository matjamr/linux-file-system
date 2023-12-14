package model.node

import model.memento.Memento

// prototyp
abstract class Node(
    private var parent: INode?,
    private var name: String
) : INode {
    override fun getName(): String = name

    override fun getParent(): INode? = parent

    override fun hasParent(): Boolean = parent == null

    override fun toString(): String = name


}
