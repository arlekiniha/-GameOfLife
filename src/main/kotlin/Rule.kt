import kotlin.random.Random

interface Rule {
    fun newCellState(cell: Cell, field: Field): Cell
}

class ClassicRules : Rule {
    override fun newCellState(cell: Cell, field: Field): Cell {
//        val aliveNeighbours = field.aliveNeighbourCount(cell)
//        return when (cell.state) {
//            CellState.Dead -> if (aliveNeighbours == 3) cell.copy(state = CellState.Alive) else cell
//            CellState.Alive -> if (aliveNeighbours in 2..3) cell else cell.copy(state = CellState.Dead)
//        }

        val neighbourCount = field.aliveNeighbourCount(cell)
        return when(cell.state) {
            CellState.Alive -> if (neighbourCount < 2 || neighbourCount > 3) cell.copy(state = CellState.Dead) else cell
            CellState.Dead -> if (neighbourCount == 3) cell.copy(state= CellState.Alive) else cell
        }

//        return if(Random.nextBoolean()) cell.copy(state = CellState.Alive) else cell.copy(state = CellState.Dead)
    }
}