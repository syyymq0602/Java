let second = 5;
setInterval(fun,1000)


function fun() {
    second--;
    if(second<=0){
        // location.href = "http://localhost:63342/Java/Desktop/HTML/demo04/Register_demo.html?_ijt=ulmr1tmms31ropbv75t9e9222j&_ij_reload"
        location.href = "https://www.baidu.com"
    }
    let time = document.getElementById("time");
    time.innerHTML = second.toString()
}