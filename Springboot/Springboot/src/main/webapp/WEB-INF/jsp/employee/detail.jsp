<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<section class="py-5 bg-dark-blue">
    <div class="container text-center">
        <h1>Employee Detail</h1>
    </div>
</section>

<section class="py-5 bg-light-blue">
    <div class="container">
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <a class="btn btn-secondary mb-3" href="/employee/edit/${employee.id}">Edit Employee</a>
                <table class="table table-striped">
                    <tr>
                        <th>id</th>
                        <td>${employee.id}</td>
                    </tr>
                    <tr>
                        <th>Office id</th>
                        <td>${employee.officeId}</td>
                    </tr>
                    <tr>
                        <th>Last Name</th>
                        <td><a href="/employee/search?lastName=${employee.lastName}">${employee.lastName}</a></td>
                    </tr>
                    <tr>
                        <th>First Name</th>
                        <td><a href="/employee/search?firstName=${employee.firstName}">${employee.firstName}</a></td>
                    </tr>
                    <tr>
                        <th>Extension</th>
                        <td>${employee.extension}</td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td>${employee.email}</td>
                    </tr>
                    <tr>
                        <th>Reports To</th>
                        <td>${employee.reportsTo}</td>
                    </tr>
                    <tr>
                        <th>Job Title</th>
                        <td>${employee.jobTitle}</td>
                    </tr>
                    <tr>
                        <th>Vacation Hours</th>
                        <td>${employee.vacationHours}</td>
                    </tr>
                    <tr>
                        <th>Profile Image</th>
                        <td><img style="width: 200px;" src="${employee.profileImageUrl}"></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>