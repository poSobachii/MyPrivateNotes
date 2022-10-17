
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