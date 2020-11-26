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
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${copySearchResults}" var="copySearchResults">
                        <tr>
                            <td>${copySearchResults.title}</td>
                            <td>${copySearchResults.nbAvailable}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</main>

<%@include file="_includes/footer.jsp"%>
