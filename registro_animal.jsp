<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro de Salud Animal</title>
</head>
<body>
    <h2>Formulario de Registro - Monitoreo Animal</h2>
    <!-- Utilizando método POST para enviar datos seguros al Servlet -->
    <form action="AnimalServlet" method="POST">
        <label>Nombre del Animal:</label><br>
        <input type="text" name="nombre" required><br><br>

        <label>Especie:</label><br>
        <input type="text" name="especie" required><br><br>

        <label>Estado de Salud:</label><br>
        <input type="text" name="estadoSalud" required><br><br>

        <button type="submit">Registrar Animal</button>
    </form>
</body>
</html>