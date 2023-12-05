package core.parser

import model.command.Command

interface Parser {
    fun parse(command: String): Command
}
