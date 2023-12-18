package model.command.cp

import model.command.Command
import model.path.IPath

class CpCommand(name: String, var from: IPath, var to: IPath): Command(name, emptyList()) {
}
