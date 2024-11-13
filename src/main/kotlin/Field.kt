typealias Field = List<List<Cell>>

fun Field.aliveNeighbourCount(cell: Cell): Int {
    var aliveNeighbourCount = 0
    Direction.entries.forEach { direction ->
        if(this.getNeighbourByDirection(cell, direction)?.state == CellState.Alive) {
            aliveNeighbourCount++
        }
    }
    return aliveNeighbourCount
}

fun Field.getNeighbourByDirection(cell: Cell, direction: Direction): Cell? = when (direction) {
    Direction.Top -> this.getOrNull(cell.row - 1)?.getOrNull(cell.column)
    Direction.Right -> this.getOrNull(cell.row)?.getOrNull(cell.column + 1)
    Direction.Bottom -> this.getOrNull(cell.row + 1)?.getOrNull(cell.column)
    Direction.Left -> this.getOrNull(cell.row)?.getOrNull(cell.column - 1)
    Direction.TopRight -> this.getOrNull(cell.row - 1)?.getOrNull(cell.column + 1)
    Direction.BottomRight -> this.getOrNull(cell.row + 1)?.getOrNull(cell.column + 1)
    Direction.BottomLeft -> this.getOrNull(cell.row + 1)?.getOrNull(cell.column - 1)
    Direction.TopLeft -> this.getOrNull(cell.row - 1)?.getOrNull(cell.column - 1)
}


enum class Direction {
    Top,
    Right,
    Bottom,
    Left,
    TopRight,
    BottomRight,
    BottomLeft,
    TopLeft,
}