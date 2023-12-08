package model.command

import model.command.param.IParam

class LsCommand(name: String, iParams: List<IParam>, paths: List<String>) : Command(name, iParams) {
}
