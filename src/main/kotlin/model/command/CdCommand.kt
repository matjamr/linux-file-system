package model.command

import model.command.param.IParam

class CdCommand(name: String, var dest: String): Command(name, emptyList()) {
}
