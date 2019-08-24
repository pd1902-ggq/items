$(function () {
   $("#a1").click(function () {
       $("#a1").css("backgroundColor","red");
       $("#a2").css("backgroundColor","buttonface");
       $("#a3").css("backgroundColor","buttonface");
       $("#a4").css("backgroundColor","buttonface");
       $("#a5").css("backgroundColor","buttonface");
       $("#t1").show(5000);
       $("#t2").show(5000);
       $("#t3").show(5000);
       $("#t4").show(5000);
   });
    $("#a2").click(function () {
        $("#a1").css("backgroundColor","buttonface");
        $("#a2").css("backgroundColor","red");
        $("#a3").css("backgroundColor","buttonface");
        $("#a4").css("backgroundColor","buttonface");
        $("#a5").css("backgroundColor","buttonface");
        $("#t1").show(5000);
        $("#t2").hide(5000);
        $("#t3").hide(5000);
        $("#t4").hide(5000);
    });
    $("#a3").click(function () {
        $("#a1").css("backgroundColor","buttonface");
        $("#a2").css("backgroundColor","buttonface");
        $("#a3").css("backgroundColor","red");
        $("#a4").css("backgroundColor","buttonface");
        $("#a5").css("backgroundColor","buttonface");
        $("#t1").hide(5000);
        $("#t2").show(5000);
        $("#t3").hide(5000);
        $("#t4").hide(5000);
    });
    $("#a4").click(function () {
        $("#a1").css("backgroundColor","buttonface");
        $("#a2").css("backgroundColor","buttonface");
        $("#a4").css("backgroundColor","red");
        $("#a3").css("backgroundColor","buttonface");
        $("#a5").css("backgroundColor","buttonface");
        $("#t1").hide(5000);
        $("#t3").show(5000);
        $("#t2").hide(5000);
        $("#t4").hide(5000);
    });
    $("#a5").click(function () {
        $("#a1").css("backgroundColor","buttonface");
        $("#a2").css("backgroundColor","buttonface");
        $("#a5").css("backgroundColor","red");
        $("#a4").css("backgroundColor","buttonface");
        $("#a3").css("backgroundColor","buttonface");
        $("#t1").hide(5000);
        $("#t4").show(5000);
        $("#t3").hide(5000);
        $("#t2").hide(5000);
    });
});
