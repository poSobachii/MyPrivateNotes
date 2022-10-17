
/* Snippet ===============================================================================================================================*/

const pulseCircle = document.querySelector('.pulsing-circle');
const wave1 = document.querySelector('.pulsing-circle-wave');
const wave2 = document.querySelector('.offset-wave-1');

pulseCircle.addEventListener('click', function(e) {
    e.preventDefault();
    pulseCircle.classList.toggle('paused');
    wave1.classList.toggle('paused');
    wave2.classList.toggle('paused');
});

/* Snippet ===============================================================================================================================*/

const hours = document.querySelector('.hours');
const minutes = document.querySelector('.minutes');
const seconds = document.querySelector('.seconds');

function clock(){
    let today = new Date();
    let h = (today.getHours() % 12) + today.getMinutes() / 59; // 22 % 12 = 10pm
    let m = today.getMinutes();
    let s = today.getSeconds();

    // let m = today.getMinutes() + today.getSeconds() / 59;
    // let s = today.getSeconds() + today.getMilliseconds() / 1000;         // smooth minutes, seconds

    h *= 30; // 12 * 30 = 360deg
    m *= 6;
    s *= 6; // 60 * 6 = 360deg

    rotation(hours, h);
    rotation(minutes, m);
    rotation(seconds, s);

    setTimeout(clock, 500);
}

function rotation(target, val){
    target.style.transform =  `rotate(${val}deg)`;
}

window.onload = clock();


// const hours = document.querySelector('.hours');
// const minutes = document.querySelector('.minutes');
// const seconds = document.querySelector('.seconds');
//
// clock = () => {
//     let today = new Date();
//     let h = (today.getHours() % 12) + today.getMinutes() / 59; // 22 % 12 = 10pm
//     let m = today.getMinutes();
//     let s = today.getSeconds();
//
//     // let m = today.getMinutes() + today.getSeconds() / 59;
//     // let s = today.getSeconds() + today.getMilliseconds() / 1000;         // smooth minutes, seconds
//
//     h *= 30; // 12 * 30 = 360deg
//     m *= 6;
//     s *= 6; // 60 * 6 = 360deg
//
//     rotation(hours, h);
//     rotation(minutes, m);
//     rotation(seconds, s);
//
//     setTimeout(clock, 500);
// }
//
// rotation = (target, val) => {
//     target.style.transform =  `rotate(${val}deg)`;
// }
//
// window.onload = clock();


/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
