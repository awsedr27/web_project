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
				if(writeBtnExist=="NotLogIn"){
					$(".review").append("<div id='writeReviewWrap'></div>");
					$("#writeReviewWrap").append("<input type='text' id='writeReview' placeholder='로그인 하세요' disabled> ")
					$("#writeReviewWrap").append("<div id='starReviewIconWrap'></div>")
				}else if(writeBtnExist=="NotPurchase"){
					$(".review").append("<div id='writeReviewWrap'></div>");
					$("#writeReviewWrap").append("<input type='text' id='writeReview' placeholder='구매 후 작성가능' disabled> ")
					$("#writeReviewWrap").append("<div id='starReviewIconWrap'></div>")
					
				}else if(writeBtnExist=="true"){
					$(".review").append("<div id='writeReviewWrap'></div>");
					$("#writeReviewWrap").append("<input type='text' id='writeReview' placeholder='리뷰를 입력하세요'>")
					$("#writeReviewWrap").append("<div id='starReviewIconWrap'></div>")
					$("#writeReviewWrap").append("<button id='writeReviewBtn'>리뷰작성</button>")
					for(var step=1;step<6;step++){
						$("#starReviewIconWrap").append("<span class='starIconWrap'><i class='fas fa-star' id='"+step+"'></i></span>");
					    
					}
					
				}else{
					/*수정, 삭제 추가부분  */
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
		error:function(){
			alert("이미 리뷰를 작성하셨거나 데이터 오류입니다.");
			location.href="/index";
		}


		
	})
	
	
}

$(function(){
	$("#minusQuantity").on("click",function(){
		
		var quantityValue=parseInt($("#quantityValue").text());
		quantityValue=quantityValue-1;
		$("#quantityValue").text(quantityValue);
		if(quantityValue<1){
			$("#quantityValue").text(1);
		}
		itemViewPriceSum();
		
		
	
	})
	
	$("#plusQuantity").on("click",function(){
		
		var quantityValue=parseInt($("#quantityValue").text());
		
		quantityValue=quantityValue+1;
		$("#quantityValue").text(quantityValue);
		itemViewPriceSum();

	})
	
})
/*-------------------아이템뷰 총액 계산----------------------- */
function itemViewPriceSum(){
	
	var priceSum=0;
	var discountSum=0;
	var itemViewPrice=parseInt($("#itemViewPrice").text());
	var itemViewDiscount=parseInt($("#itemViewDiscount").text());
    if($("#itemViewDiscount").text()==""){
		itemViewDiscount=0;
	}
	var quantityValue=parseInt($("#quantityValue").text());
	priceSum=itemViewPrice*quantityValue;
	discountSum=itemViewDiscount*quantityValue;
	$("#itemViewPriceSum").text(priceSum-discountSum);
}
$(function(){
	itemViewPriceSum();
})
/*-----------------아이템 뷰에서 장바구니 담기-------------------*/
$(function(){
	$("#itemPutBtn").on("click",function(){
		itemViewCartPut();

	})
	
})
function itemViewCartPut(){
	var itemId=document.getElementById("itemIdInput").value;
	var quantity=$("#quantityValue").text();
	$.ajax({
		type: "POST",
		url: "/cartPut",
		data: { "itemId": itemId,"quantity":quantity},
		dataType:"json",
		success: function(item) {
			
			if(item==false){
				alert("로그인하세요");
			}else{
			    alert("장바구니에 추가되었습니다");
			}
			

		},
		error: function(){
			alert("데이터 오류입니다.");
		}
		
	})
	
	
}
