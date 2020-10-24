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
                                        <th>Genre</th>
                                        <th>Prénom</th>
                                        <th>Nom</th>
                                        <th>Pseudo</th>
                                        <th>Email</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>${user.gender}</td>
                                        <td>${user.firstName}</td>
                                        <td>${user.lastName}</td>
                                        <td>${user.username}</td>
                                        <td>${user.email}</td>
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
                <table class="row">
                    <tr>
                        <td>Titre</td>
                        <td>Auteur</td>
                        <td>Date de l'emprunt</td>
                        <td>Date de retour</td>
                        <td>Prolonger l'emprunt</td>
                    </tr>
                    <c:forEach items="${copies}" var="copies">
                        <tr>
                            <td>${copies.book.title}</td>
                            <td>${copies.book.author}</td>
                            <td><fmt:formatDate value ="${copies.loanStartDate}" pattern="dd MMMMM yyyy" /></td>
                            <td><fmt:formatDate value ="${copies.loanEndDate}"  pattern="dd MMMMM yyyy" /></td>
                            <td>
                                <c:if test="${copies.extend == false}">
                                    <c:if test="${dayDate le copies.loanEndDate}">
                                        <a href="<%=request.getContextPath()+response.encodeURL("/extend")%>/${copies.id}">prolonger</a>
                                    </c:if>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </section>
</main>

<%@include file="_includes/footer.jsp"%>