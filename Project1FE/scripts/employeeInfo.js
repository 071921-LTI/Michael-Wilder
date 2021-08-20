let token = sessionStorage.getItem("token");
document.getElementById("logoutButton").addEventListener("click", LogOut);
function LogOut(){
    sessionStorage.removeItem("token");
    window.location.href="login.html";
}


let username = document.getElementById("username");
let password = document.getElementById("password");
let first = document.getElementById("first");
let last = document.getElementById("last");
let email = document.getElementById("email");

document.getElementById("editButton").addEventListener("click", update)

let url = "http://localhost:8080/Project1/users/info";



function update() {


    let newUser = {
        username: username.value,
        password: password.value,
        firstName: first.value,
        lastName: last.value,
        email: email.value,
    }

    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8080/Project1/users/info";
    xhr.open('PUT', url);

    xhr.onreadystatechange = function(){
        if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300){

            let authToken = xhr.getResponseHeader("Authorize");

            sessionStorage.removeItem('token');
            sessionStorage.setItem('token', authToken);
            document.getElementById("success").innerHTML = "Update success!";

        }else if (xhr.readyState === 4){
           document.getElementById("error").innerHTML = "There was an error.";
        }
    }

    let reqBody = JSON.stringify(newUser);

    xhr.setRequestHeader("Authorize", token);

    xhr.send(reqBody);
    setTimeout(function(){location.reload()}, 500);

}

function getUser() {

    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8080/Project1/users/info";
    xhr.open("GET", url);

    xhr.setRequestHeader("Authorize", token);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {


            let response = xhr.responseText;
            response = JSON.parse(response);
            let tbody = document.getElementById("tableBody1");

          
                let tr = document.createElement('tr');
                tr.style.display = "";

                tr.setAttribute("id", response.userId);
                
                let username = document.createElement('td');
                let password = document.createElement('td');
                let first = document.createElement('td');
                let last = document.createElement('td');
                let email = document.createElement('td');  


                
                username.innerHTML = response.username;
                password.innerHTML = response.password;
                first.innerHTML = response.firstName;
                last.innerHTML = response.lastName;
                email.innerHTML = response.email;

                
                
                tr.appendChild(username);
                tr.appendChild(password);
                tr.appendChild(first);
                tr.appendChild(last);
                tr.appendChild(email);

                tbody.appendChild(tr);
          

        } else if (xhr.readyState === 4) {
            console.log("Something went wrong");
            return null;
        }
    }

    xhr.send();

}
getUser();
