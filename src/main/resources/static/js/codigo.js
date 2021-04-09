$(document).ready(function(){
	rotacion();
	
});

const text = document.querySelector('.fancy');
const strText = text.textContent;
const splitText = strText.split("");

text.textContent = "";

for(let i=0; i<splitText.length; i++){
	text.innerHTML += "<span>"+splitText[i]+"</span>";
}

let char = 0;
let timer = setInterval(onTick,50);

function onTick(){
	const span = text.querySelectorAll('span')[char];
	span.classList.add('fade');
	char++;
	
	if(char === splitText.length){
		complete();
		return;
	}
}

function complete(){
	clearInterval(timer);
	timer = null;
}

/*Responsive*/
let boton = document.getElementById("icono");
let enlaces = document.getElementById("enlaces");
let contador = 0;

boton.addEventListener("click",function(){
    if(contador == 0){
        enlaces.className = ('enlaces dos');
        contador=1;
        boton.style.position= "fixed";
        boton.style.right= "0px";
    }else{
        enlaces.classList.remove('dos');
        enlaces.className = ('enlaces uno');
        contador = 0;
        boton.style.position= "static";
    }
})

window.addEventListener('resize', function(){
    if(screen.width > 750){
        contador=0;
        enlaces.classList.remove('dos');
        enlaces.className = ('enlaces uno');

    }
})

	/*Carrusel*/
	var imgs = ["main_p.png","clase.png","musica.png","azar.png","rewards.png","editar_clase.png","pdf_clase.png","reporte.png","pdf_estudiante.png"];

	var c=0;
	function rotacion(){
		
		
		$("#imgBanner").attr("src","imagenes/carrusel/" + imgs[c]);
		c++;
		if (c==imgs.length){
			c=0;	
		} 
		setTimeout("rotacion()",4000);
	}

