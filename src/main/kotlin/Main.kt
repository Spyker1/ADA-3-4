import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    val controller = KnapsackController()
    Window(onCloseRequest = ::exitApplication, title = "Problema de la Mochila") {
        KnapsackView(controller)
    }
}