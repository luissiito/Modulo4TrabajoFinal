
const body = document.querySelector('body');
const iconoDeMenu = document.createElement('img');
const header = document.querySelector('header');
const botonSwitchHeader = document.createElement('button');
let avisador = false;

botonSwitchHeader.classList.add('BotonSwitchCabecera');
botonSwitchHeader.appendChild(iconoDeMenu);
iconoDeMenu.src = "/Modulo4TrabajoFinal/Imagenes/ICONO DE MENU.png";
body.appendChild(botonSwitchHeader);

if(screen.width <= 550){
    header.style.display = 'none';
    botonSwitchHeader.style.display = 'block';
    
}
if(screen.width > 550){
    header.style.display = 'block';
    botonSwitchHeader.style.display = 'none';

}
botonSwitchHeader.addEventListener('click', ()=>{
    if(avisador){
        header.style.display = 'none';  
        avisador = false;
    }else{
        header.style.display = 'block';  
        avisador = true;
    }
});
        /* Autor: Luis González*/