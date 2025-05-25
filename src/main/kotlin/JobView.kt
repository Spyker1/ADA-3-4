import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JobView(controller: JobController) {
    var name by remember { mutableStateOf("") }
    var hours by remember { mutableStateOf("") }
    var profit by remember { mutableStateOf("") }
    var timeLimit by remember { mutableStateOf("0") }
    var resultText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(20.dp).fillMaxSize().verticalScroll(rememberScrollState())
    ) {
        Text("Problema de programación de trabajos", fontSize = 22.sp, fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(20.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            Column(Modifier.weight(1f)) {
                OutlinedTextField(name, { name = it }, label = { Text("Nombre del trabajo") })
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(hours, { hours = it }, label = { Text("Horas requeridas") })
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(profit, { profit = it }, label = { Text("Beneficio (Profit)") })
                Spacer(Modifier.height(8.dp))
                Button(onClick = {
                    val h = hours.toIntOrNull()
                    val p = profit.toIntOrNull()
                    if (name.isNotBlank() && h != null && p != null) {
                        controller.addJob(name, h, p)
                        name = ""; hours = ""; profit = ""
                    }
                }, colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary)) {
                    Text("Agregar trabajo")
                }
            }

            Column(Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(timeLimit, { timeLimit = it }, label = { Text("Tiempo total disponible (0 = sin límite)") })
                Spacer(Modifier.height(8.dp))
                Button(onClick = {
                    val limit = timeLimit.toIntOrNull() ?: 0
                    controller.setTimeLimit(limit)
                    val selected = controller.solve()
                    resultText = buildString {
                        append("Secuencia óptima de trabajos:\n")
                        selected.forEach {
                            append("- ${it.name} (${it.hours}h, \$${it.profit})\n")
                        }
                        val totalProfit = selected.sumOf { it.profit }
                        append("Beneficio total: \$${totalProfit}")
                    }
                }) {
                    Text("Calcular secuencia óptima")
                }
            }
        }

        Spacer(Modifier.height(20.dp))
        Text("Trabajos añadidos:", fontWeight = FontWeight.Bold)
        controller.getJobs().forEach {
            Text("- ${it.name} (${it.hours}h, \$${it.profit})")
        }

        Spacer(Modifier.height(20.dp))
        Text("Resultado:", fontWeight = FontWeight.Bold)
        Text(resultText)
    }
}