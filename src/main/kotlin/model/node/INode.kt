package model.node

import model.memento.Memento

interface INode {
    fun getName(): String
    fun getParent(): Node?
    fun hasParent(): Boolean
    fun clone(): Nothing
    fun createMemento(): Memento
    fun restore(): Memento
}
