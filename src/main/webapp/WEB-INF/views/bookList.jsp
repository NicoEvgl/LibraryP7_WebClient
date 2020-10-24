<%@ page pageEncoding="UTF-8"%>

<%@include file="_includes/header.jsp"%>

<main class="page bookList-page">
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="row">
                <table class="table">
                    <tr>
                        <td>Titre</td>
                        <td>Nombre d'exemplaires disponibles</td>
                    </tr>
                    <c:forEach items="${copySearchResults}" var="copySearchResults">
                        <tr>
                            <td>${copySearchResults.title}</td>
                            <td>${copySearchResults.nbAvailable}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </section>
</main>

<%@include file="_includes/footer.jsp"%>
