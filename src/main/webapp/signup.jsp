<%--
  Created by IntelliJ IDEA.
  User: hsenid
  Date: 4/18/16
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/css/bootstrap.min.css"
      rel="stylesheet" type="text/css" />
<link href="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
      rel="stylesheet" type="text/css" />

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Register</title>



    <title>Sign Up</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<link href="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/css/bootstrap.min.css"
      rel="stylesheet" type="text/css" />
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
<link href="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
      rel="stylesheet" type="text/css" />
<script src="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/js/bootstrap-multiselect.js"
        type="text/javascript"></script>

<jsp:include page="header.jsp" />

<fmt:bundle basename="jstl_fmt">

<body onload='document.form1.fname.focus()'>

<div class="top-content">


    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1>Translator Sign Up</h1>

                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Sign Up</h3>

                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-lock"></i>
                        </div>
                    </div>
                    <form role="form" name="form1" action="Registration" method="post" class="signup-form">

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
                            <!--<script> $('#defaultPopup,#defaultInline').datepick();</script>-->

                            <div class="form-group">
                                <input type="email" name="email" class="bootbox-input bootbox-input-email form-control" placeholder="example@domain.com" id="e_mail"
                                       required>
                            </div>

                            <div class="form-group">

                               <%-- <%@include file="date1.jsp" %>--%>
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

                            </div
                            <form action="" name="someform">
                                <%--<select id="daydropdown">
                                </select>
                                <select id="monthdropdown">
                                </select>
                                <select name="datepick" id="yeardropdown">
                                </select>--%>
                            </form>



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



                              <%--<input name="country" placeholder="Select Your Country" id="country"
                                       style="position:absolute;top:0px;left:0px;width:183px;width:180px\9;#width:180px;height:23px; height:21px\9;#height:18px;border:1px solid #556;"
                                       onfocus="this.select()" type="text" required>--%>

<%--
                                <input name="idValue" id="idValue" type="hidden">
--%>

</div>
<%--
                            <div id="second_dropdown_code">This text will be replaced by second City dropdown.</div>
--%>
                            <div class="col-md-4">
                                <select id="city" name="city" class="form-control">




                                </select>
                               <%-- <input name="city" placeholder="Select Your city" id="city"
                                       style="position:absolute;top:0px;left:0px;width:183px;width:180px\9;#width:180px;height:23px; height:21px\9;#height:18px;border:1px solid #556;"
                                       onfocus="this.select()" type="text" required>--%>
<%--
                                <label id="city1" class="input-group-error form-error"></label>
--%>
                            </div>
    <script type="text/javascript">
        $(function () {
            $('#group').multiselect({
                includeSelectAllOption: true
            });
            $('#grpSelected').click(function () {
                var selected = $("#group option:selected");
                var message = "";
                selected.each(function () {
                    message += $(this).text() + " " + $(this).val() + "\n";
                });
                alert(message);
            });
        });
    </script>

                            <div class="form-group">

                                <select name="group" id="group" multiple="multiple" >
                                    <option>Administrator</option>
                                    <option>Customercare</option>
                                    <option>Translator</option>
                                    <option>Basic user</option>
                                </select>
                                <input type="button" id="grpSelected" value="Get Selected" />
                           <%-- <script type="text/javascript">
                                $(function () {
                                    $('#lstFruits').multiselect({
                                        includeSelectAllOption: true
                                    });
                                    $('#btnSelected').click(function () {
                                        var selected = $("#lstFruits option:selected");
                                        var message = "";
                                        selected.each(function () {
                                            message += $(this).text() + " " + $(this).val() + "\n";
                                        });
                                        alert(message);
                                    });
                                });
                            </script>
                            <select id="lstFruits" multiple="multiple">
                                <option value="1">Mango</option>
                                <option value="2">Apple</option>
                                <option value="3">Banana</option>
                                <option value="4">Guava</option>
                                <option value="5">Orange</option>
                            </select>
                            <input type="button" id="btnSelected" value="Get Selected" />--%>
                                <!-- CSS -->

                               <%-- <input name="group" placeholder="Select Your group" id="group"
                                       style="position:absolute;top:0px;left:0px;width:183px;width:180px\9;#width:180px;height:23px; height:21px\9;#height:18px;border:1px solid #556;">

                         <input name="grp_value" id="grp_value" type="hidden">--%>


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

                            <button type="submit" class="btn" id="register_btn"
                                    onclick="allLetter(document.form1.fname&&document.form1.lname)">
                                <fmt:message key="signup.register_btn"> </fmt:message>
                            </button>
                            <button type="reset" class="btn" id="reset_btn">
                                <fmt:message key="signup.reset_btn"> </fmt:message>
                            </button>
                                <button type="submit" class="btn btn-danger" id="del_btn">
                                    <fmt:message key="signup.del_btn"> </fmt:message>
                                </button>
                            </fmt:bundle>

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
                </div>
            </div>
        </div>

    </div>
</div>

</div>


<!-- Javascript -->
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.backstretch.min.js"></script>
<script src="assets/js/scripts.js"></script>
<script src="bootbox.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>

<script src="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/js/bootstrap-multiselect.js"
        type="text/javascript"></script>


<a href=" http://translate.yandex.com/">Powered by Yandex.Translate</a>
</body>

