package model.command.ls

import model.command.Command
import model.command.param.IParam
import model.node.Catalog
import model.path.IPath

class LsCommand(name: String, iParams: List<IParam<Catalog>>, var paths: List<IPath>) : Command(name, iParams) {
}
