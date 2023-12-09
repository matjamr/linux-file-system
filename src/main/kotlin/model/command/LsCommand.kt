package model.command

import model.command.param.IParam
import model.node.Catalog

class LsCommand(name: String, iParams: List<IParam<Catalog>>, var paths: List<String>) : Command(name, iParams) {
}
