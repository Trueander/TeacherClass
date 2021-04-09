
let puntosTotal = document.getElementsByClassName('point');

for(let i=0; i<puntosTotal.length;i++){
	if(parseInt(puntosTotal[i].innerText) < 0){
		puntosTotal[i].style.background = "#f92010";
	}else if(parseInt(puntosTotal[i].innerText) > 0){
		puntosTotal[i].style.background = "#4CAF50";
	}
}

var modal = document.getElementById('modal');
var btn = document.getElementById('button');
var closeBtn = document.getElementById('close');

btn.addEventListener('click', openModal);
closeBtn.addEventListener('click', closeModal);



function openModal(){
	modal.style.display = "flex";
	
}
function closeModal(){
	modal.style.display = "none";
	
}	
	
	let modalPicker = document.getElementById("modalPicker");
	let azar = document.getElementById("azar");
	let pick = document.getElementById("pick");
	let imgs = document.getElementsByClassName("imgs");
	let names = document.getElementsByClassName("name");
	
	let imagenes = document.querySelector(".imgs img");
	
	azar.addEventListener("click", open);
	pick.addEventListener("click", picker);
	
	
	var pickit = new Audio();
	pickit.src = "../sounds/pick.mp3"
	
	function cerrar(){
		  modalPicker.style.display="none";
		}
	function open(){
		  modalPicker.style.display="flex";
		}
	
	function picker(){
		  var x = Math.floor((Math.random()*imgs.length));
		  pickit.play();
		  console.log(x);
		  document.getElementById("containerPicker").innerHTML = 
			  `
			  <div class="picker-item" style="width: 45%;
    height: 357px; min-width: 300px; background:#f3f3f3; display:flex; align-items:center; justify-content:center; flex-direction:column; border-radius: 23px;">
				  <div style="width:200px; text-align: center;">
				  		${imgs[x].innerHTML}
				  </div>
				  <div style="font-size:2rem;">
				  		${names[x].innerHTML}
				  </div>
			  </div>
			  `;
		}
	
	
	var win = new Audio();
	win.src = "../sounds/win.mp3"
	
	var lose = new Audio();
	lose.src = "../sounds/lose.mp3"
	
	
	function show_hide() {
		var click = document.getElementById("click");
		var img = document.getElementById("img")
		if (click.style.display === "none") {
			click.style.display = "block";
			img.style.transition = "all 0.3s ease-in-out";
			img.style.transform = "rotate(180deg)";

		} else {
			click.style.display = "none";
			img.style.transform = "rotate(0deg)";
		}
	}
	
	
	
	
	

