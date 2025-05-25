import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    val controller = JobController()
    Window(onCloseRequest = ::exitApplication, title = "Job Scheduling") {
        JobView(controller)
    }
}
