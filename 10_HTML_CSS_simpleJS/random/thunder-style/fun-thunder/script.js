

function myFunction(e) {
    let mousePointer = e.clientX - window.innerWidth/2;
    document.getElementById("nuclear").style.transform ="translateX(" + mousePointer/70 + "px)";
    document.getElementById("nuclear_explosion").style.transform ="translateX(" + mousePointer/60 + "px)";
    document.getElementById("explosion_2").style.transform ="translateX(" + mousePointer/25 + "px)";
    document.getElementById("black_smoke_1").style.transform ="translateX(" + mousePointer/15 + "px)";
    document.getElementById("black_smoke_2").style.transform ="translateX(" + mousePointer/30 + "px)";
    document.getElementById("white_smoke").style.transform ="translateX(" + mousePointer/30 + "px)";
    document.getElementById("horizon").style.transform ="translateX(" + mousePointer/70 + "px)";
    document.getElementById("tank_smoke").style.transform ="translateX(" + mousePointer/40 + "px)";
    document.getElementById("tank").style.transform ="translateX(" + mousePointer/40 + "px)";
    document.getElementById("particles_3").style.transform ="translateX(" + mousePointer/13 + "px)";
    document.getElementById("hoomans").style.transform ="translateX(" + mousePointer/25 + "px)";
    document.getElementById("particles_4").style.transform ="translateX(" + mousePointer/3 + "px)";
    document.getElementById("particles_1").style.transform ="translateX(" + mousePointer/9 + "px)";
    document.getElementById("particles_2").style.transform ="translateX(" + mousePointer/9 + "px)";
}




