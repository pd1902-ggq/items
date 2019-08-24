function checkName1(name) {
    var reg1 = /^[A-z]\w{5,10}$/;
    if(!reg1.test(name)){
        document.getElementById("td1").innerText="请用字母开头，并用户名长度在6-11位之间"
        document.getElementById("td1").style.color = "red";
        document.getElementById("a1").disabled=true;
        return;
    }else{
        document.getElementById("td1").innerText="";
        document.getElementById("a1").disabled="";
    }
}
function checkPhone1(phone) {
var reg2=/^1[3|5|7|8]\d{9}$/;
    if(!reg2.test(phone)){
        document.getElementById("td2").innerText="请输入正确的11位电话号码";
        document.getElementById("td2").style.color = "red";
        document.getElementById("a1").disabled=true;
        return;
    }else{
        document.getElementById("td2").innerText="";
        document.getElementById("a1").disabled="";
    }
}
function checkName2(name) {
    var reg1 = /^[A-z]\w{5,10}$/;
    if(!reg1.test(name)){
        document.getElementById("ta1").innerText="请用字母开头，并用户名长度在6-11位之间";
        document.getElementById("ta1").style.color = "red";
        document.getElementById("a2").disabled=true;
        return;
    }else{
        document.getElementById("ta1").innerText="";
        document.getElementById("a2").disabled="";
    }
}
function checkPhone2(phone) {
    var reg2=/^1[3|5|7|8]\d{9}$/;
    if(!reg2.test(phone)){
        document.getElementById("ta2").innerText="请输入正确的11位电话号码";
        document.getElementById("ta2").style.color = "red";
        document.getElementById("a2").disabled=true;
        return;
    }else{
        document.getElementById("ta2").innerText="";
        document.getElementById("a2").disabled="";
    }
}
function f1(id){
     var add = document.getElementById("add");
     add.style.display = "block";
     add.innerHTML = "<form action=\"insert\" method=\"post\">\n" +
        "        接收人：<input type=\"text\" name=\"receiver\" oninput='checkName1(this.value)'>\n" +"<span id=\"td1\"></span>"+
        "        电话：<input type=\"text\" name=\"phone\" oninput='checkPhone1(this.value)'>\n" +"<span id=\"td2\"></span>"+
        "        收货地址：<input type=\"text\" name=\"address\" required>\n" +
        "        <input type=\"hidden\" value=\"3\" name=\"type\">\n" +
        "        <input type=\"hidden\" value="+id+" name=\"uid\">\n" +
        "       <input  id='a1' type=\"submit\" value=\"添加\">\n" +
        "    </form>";
}
function f2(id,receiver,phone,address){
    var update = document.getElementById("update");
    update.style.display = "block";
    update.innerHTML = "<form action=\"insert\" method=\"post\">\n" +
        "        接收人：<input type=\"text\" name=\"receiver\" oninput='checkName2(this.value)' value="+receiver+">\n" + "<span id=\"ta1\"></span>"+
        "        电话：<input type=\"text\" name=\"phone\" oninput='checkPhone2(this.value)' value="+phone+">\n" +"<span id=\"ta2\"></span>"+
        "        收货地址：<input type=\"text\" name=\"address\" required value="+address+">\n" +
        "        <input type=\"hidden\" value=\"1\" name=\"type\">\n" +
        "        <input type=\"hidden\" value="+id+" name=\"id\">\n" +
        "       <input  id='a2' type=\"submit\" value=\"修改\">" +
        "       <input type=\"reset\" value=\"重置\">"+
        "    </form>";
}
function on() {
    var myDetail = document.getElementById("myDetail");
    if(myDetail.style.display=="block"){
        myDetail.style.display="none";
    }else{
        myDetail.style.display="block";
    }
}