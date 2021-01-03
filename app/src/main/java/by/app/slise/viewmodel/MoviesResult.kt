package by.app.slise.viewmodel




sealed class MoviesResult
class ValidResult(val result: List<by.app.slise.entities.Movie>) : MoviesResult()
object EmptyResult : MoviesResult()
object EmptyQuery : MoviesResult()
class ErrorResult(val e: Throwable) : MoviesResult()
object TerminalError : MoviesResult()