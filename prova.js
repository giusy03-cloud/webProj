
function doColora(idElemento, classeColore){
    let paragrafo1=document.getElementById(idElemento);
    paragrafo1.classList.add(classeColore);
}

function reset(){
    document.getElementById("paragrafo1").classList.remove('rosso');
    document.getElementById("paragrafo2").classList.remove('verde');
    document.getElementById("paragrafo3").classList.remove('giallo');
}


/*
function coloraParagrafo1(){
    let paragrafo1=document.getElementById("paragrafo1");
    paragrafo1.classList.add("rosso");
}
function coloraParagrafo2(){
    let paragrafo2=document.getElementById("paragrafo2");
    paragrafo2.classList.add("verde");
}
function coloraParagrafo3(){
    let paragrafo3=document.getElementById("paragrafo3");
    paragrafo3.classList.add("giallo");
}

 */

/*
let paragrafo1=document.getElementById("paragrafo1")
//paragrafo1.style.backgroundColor="red";
//paragrafo1.style.color="white";
let paragrafo2=document.getElementById("paragrafo2");
let paragrafo3=document.getElementById("paragrafo3");
paragrafo1.classList.add("rosso");
paragrafo2.classList.add("verde");
paragrafo3.classList.add("giallo");
*/
