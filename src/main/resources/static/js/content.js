var APPDat = APPDat || {}
var myArray1 = [];
var ResponseDescription=localStorage.getItem("Description");
var ResponseExample=localStorage.getItem("Example");
var ResponseQuestion=localStorage.getItem("Question");
var ResponseOption1=localStorage.getItem("Opt1");
var ResponseOption2=localStorage.getItem("Opt2");
var ResponseOption3=localStorage.getItem("Opt3");
var ResponseSolution=localStorage.getItem("Sol");
var ResponseTopic=localStorage.getItem("Topic");
var ResponseLevel=localStorage.getItem("Level");
console.log(ResponseDescription);
console.log(ResponseExample);
console.log(ResponseQuestion);
console.log(ResponseOption1);
console.log(ResponseOption2);
console.log(ResponseOption3);
console.log(ResponseSolution);
console.log(ResponseTopic);
console.log(ResponseLevel);
function text(){


	document.getElementById("div1").innerHTML=ResponseDescription;
	document.getElementById("div2").innerHTML=ResponseExample;
	document.getElementById("div3").innerHTML=ResponseQuestion;
	$('label[id=option1]').html(ResponseOption1);
    $('label[id=option2]').html(ResponseOption2);
    $('label[id=option3]').html(ResponseOption3);
}

function SubmitAnswer(){
     var radioSelection = document.getElementsByName('radio1');
     //debugger;
     	for (var i = 0, length = radioSelection.length; i < length; i++) {
     		if (radioSelection[i].checked) {
     		    var x = radioSelection[i].value;
     		  }
     		}
     		myArray1.push(localStorage.getItem("username"));
     		if(CheckResponse()){
     		       if(ResponseSolution == x)
                            myArray1.push(1);
                   else
                            myArray1.push(0);
                  myArray1.push(parseInt(ResponseTopic, 10),parseInt(ResponseLevel, 10));
               }
            else{
                 if(APPDat.myData[0].solution == x)
                              myArray1.push(1);
                  else
                              myArray1.push(0);
                  myArray1.push(parseInt(APPDat.myData[0].topic, 10),parseInt(APPDat.myData[0].level, 10))
            }

         console.log(myArray1);
        callPostMethodSubmission(myArray1);
         }
function CheckResponse(){
    // debugger;
    if(ResponseSolution != "")
       return true;
    else
       return false;
}
function callPostMethodSubmission(Array1) {
       console.log(Array1);
        var array1 = JSON.stringify(Array1);
        // debugger;
            $.ajax({
                      url: "/next", //this will use the form's action attribute
                      type: 'post',
                      data: array1,
                      contentType: "application/json",
                      success: function(responseData){
                            var response = CaptureResponse(responseData);
                            if(response.length == 0)
                                   EndFunction();
                            else
                                   UpdateData(response);
                       }
             });
     };
function CaptureResponse(ReturnResponse){
                 var obj = JSON.stringify(ReturnResponse);
                 var data = JSON.parse(obj);
                 APPDat.myData = data;
                 return data;
      }

 function UpdateData(Data){
                 ResponseSolution = "";
                 $("input:radio[name='radio1']").each(function(i) {
                        this.checked = false;
                 });
                 document.getElementById("div1").innerHTML=Data[0].description;
                 document.getElementById("div2").innerHTML=Data[0].description;
                 document.getElementById("div3").innerHTML=Data[0].description;
                 $('label[id=option1]').html(Data[0].option1);
                 $('label[id=option2]').html(Data[0].option2);
                 $('label[id=option3]').html(Data[0].option3);
                 console.log(Data);
                 myArray1 = [];
     }

 function EndFunction(){
         window.localStorage.clear();
         alert("Thank you appearing the test!!!!!");
        window.close();
     }
