<%@ include file="includes/cabecera.jsp"%>

<h2>Mantenimiento de usuarios</h2>

<table border="1">
	<thead>
		<tr>
			<th>Operaciones</th>
			<th>Usuario</th>
			<th>Contraseņa</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><a href="?op=modificar">Modificar</a><a href="?op=borrar">Borrar</a></td>
			<td>Usuario1</td>
			<td>Contraseņa1</td>
		</tr>
		<tr>
			<td><a href="?op=modificar">Modificar</a><a href="?op=borrar">Borrar</a></td>
			<td>Usuario2</td>
			<td>Contraseņa2</td>
		</tr>
	</tbody>
</table>

<a href="?op=alta">Alta</a>

<%@ include file="includes/pie.jsp"%>
