<jsp:include page="include/header.jsp" />


<style>
    .page-header {
        margin-lefßt: 40px;
        margin-top: 30px;
        color: green !important;
    }

    h1 {
        border: 1px solid;
    }

    a:hover {
        color: orange;
    }

    a:visited {
        color: red;
    }

    #firsth1 {
        text-decoration: underline;
    }
</style>


<h1 id="firsth1" class="page-header" style="color:red ;">This a page title</h1>
<h2 class="page-header" style="background-color:grey;">This a page title</h2>
<h1 class="page-header">This a second page h1</h1>

<br>
<p><a href="/bootstrap.html">This is a link</a></p>
<p><a href="/asdf">This is not visited</a></p>
<br>

<div class="container" style="margin-top:30px">
    <table class="table table-striped table-success table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">First</th>
            <th scope="col">Last</th>
            <th scope="col">Handle</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>Jacob</td>
            <td>Thornton</td>
            <td>@fat</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td colspan="2">Larry the Bird</td>
            <td>@twitter</td>
        </tr>
        </tbody>
    </table>
    <button type="button" class="btn btn-primary">Save</button>
    <button type="button" class="btn btn-secondary">Cancel</button>
</div>

<jsp:include page="include/footer.jsp" />