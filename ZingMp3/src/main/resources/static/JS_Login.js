
function openLoginForm() {
    document.body.classList.add("showLoginForm");
    $("#formRegister").hide();
}

function closeLoginForm() {
    document.body.classList.remove("showLoginForm");
}

$("#showPass1").click(function (){
    let currentType=$("#password").attr("type");
    console.log(currentType)
    $("#password").attr("type",
        currentType==="password"?"text":"password");
})
$("#showPass2").click(function (){
    let currentType=$("#password_regis").attr("type");
    console.log(currentType)
    $("#password_regis").attr("type",
        currentType==="password"?"text":"password");
})
$("#showPass3").click(function (){
    let currentType=$("#re-password_regis").attr("type");
    console.log(currentType)
    $("#re-password_regis").attr("type",
        currentType==="password"?"text":"password");
})
$("#btn_signup").click(function (){
    $("#formLogin").hide();
    $("#formRegister").show();
})
$("#btn_login2").click(function (){
    $("#formLogin").show();
    $("#formRegister").hide();
})

$("#btn_login").click(function (){
    let username = $("#username").val();
    let password = $("#password").val();
    let user = {
        "username": username,
        "password": password
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/api/login",
        data: JSON.stringify(user),
        success: function (data) {
            console.log(data.token)
            localStorage.setItem('token', data.token)
            loadToken(data.token)
        }
    })
})


function loadToken(token) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/list",
        headers: {"Authorization": 'Bearer ' + token},
        success: function (data) {
            console.log(data);
        }
    })
}

$("#btn_register").click(function (){
    register();
})

function register() {
    let username = $("#username_regis").val();
    let password = $("#password_regis").val();
    let confirmedPassword = $("#re-password_regis").val();
    if (password != confirmedPassword) alert("Confirmed password is different password")
    else {
        let user = {
            username: username,
            password: password
        };
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/api/register",
            data: JSON.stringify(user),
            success: function () {
                alert("new user is created")
            },
            error: function (e) {
                alert("server error in create: " + e);
            }
        })
    }
}