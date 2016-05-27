<%--
  Created by IntelliJ IDEA.
  User: hsenid
  Date: 5/5/16
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<%--<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#editmodal">Open Modal</button>
<div class="modal" id="editmodal" role="dialog">--%>
<fmt:bundle basename="jstl_fmt">

    <form role="form" name="form1" action="UserEditServlet" method="post" class="signup-form">
<h3>Edit user</h3>
        <div class="form-bottom">
            <div class="form-group">
                <label class="sr-only">firstname :</label>
                <input type="text" name="f_name" placeholder="first name..." id="f_name" size="25"
                       required>
            </div>
            <div class="form-group">
                <label class="sr-only">lastname :</label>
                <input type="text" name="lname" placeholder="last name..."
                       class="bootbox-input bootbox-input-text form-control" id="l_name">
            </div>

            <div class="form-group">
                <input type="email" name="email" class="bootbox-input bootbox-input-email form-control" placeholder="example@domain.com" id="e_mail"
                       required>
            </div>

            <div class="form-group">

                <div class="col-sm-8">
                    <label for="date2">DOB</label><input class="form-control" id="date2" name="date2" type="text" required/>
                </div>



                <script>
                    $('#date2').daterangepicker({


                        "singleDatePicker": true,
                        "showDropdowns": true,
                        "startDate": "05/09/2016"

                    });

                </script>

            </div>
           



            <div class="form-group">
                <input type="text" name="phonenumber" class="form-control"
                       placeholder="Enter your phone number" id="mobile"required>
            </div>

            <div class="form-group"
                 style="position:relative;width:200px;height:25px;border:0;padding:0;margin:10px;">
                <select id="first-choice" name="dd1" style="position:absolute;top:0px;left:0px;width:200px; height:25px;line-height:20px;margin:0;padding:0;"
                        onchange="document.getElementById('country').value=this.options[this.selectedIndex].text; document.getElementById('idValue').value=this.options[this.selectedIndex].value;dd1change(this)">
                    <option value="base">Select Your Country</option>
                    <option value="SriLanka">SriLanka</option>
                    <option value="Japan">Japan</option>
                    <option value="England">England</option>
                    <option value="Korea">Korea</option>
                    <option value="USA">USA</option>

                </select>





            </div>

            <div class="col-md-4">
                <select id="city" name="city" class="form-control">




                </select>

            </div>

            <div class="form-group">

                <select name="group">
                    <option>Administrator</option>
                    <option>Customercare</option>
                    <option>Translator</option>
                    <option>Basic user</option>
                </select>


            </div>

            <div class="form-group">
                <label class="sr-only">Username</label>
                <input type="text" name="uname" placeholder="username..."
                       class="form-username form-control" id="form-uname" required>
            </div>
            <div class="form-group">
                <label class="sr-only" for="form-password">Password</label>
                <input type="password" name="password" placeholder="Password..."
                       class="form-password form-control" id="form-password" required>
            </div>
            <div class="form-group">
                <label class="sr-only" for="form-password">Re-enterPassword</label>
                <input type="password" name="form-password" placeholder="Re-enter Password..."
                       class="form-password form-control" id="form-conpassword" required>

            </div>

            <button type="submit" class="btn" id="edit_btn"
                    onclick="allLetter(document.form1.fname&&document.form1.lname)">
                <fmt:message key="signup.edit_btn"> </fmt:message>
            </button>

            <%--<button type="submit" class="btn btn-danger" id="del_btn">
                <fmt:message key="signup.del_btn"> </fmt:message>
            </button>--%>
           

        </div>
        <script src="assets/js/date.js"></script>

        <script>
            $("#first-choice").change(function() {

                var $dropdown = $(this);

                $.getJSON("js/data.json", function(data) {

                    var key = $dropdown.val();
                    var vals = [];

                    switch(key) {
                        case 'SriLanka':
                            vals = data.SriLanka.split(",");
                            break;
                        case 'Japan':
                            vals = data.Japan.split(",");
                            break;
                        case 'England':
                            vals = data.England.split(",");
                            break;
                        case 'Korea':
                            vals = data.Korea.split(",");
                            break;
                        case 'USA':
                            vals = data.USA.split(",");
                            break;
                        case 'base':
                            vals = ['Please choose from above'];
                    }

                    var $secondChoice = $("#city");
                    $secondChoice.empty();
                    $.each(vals, function(index, value) {
                        $secondChoice.append("<option>" + value + "</option>");
                    });

                });
            });
        </script>


</form>
</fmt:bundle>


<!-- Javascript -->
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.backstretch.min.js"></script>
<script src="assets/js/scripts.js"></script>
<script src="bootbox.js"></script>


