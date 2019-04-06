
var APP = APP || {}
var myArray = [];
function survey(){
	//document.getElementById("que1").innerHTML = "Q1:How Would you Rate yourself";
	$("#question2,#question4,#question3").hide();
	document.getElementById("exp").value ="";
	//document.getElementById("radioText").innerHTML = "2000";//To be used for changing the contents \
 }

function SubmitForm(PrepareString, type){
	var radios = document.getElementsByName(PrepareString);
	for (var i = 0, length = radios.length; i < length; i++) {
		if (radios[i].checked) {
            if (type == 'Submit1') {
                var x = parseInt(radios[i].value, 10);
                myArray.push(localStorage.getItem("username"),x);
                callGetMethod(radios[i].value);
                break;
            }
             else if (type == 'Submit2') {
                var question = document.getElementById("que2").innerHTML;
                console.log(APP.myData);
                if(APP.myData.sol == radios[i].value)
                       myArray.push(1);
                else
                       myArray.push(0);

                  callPostMethod(type, radios[i].value, question, APP.myData);
                   break;
                    }
            else if (type == 'Submit3') {
                 var question = document.getElementById("que3").value;
                 console.log(APP.myData);
                 if(APP.myData.sol == radios[i].value)
                         myArray.push(1);
                 else
                         myArray.push(0);
                   callQuestionEnd(type, radios[i].value, question);
                    break;
                      }
	        }
	 }
  }

   function SubmitFormFinal(PrepareString, type){
               var Exp = 5;
               myArray.push(Exp);
               console.log(myArray);
               callFinalPostMethod(myArray);
               }

  function callFinalPostMethod(Array) {
       var array = JSON.stringify(Array);
	$.ajax({
              url: "/getfirst", //this will use the form's action attribute
              type: 'post',
              data: array,
              contentType: "application/json",
              success: function(responseData){
               var response = CaptureResponseFinal(responseData);
                RedirectPage(responseData);
               }
            });
 };

  function RedirectPage(data){
           localStorage.setItem("Description", data[0].description);
           localStorage.setItem("Example", "Cheeeeeeeeeckkk");
           localStorage.setItem("Question", "herererer");
           localStorage.setItem("Opt1", data[0].option1);
           localStorage.setItem("Opt2", data[0].option2);
           localStorage.setItem("Opt3", data[0].option3);
           localStorage.setItem("Sol", data[0].solution);
           localStorage.setItem("Topic", data[0].topic);
           localStorage.setItem("Level", data[0].level);
           window.location = "/html/content.html";
   }



  function callPostMethod(TypeSubmit, TheSelectedValue, quest, jsonResponse) {
    jsonResponse.sol = TheSelectedValue;
    var PrepareString = JSON.stringify(jsonResponse)
	$.ajax({
              url: "/enroll", //this will use the form's action attribute
              type: 'post',
              data: PrepareString,
              contentType: "application/json",
              success: function(responseData){
              var response = CaptureResponse(responseData); //Function For responseData
              checkContentPost(TypeSubmit,response);
              }
            });
 };
function callGetMethod(rating) {
            url =  "/getques/"+ rating ;
	        $.ajax({
	        url: url, //this will use the form's action attribute
			success: function(responseData){
		    var response = CaptureResponse(responseData); //Function For responseData
	        checkContent(response);
	      }
	});
};

 function CaptureResponse(ReturnResponse){
             var obj = JSON.stringify(ReturnResponse);
             var data = JSON.parse(obj);
             APP.myData = data;
             return data;
	 }
 function CaptureResponseFinal(ReturnResponse){
              var obj = JSON.stringify(ReturnResponse);
              var data = JSON.parse(obj);
              return data;
 	 }
 function checkContent(result){
             $("#question1").css('display','none');
             document.getElementById("que2").innerHTML = result.question;
             $('label[for=option12]').html(result.opt1);
             $('label[for=option22]').html(result.opt2);
             $('label[for=option32]').html(result.opt3);
             $("#question2").css('display','block');
    }


 function checkContentPost(SubmitType,result){
             if(SubmitType == 'Submit2'){
                  $("#question2").css('display','none');
                  document.getElementById("que3").innerHTML = result.question;
                  $('label[for=option13]').html(result.opt1);
                  $('label[for=option23]').html(result.opt2);
                  $('label[for=option33]').html(result.opt3);
                  $("#question3").css('display','block');
                  }
        }
 function callQuestionEnd(TypeSubmit, TheSelectedValue, quest) {
                $("#question3").css('display','none');
                document.getElementById("que4").innerHTML = "How much experience do you have?";
                $("#question4").css('display','block');
 }



