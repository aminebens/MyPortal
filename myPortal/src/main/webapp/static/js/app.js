'use strict';

$.material.init();

var activeChk = document.getElementById("active");
var activeSpan = document.getElementById("activeSpan");

window.onload = init();

function init() {
    activeAccount();
    console.dir(activeChk.checked);
}

activeChk.onclick = function () {
    console.dir(activeChk.checked);
    activeAccount();
};

function activeAccount() {
    if (activeChk.checked) {
        console.dir(activeSpan);
        activeSpan.innerHTML = "Active";  
        activeSpan.style.color = "green";
    } else {
        activeSpan.innerHTML = "Deactive";
        activeSpan.style.color = "grey";
    }
}
