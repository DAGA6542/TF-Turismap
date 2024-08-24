let searchBtn = document.querySelector('#search-btn');
let searchBar = document.querySelector('.barra-busqueda');
let formBtn = document.querySelector('#login-btn');
let loginForm = document.querySelector('.inicio-sesion');
let formClose = document.querySelector('#form-close');
let menu = document.querySelector('#menu-bar');
let navbar = document.querySelector('.navbar');
let videoBtn = document.querySelectorAll('.vid-btn');



window.onscroll =()=>{
    searchBtn.classList.remove('fa-times');
    searchBar.classList.remove('active');
    menu.classList.remove('fa-times');
    navbar.classList.remove('active');
    loginForm.classList.remove('active');

}
/*Parte del navbar esa barrita de 3 lineas*/ 
menu.addEventListener ('click', () =>{
    menu.classList.toggle('fa-times');
    navbar.classList.toggle('active');
});

/*Parte de la barra de busqueda*/
searchBtn.addEventListener ('click', () =>{
    searchBtn.classList.toggle('fa-times');
    searchBar.classList.toggle('active');
});

formBtn.addEventListener ('click', () =>{
    loginForm.classList.add('active');
});
formClose.addEventListener ('click', () =>{
    loginForm.classList.remove('active');
});

videoBtn.forEach(btn =>{
    btn.addEventListener('click', ()=>{
    document.querySelector('.control .active').classList.remove('active'); /**/ 
    btn.classList.add('active');
    let src = btn.getAttribute('data-src');
    document.querySelector('#video-slider').src = src;
    });
});

document.querySelectorAll('.contact .row .faq .box h3').forEach(faqBox => {
    faqBox.onclick = () =>{
       faqBox.parentElement.classList.toggle('active');
    }
});


 
var swiper = new Swiper(".brand-slider", {
    spaceBetween: 20,
    loop:true,
    autoplay:{
        delay: 2500,
        disableOnInteraction: false,
    },
    breakpoints:{
        450:{
            slidesPerView: 2,
        },
        768:{
            slidesPerView: 3,
        },
        991:{
            slidesPerView: 4,
        },
        1200:{
            slidesPerView: 5,
        },

    },
 });
 
