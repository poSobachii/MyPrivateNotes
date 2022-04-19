// const sky = document.querySelector("#skybox");
// const jet = document.querySelector("#jet");

// el.addEventListener("mousemove", (e) => {
//     el.style.setProperty('--x', -e.offsetX + "px");
//     el.style.setProperty('--y', -e.offsetY + "px");
// });

// sky.addEventListener("mousemove", (e) => {
//     sky.style.backgroundPositionX = -e.offsetX/10 + "px";
//     sky.style.backgroundPositionY = -e.offsetY/100 +  "px";
// });
//
// jet.addEventListener("mousemove", (e) => {
//     jet.style.transform ="translateX(100px)";
// });
// document.getElementById("nuclear").style.transform ="translateX(" + e.clientX/50 + "px)";


function myFunction(e) {
    document.getElementById("skybox").style.backgroundPositionX = -e.offsetX/20 + "px";
    document.getElementById("jet").style.transform ="translateX(" + (-e.offsetX/10) + "px)";
    document.getElementById("missile").style.transform ="translateX(" + (-e.offsetX/5) + "px)";
    document.getElementById("clouds_1").style.transform ="translateX(" + (-e.offsetX/7) + "px)";
    document.getElementById("clouds_2").style.transform ="translateX(" + (-e.offsetX/9) + "px)";
}




