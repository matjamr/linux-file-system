package model.node

import model.memento.Memento

interface INode {
    fun getName(): String
    fun getParent(): INode?
    fun hasParent(): Boolean
    fun clone(): INode
    fun createMemento(): Memento
    fun restore(memento: Memento)
}
