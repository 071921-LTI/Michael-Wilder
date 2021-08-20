  
let token = sessionStorage.getItem("token");

document.getElementById("logoutButton").addEventListener("click", LogOut);
function LogOut(){
    sessionStorage.removeItem("token");
    window.location.href="login.html";
}
function getReimbs() {

    let xhr = new XMLHttpRequest();

    let url = "http://localhost:8080/Project1/reimb/PR";

    xhr.open("GET", url);

    xhr.setRequestHeader("Authorize", token);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {
            let response = xhr.responseText;
            response = JSON.parse(response);
            let tbody = document.getElementById("tableBody");



            for (i = response.length-1; i >= 0; i--) {
                console.log(response[i]);
                let tr = document.createElement('tr');
                tr.style.display = "";
     

                tr.setAttribute("id", response[i].reimbId);
                
                let amount = document.createElement('td');
                let description = document.createElement('td');
                let timeSub = document.createElement('td');
                let timeRes = document.createElement('td');
                let subBy = document.createElement('td');
                let resBy = document.createElement('td');
                let status = document.createElement('td');
                let type = document.createElement('td');

                
                amount.innerHTML = "$" + response[i].reimbAmount;
                description.innerHTML = response[i].reimnbDes;
                timeSub.innerHTML = getTimestamp(response[i].reimbSub);
                timeRes.innerHTML = getTimestamp(response[i].reimbRes);
                subBy.innerHTML = response[i].author.firstName + " " + response[i].author.lastName;
                resBy.innerHTML = getResolver(response[i].resolver);
                status.innerHTML = response[i].statId.status;
                type.innerHTML = response[i].typeId.type;
                
                
                
                tr.appendChild(amount);
                tr.appendChild(description);
                tr.appendChild(timeSub);
                tr.appendChild(timeRes);
                tr.appendChild(subBy);
                tr.appendChild(resBy);
                tr.appendChild(status);
                tr.appendChild(type);
                tbody.appendChild(tr);
            }



        } else if (xhr.readyState === 4) {
            console.log("Something went wrong");
        }
    }

    xhr.send();

}
function getResolver(resolver) {
    if (resolver == null) {
        return "Not Resolved";
    } else {
        return resolver.firstName + " " + resolver.lastName;
    }
}

function getTimestamp(timestamp) {
    if (timestamp == null) {
        return "Not Resolved";
    } else {
        var d = new Date(timestamp);
        var formattedDate = d.getMonth() + "-" + d.getDate() + "-" + d.getFullYear();
        var hours = (d.getHours() < 10) ? "0" + d.getHours() : d.getHours();
        if (hours > 12) { hours -= 12; }
        if (hours === 0) { hours = 12; }
        var minutes = (d.getMinutes() < 10) ? "0" + d.getMinutes() : d.getMinutes();
        var formattedTime = hours + ":" + minutes;
        formattedDate = formattedDate + " " + formattedTime;
        return formattedDate;
    }
}
getReimbs();