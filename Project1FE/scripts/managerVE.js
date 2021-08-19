let token = sessionStorage.getItem("token");
document.getElementById("logoutButton").addEventListener("click", LogOut);
function LogOut(){
    sessionStorage.removeItem("token");
    window.location.href="login.html";
}


function getUser() {

    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8080/Project1/users/emp";
    xhr.open("GET", url);

    xhr.setRequestHeader("Authorize", token);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {


            let response = xhr.responseText;
            response = JSON.parse(response);
            let tbody = document.getElementById("tableBody");

            for (i = response.length-1; i >= 0; i--) {
                let tr = document.createElement('tr');
                tr.style.display = "";
     
                tr.className = "clickRows";
                tr.setAttribute("id", response.userId);
                
                let username = document.createElement('td');
                let password = document.createElement('td');
                let name = document.createElement('td');
                let email = document.createElement('td');  
                let role = document.createElement('td');

                
                username.innerHTML = response[i].username;
                password.innerHTML = response[i].password;
                name.innerHTML = response[i].firstName + " " + response[i].lastName;
                email.innerHTML = response[i].email;
                role.innerHTML = response[i].roleId.userRole;
                
                
                tr.appendChild(username);
                tr.appendChild(name);
                tr.appendChild(email);
                tr.appendChild(role);
                tbody.appendChild(tr);
            }

        } else if (xhr.readyState === 4) {
            console.log("Something went wrong");
            return null;
        }
    }

    xhr.send();

}
getUser();
