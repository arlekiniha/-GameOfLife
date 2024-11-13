import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class Board(
    row: Int,
    column: Int,
    private val rule: Rule = ClassicRules(),
) {

    private var _field: MutableStateFlow<Field> = MutableStateFlow(List(row) { iRow ->
        List(column) { iColumn -> Cell(iRow, iColumn) }
    })
    val field: StateFlow<Field> = _field.asStateFlow()

    suspend fun start() {
        while (true) {
            delay(TACT_TIME)
            move()
        }
    }

    private fun move() {
        _field.update { board ->
            board.map { row ->
                row.map { cell ->
                    rule.newCellState(cell, _field.value)
                }
            }
        }
    }
}

private const val TACT_TIME = 50L