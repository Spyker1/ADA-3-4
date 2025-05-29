data class OrgNode(
    val id: Int,
    val nombrePuesto: String,
    val nombrePersona: String,
    val hijos: MutableList<OrgNode> = mutableListOf()
)