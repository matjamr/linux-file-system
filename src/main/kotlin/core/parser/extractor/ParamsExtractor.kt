package core.parser.extractor

import model.command.param.Param
import java.lang.RuntimeException
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

class ParamsExtractor : Extractor<List<Param>, String> {
    private val nameContentRegexp: Regex = "-[A-Za-z]\\s[A-Za-z]+".toRegex()
    private val emptyContentRegexp: Regex = "-[A-Za-z]+".toRegex()

    override fun extract(command: String): List<Param> {

        val returnList: MutableList<Param> = ArrayList();

        if(nameContentRegexp.containsMatchIn(command)) {
            returnList.addAll(withBodyParamsMatcherResult(nameContentRegexp.findAll(command).toList()))
        } else if (emptyContentRegexp.containsMatchIn(command)) {
            returnList.addAll(shortenedMatcherResult(emptyContentRegexp.findAll(command).toList()))
        }

        return Optional.of(returnList)
            .filter { it.isEmpty().not() }
            .orElseThrow { RuntimeException("No params supported") }
    }

    private fun withBodyParamsMatcherResult(results: List<MatchResult>): List<Param> {
        return results.stream()
            .map { it.groupValues }
            .flatMap { it.stream() }
            .map { it.replace("-", "") }
            .map { it.split(" ") }
            .map { Param(it[0], it[1], true) }
            .toList()
    }

    private fun shortenedMatcherResult(results: List<MatchResult>): List<Param> {

        val singleLineOfCommands: String = results.stream()
            .map { it.groupValues }
            .flatMap { it.stream() }
            .collect(Collectors.joining())

        return singleLineOfCommands.split("").stream()
            .filter { !it.equals("-") && !it.equals("")}
            .map { Param(it, null, false) }
            .toList()
    }
}
