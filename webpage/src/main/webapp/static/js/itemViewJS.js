var star=0;
var reviewPageNum=1;
$(function(){
	review(1);
	reviewPaging(1);

	$(".review").on("click","#writeReviewBtn",function(){

		writeReview();
		
	})
	
	$(".review").on("click","#writeReviewDeleteBtn",function(){
		deleteReview();
		
	})
	
	$(".review").on("click",".starIconWrap",function(){
		star=$(this).children("i").attr("id");
		
	})
	
	$(".review").on("mouseover",".starIconWrap",function(){
		var index=$(this).index()+1;
		for(var i=1;i<index+1;i++){
			$(".starIconWrap:nth-child("+i+")").children("i").css("color","gold");
			for(var j=5;j>i;j--){
				$(".starIconWrap:nth-child("+j+")").children("i").css("color","black");
			}
		}
	
	
	})
	$(".review").on("mouseout",".starIconWrap",function(){
		$(".starIconWrap").each(function(){
			$(".starIconWrap").children("i").css("color","black");
		})
		
	
	})
	
	
	$(".review").on("click",".reviewPagingNum",function(e){
		e.preventDefault();
		$("#writeReviewWrap").remove();
		$(".reviewContentsWrap").children("table").remove();
		$("#reviewPagingWrap").remove();
	    
       
		reviewPageNum=$(this).text();
		review(reviewPageNum);
		reviewPaging(reviewPageNum);
		
	})
	$(".review").on("click",".reviewPagingLeftBtn",function(){
		reviewPageNum=$(".reviewPagingLeftBtn").attr("value");
		
		$("#writeReviewWrap").remove();
		$(".reviewContentsWrap").children("table").remove();
		$("#reviewPagingWrap").remove();
		review(reviewPageNum);
		reviewPaging(reviewPageNum);
	})
	$(".review").on("click",".reviewPagingRightBtn",function(){
		reviewPageNum=$(".reviewPagingRightBtn").attr("value");
		
		$("#writeReviewWrap").remove();
		$(".reviewContentsWrap").children("table").remove();
		$("#reviewPagingWrap").remove();
		review(reviewPageNum);
		reviewPaging(reviewPageNum);
	})
	
	$(".review").on("click",".reviewContentsViewBtn",function(e){
		e.preventDefault();
		$("#reviewContentsView").remove();
		
		var memberId=$(this).parent("td").prev().text();
		reviewContentsView(memberId);
		
		
		
		
		
	})
	
	
})

function review(pageNum){
	var itemId=document.getElementById("itemIdInput").value;
	var writeBtnExist=document.getElementById("writeBtnExist").value
	
	
	$.ajax({
		type: "POST",
		url: "/review",
		data: {"itemId":itemId,"reviewPageNum":pageNum},
		
		dataType: "json",
		
		success: function(data) {
			try{
				
				$(".reviewContentsWrap").append("<table id='reviewContents'><tr>"
								+"<th>ID</th>"
								+"<th>??????</th>"
								+"<th>??????</th>"
								+"<th>????????????</th>"
							+"</tr></table>");
				$.each(data,function(index,item){
					
					var itemContents;
					if(item.contents.length>14){
						itemContents=item.contents.substring(0,14)+"...";
					}else{
						itemContents=item.contents;
					}
				
					$("#reviewContents").append("<tr>"
								+"<td>"+item.memberId+"</td>"
								+"<td><a href='#' class='reviewContentsViewBtn'>"+itemContents+"</a></td>"
								+"<td>"+item.rating+"</td>"
								+"<td>"+item.reviewTime+"</td>"
							+"</tr>");
				    
				});
				if(writeBtnExist=="NotLogIn"){
					
					$("#reviewContentsPagingWrap").before("<div id='writeReviewWrap'></div>");
					$("#writeReviewWrap").append("<input type='text' id='writeReview' placeholder='????????? ?????????' disabled> ")
					$("#writeReviewWrap").append("<div id='starReviewIconWrap'></div>")
					
				}else if(writeBtnExist=="NotPurchase"){
					$("#reviewContentsPagingWrap").before("<div id='writeReviewWrap'></div>");
					$("#writeReviewWrap").append("<input type='text' id='writeReview' placeholder='?????? ??? ????????????' disabled> ")
					$("#writeReviewWrap").append("<div id='starReviewIconWrap'></div>")
					
				}else if(writeBtnExist=="true"){
					$("#reviewContentsPagingWrap").before("<div id='writeReviewWrap'></div>");
					$("#writeReviewWrap").append("<input type='text' id='writeReview' placeholder='????????? ???????????????'>")
					$("#writeReviewWrap").append("<div id='starReviewIconWrap'></div>")
					$("#writeReviewWrap").append("<button id='writeReviewBtn'>????????????</button>")
					for(var step=1;step<6;step++){
						$("#starReviewIconWrap").append("<span class='starIconWrap'><i class='fas fa-star' id='"+step+"'></i></span>");
					    
					}
					
				}else{
					$("#reviewContentsPagingWrap").before("<div id='writeReviewWrap'></div>");
					$("#writeReviewWrap").append("<input type='text' id='writeReview' placeholder='?????? ?????????????????????' disabled>")
					$("#writeReviewWrap").append("<div id='starReviewIconWrap'></div>")
					$("#writeReviewWrap").append("<button id='writeReviewDeleteBtn'>????????????</button>")
					/*??????, ?????? ????????????  */
				}
				
			}catch(error){
				alert(error);
				}
			
		},
		error:function(error){
			alert(error);
		}
	});
	
	
}

