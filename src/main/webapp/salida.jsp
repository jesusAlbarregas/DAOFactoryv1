<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="es.albarregas.beans.Avistamiento, java.util.List, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            String motor = (request.getAttribute("fuente").equals("1"))?"MySQL":"Derby";
        %>
        <title><%= motor %></title>
    </head>
    <body>
        <div>
            <%
                List<Avistamiento> listado = null;
                listado = new ArrayList();
                listado = (ArrayList<Avistamiento>) request.getAttribute("listado");
                boolean primera = true;
                for (Avistamiento visto : listado) {
                    if (primera) {
                        primera = false;
            %>
            <p>Anilla: <strong><%= visto.getAnilla()%></strong>  Especie: <strong><%= visto.getEspecie()%></strong></p>
            <ul>
                <%
                    }

                %>
                <li><%= visto.getLugar() %> - <%= visto.getFecha() %></li>
                

                <%
                    }
                %>
            </ul>
            <br/>
                <p><a href="<%= request.getContextPath() %>">Volver</a></p>
        </div>
    </body>
</html>
