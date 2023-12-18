package model.command.cd

import model.command.Command
import model.path.IPath

class CdCommand(name: String, var dest: IPath): Command(name, emptyList()) {
}
