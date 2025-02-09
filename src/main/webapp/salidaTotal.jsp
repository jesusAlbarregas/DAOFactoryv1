<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="es.albarregas.beans.Avistamiento, java.util.List, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            String motor = (request.getSession().getAttribute("fuente").equals("1")) ? "MySQL" : "Derby";
        %>
        <title><%= motor%></title>
    </head>
    <body>
        <div>
            <dl>
            <%
                List<Avistamiento> listado = null;
                listado = new ArrayList();
                listado = (ArrayList<Avistamiento>) request.getAttribute("listado");
                boolean primera = true;
                String anilla = "";
                for (Avistamiento visto : listado) {
                    if (!anilla.equals(visto.getAnilla())) {
                        anilla = visto.getAnilla();

            %>
            <dt>Anilla: <strong><%= visto.getAnilla()%></strong>  Especie: <strong><%= visto.getEspecie()%></strong></dt>

            <%
                }
            %>
            <dd><%= visto.getLugar()%> - <%= visto.getFecha()%><dd>


            <%
                }
            %>
            </dl>
            <br/>
            <p><a href="<%= request.getContextPath()%>">Volver</a></p>
        </div>
    </body>
</html>
