function changeTextBg() {
    var checked = document.getElementById("checked");
    if(checked.checked) {
        document.getElementById('text').style.backgroundColor = 'cyan';
    } else {
        document.getElementById('text').style.backgroundColor = 'yellow';
    }
}
