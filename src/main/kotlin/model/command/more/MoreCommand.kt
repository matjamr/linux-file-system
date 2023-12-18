package model.command.more

import model.command.Command
import model.path.IPath

class MoreCommand(name: String, var dest: IPath): Command(name, emptyList()) {
}
