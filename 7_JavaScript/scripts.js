(function test() {
    console.log('hello')
}());                                           // declare and run function instantly

document.designMode = 'on'                      // turn on god mode in browser
getEventListeners(document)                     // list all event listeners

/* Snippet ===============================================================================================================================*/

function test() {                               // declare logic
    console.log('hello')
}
test()                                          // call the function when file is started

/* Snippet ===============================================================================================================================*/
function addNumbers(a, b) {
    return a + b;
}
var sum = addNumbers(10, 15);
console.log('Sum of the two numbers is: ' + sum);

// declaration order

/* Snippet ===============================================================================================================================*/
function rotateContentTransition(){
    document.documentElement.style.transitionDuration="3600s";
    document.documentElement.style.transitionTimingFunction="linear";
    document.documentElement.style.transformOrigin="50% 50%";
    document.documentElement.style.transform="rotate(14400deg)";
}

// rotate website

/* Snippet ===============================================================================================================================*/

var newCSS = '* { outline: 5px red solid}';
var head = document.head || document.getElementsByTagName('head')[0];
var style = document.createElement('style');
style.innerHTML = newCSS
head.appendChild(style);

// append new style file to document

/* Snippet ===============================================================================================================================*/

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

// search for specific element by name ?

/* Snippet ===============================================================================================================================*/

setTimeout(function() {
    your_func();

},3000);

function your_func() {
    console.log('HELLO ')
}

// timed out (delay) functions

/* Snippet ===============================================================================================================================*/

function oneSecondFunction() {
    console.log('HELLO ')
}

var timer = setInterval(function () {
    oneSecondFunction()
}, 1000);

clearInterval(timer);

// run code every second & stop it after

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

// remove elements from DOM

/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