function writeReview(){
	var reviewContents=document.getElementById("writeReview").value;
	var writeReviewItemId=document.getElementById("itemIdInput").value;
	 
	$.ajax({
		type: "POST",
		url: "/writeReview",
		data: {"contents":reviewContents,"itemId":writeReviewItemId,"rating":star},
		success: function() {
			document.getElementById("writeBtnExist").value="false";
			$("#writeReviewWrap").remove();
			$(".reviewContentsWrap").children("table").remove();
			$("#reviewPagingWrap").remove();
	        review(1);
            reviewPaging(1);

		},
		error:function(){
			alert("?????? ????????? ?????????????????? ????????? ???????????????.");
			location.href="/index";
		}


		
	})
	
	
}

function reviewPaging(pageNum){
	var reviewPagingItemId=document.getElementById("itemIdInput").value;
	$.ajax({
		type: "POST",
		url: "/reviewPaging",
		data: {"reviewPageNum":pageNum,"itemId":reviewPagingItemId},
		dataType: "json",
		success: function(item) {
			$("#reviewContentsPagingWrap").append("<div id='reviewPagingWrap'></div>");
			if(item.nextRange==true){
				if(item.pageRangeFirst>10){
					$("#reviewPagingWrap").append("<button class='reviewPagingLeftBtn' value='"+(item.pageRangeFirst-10)+"'><i class='fas fa-chevron-left'></i></button>");
				}
				for(var i=item.pageRangeFirst;i<=item.pageRangeLast;i++){
					 $("#reviewPagingWrap").append("&nbsp<a href='#' class='reviewPagingNum'>"+i+"</a>");
				}
			    $("#reviewPagingWrap").append("<button class='reviewPagingRightBtn' value='"+(item.pageRangeFirst+10)+"'><i class='fas fa-chevron-right'></i></button>");
   
				
			}else{
				if(item.pageRangeFirst>10){
				    $("#reviewPagingWrap").append("<button class='reviewPagingLeftBtn' value='"+(item.pageRangeFirst-10)+"'><i class='fas fa-chevron-left'></i></button>");
				}
				for(var i=item.pageRangeFirst;i<=item.pageCnt;i++){
					 $("#reviewPagingWrap").append("&nbsp<a href='#' class='reviewPagingNum'>"+i+"</a>");
				}
				
			}
			
		},
		error:function(error){
			alert(error);
		}


		
	})
}

$(function(){
	$("#minusQuantity").on("click",function(){
		
		var quantityValue=parseInt($("#quantityValue").text());
		quantityValue=quantityValue-1;
		if(quantityValue<1){
		    $("#cartOrderQuantity").attr("value",1);
		    $("#quantityValue").text(1);
		}else{
			$("#cartOrderQuantity").attr("value",quantityValue);
		    $("#quantityValue").text(quantityValue);
		}
		itemViewPriceSum();
		
		
	
	})
	
	$("#plusQuantity").on("click",function(){
		
		var quantityValue=parseInt($("#quantityValue").text());
		
		quantityValue=quantityValue+1;
		$("#cartOrderQuantity").attr("value",quantityValue);
		$("#quantityValue").text(quantityValue);
		itemViewPriceSum();

	})
	
})
/*-------------------?????? ????????? ???(????????????)----------------------- */
function reviewContentsView(memberId){
	var itemId=document.getElementById("itemIdInput").value;
	$.ajax({
		type: "POST",
		url: "/reviewContentsView",
		data: { "itemId": itemId,"memberId":memberId},
		dataType:"json",
		success: function(item) {
		$("#reviewWrap").append("<div id='reviewContentsView'></div>");
		$("#reviewContentsView").append("<div id='reviewContentsViewId'>ID : "+item.memberId+"</div>");
		$("#reviewContentsView").append("<div id='reviewContentsViewRating'>?????? : "+item.rating+"</div>");
		$("#reviewContentsView").append("<div id='reviewContentsViewTime'>"+item.reviewTime+"</div>");
		$("#reviewContentsView").append("<div id='reviewContentsViewText'>"+item.contents+"</div>");
	  


		},
		error: function(){
			alert("????????? ???????????????.");
		}
		
	})

}
/*-------------------???????????? ?????? ??????----------------------- */
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
/*-----------------????????? ????????? ???????????? ??????-------------------*/
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
				alert("??????????????????");
			}else{
			    alert("??????????????? ?????????????????????");
			}
			

		},
		error: function(){
			alert("????????? ???????????????.");
		}
		
	})
	
	
}
/*-----------------?????? ?????? -------------------*/
function deleteReview(){
	var itemId=document.getElementById("itemIdInput").value;
	
	$.ajax({
		type: "POST",
		url: "deleteReview",
		data: { "itemId": itemId},
		
		success: function() {
			document.getElementById("writeBtnExist").value="true";
			$("#writeReviewWrap").remove();
			$(".reviewContentsWrap").children("table").remove();
			$("#reviewPagingWrap").remove();
	        review(1);
            reviewPaging(1);
		},
		error: function(error){
			alert(error);
		}
		
	})
	
	
}



