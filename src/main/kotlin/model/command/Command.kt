package model.command

import model.command.action.IAction
import model.command.param.IParam

class Command(
    var name: String,
    var iParams: List<IParam>,
    var action: IAction
) {

}
