// SELECTORS

function select_1() {
    let elems = document.querySelectorAll('h1,div');
    for (let i = 0; i < elems.length; i++) {
        console.log('selected component = ' + elems[i])
    }
}

function select_2() {
    let elem = document.querySelector('.cname');
    console.log('selected component = ' + elem)
}

function select_3() {
    let elem = document.getElementsByTagName('h1');
    console.log('selected component = ' + elem)
}

function select_4() {
    let elem= document.getElementsByClassName('cname');
    console.log('selected component = ' + elem)
}

function select_5() {
    let elem = document.getElementById('idname');
    console.log('selected component = ' + elem)
}