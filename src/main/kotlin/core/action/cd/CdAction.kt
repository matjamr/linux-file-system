package core.action.cd

import core.action.IAction
import model.context.Context
import model.command.CdCommand
import model.command.Command
import model.node.Catalog

class CdAction: IAction {

    private val goUpRegex: Regex = Regex("../")

    override fun run(command: Command, context: Context) {
        val cdCommand: CdCommand = command as CdCommand

        if(goUpRegex.matches(cdCommand.dest)) {
            context.currentCatalog = goUp(cdCommand, context)
        } else {
            context.currentCatalog = context.currentCatalog.findByName(cdCommand.dest)
        }
    }

    private fun goUp(cdCommand: CdCommand, context: Context): Catalog {
        var tmpNode: Catalog = context.currentCatalog

        for(levelUp: MatchResult in goUpRegex.findAll(cdCommand.dest)) {
            if(tmpNode.getParent() != null) {
                tmpNode = tmpNode.getParent() as Catalog
            }
        }

        return tmpNode
    }
}
