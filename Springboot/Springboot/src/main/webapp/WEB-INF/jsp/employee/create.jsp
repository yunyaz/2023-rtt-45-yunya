<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<section class="py-5 bg-dark-blue">
    <div class="container text-center">
        <c:if test="${empty form.id}">
            <h1>Create Employee</h1>
        </c:if>
        <c:if test="${not empty form.id}">
            <h1>Edit Employee</h1>
        </c:if>
    </div>
</section>

<section class="py-5 bg-light-blue">
    <div class="col-5 container">
        <form action="/employee/createSubmit">
            <input type="hidden" name="id" value="${form.id}"/>
            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" value="${form.email}">
            </div>
            <div class="mb-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" aria-describedby="firstNameHelp" value="${form.firstName}">
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" aria-describedby="lastNameHelp" value="${form.lastName}">
            </div>
            <div class="mb-3">
                <label for="office" class="form-label">Office</label>
                <select id="office" name="officeId" class="form-select">
                    <c:forEach items="${offices}" var="office">
                        <option value="${office.id}"
                                <c:if test="${office.id eq form.officeId}">selected</c:if>
                        >${office.city}</option>
                    </c:forEach>
                </select>

            </div>
            <div class="mb-3">
                <label for="jobTitle" class="form-label">Job Title</label>
                <input type="text" class="form-control" id="jobTitle" name="jobTitle" aria-describedby="JobTitleHelp" value="${form.jobTitle}">
            </div>
            <div class="mb-3">
                <label for="vacationHours" class="form-label">Vacation Hours</label>
                <input type="number" class="form-control" id="vacationHours" name="vacationHours" aria-describedby="vacationHoursHelp" value="${form.vacationHours}">
            </div>
            <div class="mb-3">
                <label for="profileImageUrl" class="form-label">Profile Image URL</label>
                <input type="text" class="form-control" id="profileImageUrl" name="profileImageUrl" aria-describedby="profileImageUrlHelp" value="${form.profileImageUrl}">
            </div>
            <div class="mb-3">
                <label for="extension" class="form-label">Extension</label>
                <input type="text" class="form-control" id="extension" name="extension" aria-describedby="extensionHelp" value="${form.extension}">
            </div>
            
            <button type="submit" class="btn btn-primary mt-3 me-3 px-5" onclick="formSubmit()">
                <c:if test="${empty form.id}">
                    Create Account
                </c:if>
                <c:if test="${not empty form.id}">
                    Edit Account
                </c:if>
            </button>
        </form>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />