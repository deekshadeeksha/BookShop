$(document).ready(function(){    

 

   $("#myform").submit(function(){

 

         var search = $("#books").val();
   var user=$("#user").val();
         if(search == "")
         {
             alert("Please enter something in the field");
         }
         else{        
         var url = "";
         var img = "";
      var title = "";
      var author = "";
   var linkBut="";
      var titl= "";

 


         $.get("https://www.googleapis.com/books/v1/volumes?q=" + search,function(response){

 

          for(i=0;i<response.items.length;i++)
          {
           title=$('<h5 class="center-align white-text">' + response.items[i].volumeInfo.title + '</h5>'); 
        titl=response.items[i].volumeInfo.title; 
           author=$('<h5 class="center-align white-text"> By:' + response.items[i].volumeInfo.authors + '</h5>');
           img = $('<img class="aligning card z-depth-5" id="dynamic"><br><a href=' + response.items[i].volumeInfo.infoLink + '><button id="imagebutton" class="btn red aligning">Read More</button></a>');     
           url= response.items[i].volumeInfo.imageLinks.thumbnail;
            linkBut=$('<button  value='+ response.items[i].volumeInfo.infoLink +' data-arg1='+titl+' class="btn red aligning" id="addToList">Add To List</button>');
            img.attr('src', url);
           title.appendTo('#result');
           author.appendTo('#result');
           img.appendTo('#result');
           linkBut.appendTo('#result');
          }

 


$(document).on('click', '#addToList', function () {  
alert("Your choice has been added"); 

 

   
    //var inp=$(document.activeElement).attr('value');
    //var title1=$(document.activeElement).attr('data-arg1');
    
    var inp=($(this).attr('value'));
    var title1=($(this).attr('data-arg1'));
 $.ajax({
                    type: "post",
                    url: "AddList.jsp", //here you can use servlet,jsp, etc
                    data: {
                    link:inp,
                    title:title1,
                    user:user
},
                    success: function(msg){      
                            $('#output').append(msg);
                    }
                });

 

 
}); 

 

});

 

         
      
      }
      return false;
   });

 

});