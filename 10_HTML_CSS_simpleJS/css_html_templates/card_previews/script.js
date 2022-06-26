document.addEventListener('DOMContentLoaded', function() {
    var photoBird = "../../zAssets/images/animals/bird.jpeg";
    var photoParrot = "../../zAssets/images/animals/parrot.jpeg";
    var photoElephant = "../../zAssets/images/animals/elephant.jpeg";
    var photoFox = "../../zAssets/images/animals/fox.jpeg";

    // document.getElementById('img1').src = photoBird;
    // document.getElementById('img2').src = photoParrot;
    // document.getElementById('img3').src = photoElephant;
    // document.getElementById('img4').src = photoFox;

    // const birdClass = document.querySelectorAll(".img-bird");
    // birdClass.forEach(function(tag) {
    //     tag.src = photoBird
    //     console.log(tag)
    // });

    let photoList = document.querySelectorAll('[photo]');
    photoList.forEach(function(element) {
        let animal = element.getAttribute('photo');
        element.src = "../../zAssets/images/animals/" + animal + ".jpeg"
    });
});

/* Snippet ===============================================================================================================================*/

var swiper = new Swiper(".mySwiper", {
    effect: "coverflow",
    grabCursor: true,
    centeredSlides: true,
    slidesPerView: "auto",
    coverflowEffect: {
        rotate: 50,
        stretch: 0,
        depth: 100,
        modifier: 1,
        slideShadows: true,
    },
    pagination: {
        el: ".swiper-pagination",
    },
});

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
