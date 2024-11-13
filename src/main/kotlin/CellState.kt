import kotlin.random.Random

enum class CellState {
    Dead, Alive,
}

data class Cell(
    val row: Int,
    val column: Int,
    val state: CellState = if(Random.nextBoolean()) CellState.Alive else CellState.Dead,
)