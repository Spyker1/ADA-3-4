import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OrgChartView(nodos: List<OrgNode>, nivel: Int = 0, esUltimoHijo: Boolean = true) {
    Column(
        modifier = Modifier.padding(start = if (nivel > 0) 24.dp else 0.dp)
    ) {
        nodos.forEachIndexed { index, nodo ->
            val esUltimo = index == nodos.lastIndex

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                if (nivel > 0) {
                    Box(
                        modifier = Modifier
                            .width(24.dp)
                            .height(80.dp)
                    ) {
                        Canvas(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            val strokeWidth = 2.dp.toPx()
                            val lineColor = Color(0xFF666666)

                            drawLine(
                                color = lineColor,
                                start = Offset(0f, size.height / 2),
                                end = Offset(size.width, size.height / 2),
                                strokeWidth = strokeWidth
                            )

                            if (!esUltimo) {
                                drawLine(
                                    color = lineColor,
                                    start = Offset(0f, 0f),
                                    end = Offset(0f, size.height),
                                    strokeWidth = strokeWidth
                                )
                            } else {
                                // Si es el último, la línea va solo hasta la mitad
                                drawLine(
                                    color = lineColor,
                                    start = Offset(0f, 0f),
                                    end = Offset(0f, size.height / 2),
                                    strokeWidth = strokeWidth
                                )
                            }
                        }
                    }
                }

                // Tarjeta del nodo
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Card(
                        elevation = 4.dp,
                        backgroundColor = when (nivel) {
                            0 -> Color(0xFFE3F2FD)
                            1 -> Color(0xFFE8F5E8)
                            2 -> Color(0xFFFFF3E0)
                            else -> Color(0xFFF3E5F5)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp, end = 8.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = nodo.nombrePuesto,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF333333)
                            )
                            Text(
                                text = nodo.nombrePersona,
                                fontSize = 12.sp,
                                color = Color(0xFF666666)
                            )
                        }
                    }

                    if (nodo.hijos.isNotEmpty()) {
                        OrgChartView(nodo.hijos, nivel + 1, esUltimo)
                    }
                }
            }
        }
    }
}