addEventListener("load", function () {
    setTimeout(hideURLbar, 0);
}, false);

function hideURLbar() {
    window.scrollTo(0, 1);
}
var check = function() {
    if (document.getElementById('password').value ===
        document.getElementById('confirm_password').value) {
        document.getElementById('message').style.color = 'green';
        document.getElementById('message').innerHTML = '密码一致';
        document.getElementById('submit').disabled = false;
        document.getElementById('submit').style.color = 'white';
    } else {
        document.getElementById('message').style.color = 'red';
        document.getElementById('message').innerHTML = '密码不一致';
        document.getElementById('submit').disabled = true;
        document.getElementById('submit').style.color = 'gray';
    }
}