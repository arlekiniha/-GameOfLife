import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    val board = remember {
        Board(200, 200)
    }
    LaunchedEffect(Unit) {
        board.start()
    }
    val field by board.field.collectAsState()

    Grid(
        modifier = Modifier.size(500.dp, 500.dp),
        field = field,
        cellSize = 5f,
    )
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

@Composable
fun Grid(
    modifier: Modifier = Modifier,
    field: Field,
    cellSize: Float = 20f,
) {
    Canvas(modifier = modifier) {
        for (row in field.indices) {
            for (column in field[row].indices) {
                val color = when (field[row][column].state) {
                    CellState.Alive -> Color.White
                    CellState.Dead -> Color.Black
                }
                drawRect(
                    color = color,
                    topLeft = Offset(row * cellSize, column * cellSize),
                    size = Size(cellSize, cellSize)
                )
            }
        }
    }
}
