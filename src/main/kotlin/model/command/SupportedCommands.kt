package model.command

import core.parser.Parser
import core.action.IAction
import core.action.ls.ARunnable
import core.action.ls.LRunnable
import core.action.ls.LsAction
import core.action.mv.MvAction
import core.parser.LsParser
import core.parser.MvParser
import model.command.param.IParam
import model.command.param.Param
import java.lang.RuntimeException

enum class SupportedCommands(name: String,
                             var iParams: List<IParam>,
                             var action: IAction,
                             var parser: Parser
) {
    LS(
        "ls",
        listOf(
            Param("-l", null, ARunnable(),"Follow all symbolic links to final target and list the file or directory the link references rather than the link itself."),
            Param("-a", null, LRunnable()," Include directory entries whose names begin with a dot (‘.’) except for . and ...  Automatically set for the super-user unless -I is specified.")
        ),
        LsAction(),
        LsParser()
    ),
    MV("mv", ArrayList(), MvAction(), MvParser());
//    RM("rm"),
//    RM_DIR("rmdir"),
//    TOUCH("touch"),
//    CD("cd")

    fun getParamNames(): List<String> = iParams.stream().map { it.getName() }.toList()
    fun findParamByName(paramName: String): IParam = iParams.stream()
        .filter { it.getName() == paramName }
        .findFirst()
        .orElseThrow { RuntimeException("There is no param with name $paramName") }
}
