import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun main() = application {
    val controller = OrgController()
    val data = controller.cargarArbol()

    Window(onCloseRequest = ::exitApplication, title = "Organigrama Institucional") {
        MaterialTheme {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                OrgChartView(data)
            }
        }
    }
}//q