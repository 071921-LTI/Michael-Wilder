let token = sessionStorage.getItem("token");
document.getElementById("logoutButton").addEventListener("click", LogOut);
function LogOut(){
    sessionStorage.removeItem("token");
    window.location.href="login.html";
}
