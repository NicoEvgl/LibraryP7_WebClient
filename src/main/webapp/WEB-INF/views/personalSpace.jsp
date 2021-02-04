<%@ page pageEncoding="UTF-8"%>

<%@include file="_includes/header.jsp"%>

<main class="page personalSpace-page">
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Profil</h2>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="card shadow mb-3">
                            <div class="card-body">
                                <table class="table text-center my-0">
                                    <thead>
                                    <tr>
                                        <th>Prénom</th>
                                        <th>Nom</th>
                                        <th>Pseudo</th>
                                        <th>Email</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>${userInSession.firstName}</td>
                                        <td>${userInSession.lastName}</td>
                                        <td>${userInSession.pseudo}</td>
                                        <td>${userInSession.email}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Mes emprunts</h2>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="card shadow mb-3">
                            <div class="card-body">
                                <table class="table text-center my-0">
                                    <thead>
                                    <tr>
                                        <th>Titre</th>
                                        <th>Auteur</th>
                                        <th>Date de l'emprunt</th>
                                        <th>Date de retour</th>
                                        <th>Prolonger l'emprunt</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${copies}" var="copies">
                                        <tr>
                                            <td>${copies.book.title}</td>
                                            <td>${copies.book.author}</td>
                                            <td><fmt:formatDate value ="${copies.loanStartDate}"  pattern="dd MMMMM yyyy" /></td>
                                            <td><fmt:formatDate value ="${copies.loanEndDate}"  pattern="dd MMMMM yyyy" /></td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${copies.extend == false && dayDate le copies.loanEndDate}">
                                                        <a href="<%=request.getContextPath()+response.encodeURL("/extend")%>/${copies.copyId}">prolonger</a>
                                                        <br />
                                                    </c:when>
                                                    <c:otherwise>
                                                        Emprunt prolongé
                                                        <br />
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Mes réservations</h2>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="card shadow mb-3">
                            <div class="card-body">
                                <table class="table text-center my-0">
                                    <thead>
                                    <tr>
                                        <th>Titre</th>
                                        <th>Date du prochain retour</th>
                                        <th>Rang dans la liste d'attente</th>
                                        <th>Annuler Réservation</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${myReservations}" var="myReservations">
                                        <tr>
                                            <td>${myReservations.title}</td>
                                            <td><fmt:formatDate value ="${myReservations.returnDate}" type="date"/></td>
                                            <td>${myReservations.rank}</td>
                                            <td>
                                                <a href="<%=request.getContextPath()+response.encodeURL("/cancel-reservation")%>/${myReservations.reservationId}">ici</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

<%@include file="_includes/footer.jsp"%>