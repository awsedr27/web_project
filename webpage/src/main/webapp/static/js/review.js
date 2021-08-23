var star=0;
$(function(){
	
	review();
	$(".review").on("click","#writeReviewBtn",function(){

		writeReview();
		
	})
	
	$(".review").on("click",".starIconWrap",function(){
		star=$(this).children("i").attr("id");
		
	})
	
	
	
	
	
})

function review(){
	var itemId=document.getElementById("itemIdInput").value;
	var writeBtnExist=document.getElementById("writeBtnExist").value
	$.ajax({
		type: "POST",
		url: "/review",
		data: {"itemId":itemId},
		dataType: "json",
		success: function(data) {
			try{
				
				$(".reviewContentsWrap").append("<table id='reviewContents'><tr>"
								+"<th>ID</th>"
								+"<th>리뷰</th>"
								+"<th>추천</th>"
								+"<th>작성날짜</th>"
							+"</tr></table>");
				$.each(data,function(index,item){
				
					$("#reviewContents").append("<tr>"
								+"<td>"+item.memberId+"</td>"
								+"<td>"+item.contents+"</td>"
								+"<td>"+item.rating+"</td>"
								+"<td>"+item.reviewTime+"</td>"
							+"</tr>");
				    
				});
				if(writeBtnExist=="true"){
					$(".review").append("<div id='writeReviewWrap'></div>");
					$("#writeReviewWrap").append("<input type='text' id='writeReview' placeholder='리뷰를 입력하세요'>")
					$("#writeReviewWrap").append("<div id='starReviewIconWrap'></div>")
					$("#writeReviewWrap").append("<button id='writeReviewBtn'>리뷰작성</button>")
					for(var step=1;step<6;step++){
						$("#starReviewIconWrap").append("<span class='starIconWrap'><i class='fas fa-star' id='"+step+"'></i></span>");
					    
					}
					
				}else{
					
				}
				
			}catch(error){
				alert(error);
				}
			
		}
	})
}

function writeReview(){
	var reviewContents=document.getElementById("writeReview").value;
	var writeReviewItemId=document.getElementById("itemIdInput").value;
	 
	$.ajax({
		type: "POST",
		url: "/writeReview",
		data: {"reviewContents":reviewContents,"writeReviewItemId":writeReviewItemId,"star":star},
		dataType: "html",
		success: function() {
			document.getElementById("writeBtnExist").value="false";
			$("#writeReviewWrap").remove();
			$(".reviewContentsWrap").children("table").remove();
	        review();
		},
		error:function(error){
			alert("이미 리뷰를 작성하셨거나 데이터 오류입니다.");
			location.href="/index";
		}


		
	})
	
	
}
