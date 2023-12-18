package model.command.touch

import model.command.Command
import model.path.IPath

class TouchCommand(name: String, var fileLocations: List<IPath>): Command(name, emptyList()) {
}
