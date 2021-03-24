<%@ page pageEncoding="UTF-8"%>

<%@include file="_includes/header.jsp"%>

<main class="page bookList-page">
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="row">
                <table class="table text-center my-0">
                    <thead>
                    <tr>
                        <th>Titre</th>
                        <th>Nombre d'exemplaires disponibles</th>
                        <th>Date de retour prévue</th>
                        <th>Réserver</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${copySearchResults}" var="copySearchResults">
                        <tr>
                            <td>${copySearchResults.title}</td>
                            <td>${copySearchResults.nbAvailable}</td>
                            <td><fmt:formatDate value="${copySearchResults.expectedReturnDate}" type="date"/></td>
                            <td>
                                <c:if test="${copySearchResults.nbPossibleReservations != 0}">
                                    <a href="<%=request.getContextPath()+response.encodeURL("/reservation")%>/${copySearchResults.bookId}">ici</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</main>

<%@include file="_includes/footer.jsp"%>
