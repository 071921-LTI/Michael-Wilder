document.getElementById('submitButton').addEventListener('click', login);

function login(){

    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;

    let user = {
        username: username,
        password: password
    }

    let url = 'http://localhost:8080/Project1/auth/login';

    let xhr = new XMLHttpRequest();

    xhr.open("POST", url);

    xhr.onreadystatechange = function(){
        if (xhr.readyState === 4 && xhr.status == 200){
            
            let authToken = xhr.getResponseHeader("Authorize");
            
            sessionStorage.setItem('token', authToken);
            
            window.location.href = 'manager.html';

        } else if (xhr.readyState === 4 && xhr.status == 209){
            let authToken = xhr.getResponseHeader("Authorize");
            
            sessionStorage.setItem('token', authToken);
            
            window.location.href = 'employee.html';
        }
        else if (xhr.readyState === 4){
            let error = xhr.getResponseHeader("Authorize");
            let errorField = document.getElementById('error');

            if (error == "username" || error == "password"){
                errorField.innerHTML = 'Wrong username/password';
                document.getElementById("loginForm").reset();
            }
        }
    }

    xhr.send(JSON.stringify(user));

    
}