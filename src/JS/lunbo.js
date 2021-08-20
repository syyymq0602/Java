let number = 1;

function f1(){
    number++;
    if(number>3){
        number=1;
    }
    let element = window.document.getElementById("img");
    element.src = "../../images/banner_"+ number +".jpg";
}

setInterval(f1,3000);
