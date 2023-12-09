package model.node

class File(
    private var name: String,
    private var parent: INode?,
    var content: String
) : Node(parent, name) {
}
