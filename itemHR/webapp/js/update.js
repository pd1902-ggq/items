function f2(id){
    var update = document.getElementById("update")
    update.style.display = "block"
    update.innerHTML = "<form action=\"insert\" method=\"post\">\n" +
        "        接收人：<input type=\"text\" name=\"receiver\">\n" +
        "        电话：<input type=\"text\" name=\"phone\">\n" +
        "        收货地址：<input type=\"text\" name=\"address\">\n" +
        "        <input type=\"hidden\" value=\"3\" name=\"type\">\n" +
        "        <input type=\"hidden\" value="+id+" name=\"uid\">\n" +
        "       <input type=\"submit\" value=\"添加\">\n" +
        "    </form>";
}