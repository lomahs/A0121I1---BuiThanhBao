var a = document.getElementById("forClick");
// a.addEventListener("click",clickChange);

// function clickChange() {
//     alert("Hello");
// }

a.addEventListener("", focusChange);

function focusChange() {
 a.innerHTML = "You are focusing on me"
}