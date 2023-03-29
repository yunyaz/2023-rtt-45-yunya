<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<section class="py-5 bg-dark-blue">
    <div class="container text-center">
        <h1>Employee Search</h1>
    </div>
</section>

<section class="py-5 bg-light-blue">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-5">
                <form>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" name="firstName" placeholder="Employee First Name" value="${searchFirst}"
                               aria-label="Employee First Name">
                    </div>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" name="lastName" placeholder="Employee Last Name" value="${searchLast}"
                               aria-label="Employee Last Name">
                    </div>
                    <button id="submitBtn" type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>

    </div>
</section>

<section class="py-5 bg-dark-blue">
    <div class="container text-center">
        <h4 class="pb-3">${employeesList.size()} Search Results</h4>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Job Title</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${employeesList}" var="emp">
                <tr>
                    <th scope="row">${emp.firstName}</th>
                    <td>${emp.lastName}</td>
                    <td>${emp.email}</td>
                    <td>${emp.jobTitle}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</section>


<jsp:include page="../include/footer.jsp" />