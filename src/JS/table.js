document.getElementById("button").onclick = function (){
    let id = document.getElementById("id").value;
    let name = document.getElementById("name").value;
    let gender = document.getElementById("gender").value;

    let td_id = document.createElement("td");
    let text_id = document.createTextNode(id);
    td_id.appendChild(text_id);
    let td_name = document.createElement("td");
    let text_name = document.createTextNode(name);
    td_name.appendChild(text_name)
    let td_gender = document.createElement("td");
    let text_gender = document.createTextNode(gender);
    td_gender.appendChild(text_gender)

    let td_a = document.createElement("td");
    let a = document.createElement("a");
    a.setAttribute("href","#");
    a.setAttribute("onclick","delTr(this)");
    let text_a = document.createTextNode("删除");
    a.appendChild(text_a);
    td_a.appendChild(a);

    let tr = document.createElement("tr");
    tr.appendChild(td_id);
    tr.appendChild(td_name);
    tr.appendChild(td_gender);
    tr.appendChild(td_a);

    let table = document.getElementsByTagName("table")[0];
    table.appendChild(tr)
}

function delTr(obj){
    let table = obj.parentNode.parentNode.parentNode;
    let tr = obj.parentNode.parentNode;
    table.removeChild(tr);
}