import java.sql.Connection
import java.sql.DriverManager

class OrgController {
    private val url = "jdbc:mysql://localhost:3306/ada"
    private val user = "root"
    private val password = ""

    fun cargarArbol(): List<OrgNode> {
        val conexion: Connection = DriverManager.getConnection(url, user, password)
        val mapa = mutableMapOf<Int, OrgNode>()
        val pendientes = mutableMapOf<Int, MutableList<OrgNode>>()
        val raiz = mutableListOf<OrgNode>()

        val rs = conexion.prepareStatement(
            "SELECT id, nombre_puesto, nombre_persona, puesto_superior_id FROM puestos"
        ).executeQuery()

        while (rs.next()) {
            val id = rs.getInt("id")
            val puesto = rs.getString("nombre_puesto")
            val persona = rs.getString("nombre_persona")
            val superiorId = rs.getInt("puesto_superior_id").takeIf { !rs.wasNull() }

            val nodo = OrgNode(id, puesto, persona)
            mapa[id] = nodo

            if (superiorId == null) {
                raiz.add(nodo)
            } else {
                val padre = mapa[superiorId]
                if (padre != null) {
                    padre.hijos.add(nodo)
                } else {
                    pendientes.getOrPut(superiorId) { mutableListOf() }.add(nodo)
                }
            }

            pendientes[id]?.forEach { hijo -> nodo.hijos.add(hijo) }
        }

        conexion.close()
        return raiz
    }
}