var fun = new Audio();
fun.src="../sounds/modal-music/fun.mp3"

var relax = new Audio();
relax.src="../sounds/modal-music/relax.mp3"

var playA = document.getElementById("playA");
var playR = document.getElementById("playR");
var stopA = document.getElementById("stopA");
var stopR = document.getElementById("stopR");
var yogaImg = document.getElementById("yoga");
var funImg = document.getElementById("fun");
var radio = document.getElementById("radio"); 
var closeMusic = document.getElementById("closeMusic"); 
var musicContainer = document.getElementById("music-container");
let musicModal = document.getElementById("modal-music");
var music = document.getElementById("music"); 

playA.addEventListener("click", playFun);
playR.addEventListener("click", playRelax);
stopA.addEventListener("click", playFun);
stopR.addEventListener("click", playRelax);
closeMusic.addEventListener("click", closeModalMusic);
music.addEventListener("click", openModalMusic);

function playFun(){
  if(fun.paused){
    fun.play();
    playA.style.display = "none";
    stopA.style.display = "block";
    funImg.style.animation = "dance 1.35s infinite";
    radio.style.animation = "dance 1.35s infinite";
  }else{
    fun.pause();
    stopA.style.display = "none";
    playA.style.display = "block";
    funImg.style.animation = "";
    radio.style.animation = "";
  }
}

function playRelax(){
  if(relax.paused){
    relax.play();
    playR.style.display = "none";
    stopR.style.display = "block";
    yoga.style.animation = "relax 1.8s infinite";
    radio.style.animation = "relax 1.8s infinite";
  }else{
    relax.pause();
    stopR.style.display = "none";
    playR.style.display = "block";
    yoga.style.animation = "";
    radio.style.animation = "";
  }
}

function closeModalMusic(){
	musicModal.style.display = "none";
}

function openModalMusic(){
	musicModal.style.display = "flex";
}
