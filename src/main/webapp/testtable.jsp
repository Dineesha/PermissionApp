<table data-toggle="table" id="table"

<%--
                  data-url="http://mikepenz.com/jsfiddle"
--%>
       data-url="js/searchdata.json"



<%--
                  data-url=" <c:set var="data-url" scope="session" value="request.getAttribute(file)"/>"
--%>

       data-pagination="true"
       data-side-pagination="server"
       data-page-list="[5, 10, 20,25, 50, 100, 200]"
       data-search="true"
       data-live-search="true"
       data-search-on-enter-key="true"
       data-height="600"
       data-sortable="true"
       data-sort-order="asc"
       data-show-refresh="true"
       data-show-toggle="true"
       data-show-columns="true"
       data-toolbar="#toolbar">
  <thead>
  <tr style="color: Highlight">
    <%--<th data-field="fn" data-sortable="true" >Firstname</th>
    <th data-field="ln" data-sortable="true" >Lastname</th>
    <th data-field="em">E-mail</th>
    <th data-field="bd" data-sortable="true" >DOB</th>
    <th data-field="ph" data-sortable="true" >Phone</th>

    <th data-field="cn">Country</th>
    <th data-field="ct">City</th>
    <th data-field="un" data-sortable="true" >Username</th>

    <th data-field="gr">Group</th>--%>
    <th data-field="city_id" data-sortable="true" >Firstname</th>
    <th data-field="username" data-sortable="true" >Lastname</th>
    <th data-field="phone">E-mail</th>
    <th data-field="lname" data-sortable="true" >DOB</th>
    <th data-field="email" data-sortable="true" >Phone</th>

    <th data-field="dob">Country</th>
    <th data-field="group_id">City</th>
    <th data-field="fname" data-sortable="true" >Username</th>

    <th data-field="country">Group</th>

    <th data-field="action" data-formatter="actionFormatter" data-events="actionEvents">Action</th>
  <tr>               </tr>



  </tr>
  </thead>

</table>
<script>
  var $table = $('#table')
  function actionFormatter(value, row, index) {
    return [
      '<a class="edit ml10" href="javascript:void(0)" title="Edit">',
      '<i class="glyphicon glyphicon-edit"></i>',
      '</a>',
      '<a class="remove" href="#" title="Delete">',
      '<i class="glyphicon glyphicon-remove"></i>',
      '</a>'
    ].join('');
  }

  window.actionEvents = {

    'click .edit': function (e, value, row, index) {
      $('#editmodal').modal('show');
      // window.open("signup.jsp");
      alert('You click edit icon, row: ' + JSON.stringify(row));
      //console.log(value, row, index);
    },
    'click .remove': function (e, value, row, index) {
      if (window.confirm("Do you really want to delete the row?")) {
        $table.bootstrapTable('remove', {
          field: 'id',
          values: [row.id]
        });
        alert('Row has deleted1');
      }
    }
  };


  $(function () {
    $('#table').bootstrapTable({
      data: data1
    });
  });


</script>




</div>

<%--
</form>
--%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Search</title>

<!-- CSS -->
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">-->
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">
<%--
    <link rel="stylesheet" type="text/css" href="assets/css/successDesign.css">
--%>

<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<%-- <link rel="stylesheet" href="assets/bootstrap-table-master/src/bootstrap-table.css">
 <script src="assets/bootstrap-table-master/dist/locale/*"></script>
 <script src="assets/bootstrap-table-master/dist/bootstrap-table-locale-all.js"></script>
 <script src="assets/bootstrap-table-master/dist/bootstrap-table-locale-all.min.js"></script>
 <script src="assets/bootstrap-table-master/dist/bootstrap-table.min.js"></script>
 <link rel="stylesheet" href="assets/bootstrap-table-master/dist/bootstrap-table.min.css">
 <script src="assets/bootstrap/js/jquery-2.2.3.min.js"></script>
 <script src="assets/bootstrap/js/jquery-2.2.3.js"></script>
 <script src="bootstrap-table-zh-CN.js"></script>--%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/bootstrap-table.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/bootstrap-table.min.js"></script>

<!-- Latest compiled and minified Locales -->
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/locale/bootstrap-table-zh-CN.min.js"></script>

<link rel="shortcut icon" href="assets/ico/favicon.png">
<div id="pagination1"> </div>
<%--<div class="col-md-6">
    <ul class="pagination">
        <li class="active"><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
    </ul>
</div>--%>

<script> $(function() {
  $('#pagination1').pagination({
    items: 100,
    itemsOnPage: 10,
    cssStyle: 'light-theme'
  });
});</script>

<!-- Javascript -->
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.backstretch.min.js"></script>
<script src="bootstrap_table.js"></script>


<script type="text/javascript" src="js/jquery.simplePagination.js"></script>
<script type="text/javascript" src="assets/js/jquery-1.11.1.js"></script>

