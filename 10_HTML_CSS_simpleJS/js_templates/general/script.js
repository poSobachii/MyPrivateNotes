// $0 selects most recent selected element

document.designMode = 'on'

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

/* Snippet ===============================================================================================================================*/

function removeCookies() {
    let cookies = document.getElementsByClassName("cookie-container");
    for (let i = 0; i < cookies.length; i++) {
        cookies[i].remove();
    }
    // $(cookies[cookies.length - 1]).remove();
}

function removeCookies() {
    let cookies = document.getElementsByClassName("cookie-container");
    for (let i = 0; i < cookies.length; i++) {
        cookies[i].remove();
    }
    let block = document.querySelector("div[data-v-94dbd2d8]")
    block.remove();
    document.body.style.overflow = 'visible'
}

document.getElementsByName('body').style.overflow = 'visible';

function test() {
    console.log('hello')
}

setTimeout(function() {
    your_func();

},3000);

function your_func() {
    console.log('HELLO ')
}

function searchTree(element, matchingTitle){
    console.log('search started')
    console.log('with element' + element)
    if(element.title == matchingTitle){
        console.log('smth is found')
        return element;
    }else if (element.children != null){
        console.log('searching....')
        var i;
        var result = null;
        for(i=0; result == null && i < element.children.length; i++){
            console.log('searching....')
            result = searchTree(element.children[i], matchingTitle);
        }
        return result;
    }
    console.log('nothing was found')
    return null;
}

/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/



