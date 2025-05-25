import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun KnapsackView(controller: KnapsackController) {
    var name by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var value by remember { mutableStateOf("") }
    var capacity by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp).verticalScroll(rememberScrollState())) {
        OutlinedTextField(name, onValueChange = { name = it }, label = { Text("Nombre del ítem") })
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(weight, onValueChange = { weight = it }, label = { Text("Peso") })
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(value, onValueChange = { value = it }, label = { Text("Valor") })
        Spacer(Modifier.height(8.dp))

        Button(onClick = {
            val w = weight.toIntOrNull()
            val v = value.toIntOrNull()
            if (name.isNotBlank() && w != null && v != null) {
                controller.addItem(name, w, v)
                name = ""; weight = ""; value = ""
            }
        }) {
            Text("Agregar ítem")
        }

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(capacity, onValueChange = { capacity = it }, label = { Text("Capacidad") })
        Spacer(Modifier.height(8.dp))

        Button(onClick = {
            val cap = capacity.toIntOrNull()
            if (cap != null) {
                controller.setCapacity(cap)
                val (totalValue, selectedItems) = controller.solve()
                resultText = buildString {
                    append("Valor total: $totalValue\n")
                    append("Ítems seleccionados:\n")
                    selectedItems.forEach {
                        append("- ${it.name} (peso: ${it.weight}, valor: ${it.value})\n")
                    }
                }
            }
        }) {
            Text("Resolver")
        }

        Spacer(Modifier.height(16.dp))
        Text(resultText)
    }
}