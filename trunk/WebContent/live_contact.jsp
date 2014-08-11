<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script src="//js.live.net/v5.0/wl.js"></script>
<script language="javascript">

function streamlineAccountReg_onClick() {
    WL.login({
        scope: ["wl.signin", "wl.basic", "wl.birthday", "wl.emails"]
    }).then(
        function (response) {
            WL.api({
                path: "me",
                method: "GET"
            }).then(
                function (response) {
                    document.getElementById("first_name").innerText = response.first_name;
                    document.getElementById("last_name").innerText = response.last_name;
                    document.getElementById("email").innerText = response.emails.preferred;
                    document.getElementById("gender").innerText = response.gender;
                    document.getElementById("birthday").innerText =
                        response.birth_month + " " + response.birth_day + " " + response.birth_year;
                },
                function (responseFailed) {
                    document.getElementById("infoArea").innerText =
                        "Error calling API: " + responseFailed.error.message;
                }
            );
        }, 
        function (responseFailed)
        {
            document.getElementById("infoArea").innerText =
                "Error signing in: " + responseFailed.error_description;
        }
    );
}


function readContact_onClick() {
	WL.init({
	    client_id: "000000004C121B52",
	    redirect_uri: "http://localhost:8080/SpringHibernateMySQL/live_contact.jsp",
	    scope: "wl.signin", 
	    response_type: "token"
	});
	
    WL.login({
        scope: "wl.basic"
    }).then(
        function (response) {
            WL.api({
                path: "contact.83960a61000000000000000000000000",
                method: "GET"
            }).then(
                function (response) {
                    document.getElementById("resultDiv").innerHTML =
                        "ID: " + response.id +
                        "<br/>Name: " + response.first_name +
                        " " + response.last_name;
                },
                function (responseFailed) {
                    document.getElementById("infoArea").innerText =
                        "Error calling API: " + responseFailed.error.message;
                }
            );
        },
        function (responseFailed) {
            document.getElementById("infoArea").innerText =
                "Error signing in: " + responseFailed.error_description;
        }
    );
}
</script>

<input type="button" value="streamlineAccountReg" onclick="streamlineAccountReg_onClick();"></input>
<input type="button" value="readContact" onclick="readContact_onClick();"></input>
<div id="resultDiv"></div>
<span id="infoArea"></span>
</body>
</html>