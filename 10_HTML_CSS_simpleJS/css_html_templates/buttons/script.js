
/* Snippet ===============================================================================================================================*/
// waves-button

const wavesButton = document.querySelector(".waves-button");

wavesButton.addEventListener("mousemove", (e) => {
    let posX = e.offsetX;
    let posY = e.offsetY;
    console.log(posX, posY);
})

wavesButton.addEventListener("mousemove", (e) => {
    mousePositionToCustomProp(e, wavesButton);
})

wavesButton.addEventListener('animationend', () => {
    wavesButton.classList.remove('pulse');
})

wavesButton.addEventListener("click", (e) => {
    mousePositionToCustomProp(e, wavesButton);
    wavesButton.classList.add('pulse');

})

function mousePositionToCustomProp(event, element) {
    let posX = event.offsetX;
    let posY = event.offsetY;

    element.style.setProperty("--x", posX + "px");
    element.style.setProperty("--y", posY + "px");
}

/* Snippet ===============================================================================================================================*/

const syncPointer = ({x: pointerX, y: pointerY}) => {
    const x = pointerX.toFixed(2)
    const y = pointerY.toFixed(2)
    const xp = (pointerX / window.innerWidth).toFixed(2)
    const yp = (pointerY / window.innerHeight).toFixed(2)
    document.documentElement.style.setProperty('--x', x)
    document.documentElement.style.setProperty('--xp', xp)
    document.documentElement.style.setProperty('--y', y)
    document.documentElement.style.setProperty('--yp', yp)
}

// document.body.addEventListener('pointermove', syncPointer)

document.getElementById("bg-buttons").addEventListener('pointermove', syncPointer)

/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
/* Snippet ===============================================================================================================================*/
