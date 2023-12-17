package model.command

import model.command.param.IParam

class MoreCommand(name: String, var dest: String): Command(name, emptyList()) {
}
