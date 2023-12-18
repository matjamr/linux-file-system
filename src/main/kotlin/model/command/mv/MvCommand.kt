package model.command.mv

import model.command.Command
import model.path.IPath

class MvCommand(name: String, var from: IPath, var to: IPath): Command(name, emptyList()) {
}
