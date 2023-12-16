package model.command

import model.node.INode

class MvCommand(name: String, var from: String, var to: String): Command(name, emptyList()) {
}
