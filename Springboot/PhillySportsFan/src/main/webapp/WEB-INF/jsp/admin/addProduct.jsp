<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<section class="py-5 bg-dark-blue">
    <div class="container text-center">
        <c:if test="${empty form.id}">
            <h1>Add Product</h1>
        </c:if>
        <c:if test="${not empty form.id}">
            <h1>Edit Product</h1>
        </c:if>
    </div>
</section>

<section class="py-5">
    <div class="col-5 container">
        <form action="/admin/addProductSubmit">
            <input type="hidden" name="id" value="${form.id}"/>
            <div class="mb-3">
                <label for="productName" class="form-label">Product Name</label>
                <input type="text" class="form-control" id="productName" name="productName"
                       aria-describedby="productNameHelp" value="${form.productName}">
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Price</label>
                <input type="number" class="form-control" id="price" name="price" aria-describedby="priceHelp"
                       min="0" step="0.01" value="${form.price}">
            </div>
            <div class="mb-3">
                <label for="quantityInStock" class="form-label">Quantity In Stock</label>
                <input type="number" class="form-control" id="quantityInStock" name="quantityInStock"
                       aria-describedby="quantityInStockHelp" min="0" value="${form.quantityInStock}">
            </div>
            <div class="mb-3">
                <label for="sportsTeam" class="form-label">Sports Team</label>
                <select id="sportsTeam" name="sportsTeam" class="form-select">
                    <c:forEach items="${sportsTeams}" var="team">
                        <option value="${team}"
                                <c:if test="${team eq form.sportsTeam}">selected</c:if>
                        >${team}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="category" class="form-label">Category</label>
                <select id="category" name="category" class="form-select">
                    <c:forEach items="${categoryList}" var="category">
                        <option value="${category}"
                                <c:if test="${category eq form.category}">selected</c:if>
                        >${category}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <textarea id="description" name="description" class="form-control" rows="5"
                          aria-describedby="descriptionHelp">${form.description}</textarea>
            </div>
            <div class="mb-3">
                <label for="imgUrl" class="form-label">Image URL</label>
                <textarea id="imgUrl" name="imgUrl" class="form-control"
                          aria-describedby="imgUrlHelp">${form.imgUrl}</textarea>
            </div>

            <button type="submit" class="btn btn-primary mt-3 me-3 px-3" onclick="formSubmit()">
                <c:if test="${empty form.id}">
                    Create Product
                </c:if>
                <c:if test="${not empty form.id}">
                    Edit Product
                </c:if>
            </button>
        </form>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>