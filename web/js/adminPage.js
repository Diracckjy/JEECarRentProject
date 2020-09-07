var foot, windowH, bodyH
foot = document.getElementsByTagName('footer')[0];
function footer() {
    windowH = document.documentElement.clientHeight;
    bodyH = document.body.offsetHeight;
    bodyH < windowH ? (foot.style.position = 'fixed', foot.style.bottom = '0') : (foot.style.position = '');
}
footer();
window.onresize = function () { footer(); }