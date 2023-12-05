package model.node

interface INode {
    fun getName(): String
    fun getParent(): Node?
    fun hasParent(): Boolean
}
