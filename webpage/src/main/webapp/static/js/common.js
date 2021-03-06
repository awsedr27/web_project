/**
 * 
 */
/*-----------------네비게이션바 아이콘 밑 드롭다운---------------------- */

$(function(){
	
	var checkBtn=true;
	$("#dropDownBtn").on("click",function(){
		if (checkBtn) {
			$("#dropDownWrap").children("ul").css("display", "block");
			$("#iconChevronDown").removeClass("fas fa-chevron-down");
			$("#iconChevronDown").addClass("fas fa-chevron-up");
			$("#dropDownBtn").css("background-color","whitesmoke");

			
			checkBtn = false;
		} else 
		{
			$("#dropDownWrap").children("ul").css("display", "none");
			$("#iconChevronDown").removeClass("fas fa-chevron-up");
			$("#iconChevronDown").addClass("fas fa-chevron-down");
			$("#dropDownBtn").css("background-color","white");
			checkBtn = true;
		}
	})
})




/*----------장바구니 보여주기 -------------- */
$(function() {
	$("#cartBtn").on("click", function() {
		if(document.getElementById("cartView")){
			$("#cartViewOutSide").remove();
			$("#cartView").remove();
			$("#iconChevronLeft").removeClass("fas fa-chevron-right");
			$("#iconChevronLeft").addClass("fas fa-chevron-left");
			//$("#cartBtn").css("position","");
			//$("#cartBtn").css("right","");
			$("#cartBtnWrap").css("right","20px");
			$("#cartBtnWrap").css("top","350px");
			$("#cartBtn").css("background-color","white");
			$("#cartBtn").css("border-radius","");
			$("#cartBtn").css("font-size","88px");
			$("body").css("overflow","");
			
		}else{
			$("body").prepend("<div id='cartView'></div>");
			$("body").prepend("<div id='cartViewOutSide'></div>");
			$("#iconChevronLeft").removeClass("fas fa-chevron-left");
			$("#iconChevronLeft").addClass("fas fa-chevron-right");
			//$("#cartBtn").css("position","relative");
			//$("#cartBtn").css("right","984px");
			$("#cartBtnWrap").css("right","985px");
			$("#cartBtnWrap").css("top","253px");
			$("#cartBtn").css("background-color","black");
			$("#cartBtn").css("border-radius","46px");
			$("#cartBtn").css("font-size","30px");
			cart();
			$("body").css("overflow","hidden");
		}
		
		})
	
})
function cart() {
	$.ajax({
		type: "POST",
		url: "/cart/ajax",
		dataType: "json",
		success: function(item) {
			try {
				$("#cartView").append("<div class='cartTableWrap'><table border='1'><tr><th class='cartTable'>이름</th><th class='cartTable'>가격</th><th class='cartTable'>할인</th><th class='cartTable'>사진</th><th class='cartTable'>수량</th><th></th></table>")
				
				$.each(item,function(index,item){
					$(".cartTableWrap>table").append("<tr><td class='cartTable'>"
					+item.itemName+"</td>"
					+"<td class='cartTable'>"
					+item.itemPrice+ "</td>"
					+"<td class='cartTable'>"
					+item.discountNum+ "</td>"
					+"<td class='cartTable'>"
					+ "<img src='" + item.itemUrl + "'>"
					+ "</td>"
					+"<td class='cartTable'>"
					+item.quantity+ "</td>"
					+"<td>"
					+ "<button class='cartDelBtn' value='" + item.itemId + "'><i class='far fa-trash-alt'></i></button></td>")
				})
				



			} catch (error) {
				alert(error);

			}
		}
	})
}

$(function(){
	$(document).on("click",".cartDelBtn",function(){
		var itemId=$(this).val();
		cartDel(itemId);
		
		
		
	})
	
})

function cartDel(itemId) {
	$.ajax({
		type: "POST",
		url: "/cart/ajaxDel",
		data: { "itemId": itemId },
		dataType: "html",
		success: function() {
			location.reload(); 

		}
	})
}
/*----------------아이템 호버시 장바구니 보여주기 -------------- */	

$(function() {
	$("#itemListWrap").on("mouseover", ".itemImgWrap", function() {
		$(this).children(".itemIcon").css("display", "inline-block");
		$(this).find("img.itemImg").css({"width":"300px","height":"300px","position":"relative","right":"13px","bottom":"13px"});
	
	})

	$("#itemListWrap").on("mouseout", ".itemImgWrap", function() {
	    $(this).children(".itemIcon").css("display", "none");
		$(this).find("img.itemImg").css({"width":"274px","height":"274px","position":"","right":"","bottom":""});

	})

})

/*호버시 나타나는 장바구니로 장바구니에 추가하기 */
$(function(){
	$("#itemListWrap").on("click",".itemCartPut",function(){
		var itemId=$(this).parent(".itemIcon").parent(".itemImgWrap").siblings(".itemId").text();
		
		itemListCartPut(itemId);
		
		
	})
	
})

function itemListCartPut(itemId){
	
	$.ajax({
		type: "POST",
		url: "/cartPut",
		data: { "itemId": itemId},
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




/*-----------------장바구니 아이템 총합가격-------------------*/
function cartPriceSum(){
	
	var priceSum=0;
	var discountSum=0;
	var cartTableItemPrice=$(".cartTableItemPrice");
	var cartPriceSum=$(".cartTableItemDiscount");
	$.each(cartTableItemPrice,function(){
		var price=parseInt($(this).text());
		var quantity=parseInt($(this).parent().next().next().next().children(".cartQuantity").text());
		
	priceSum=priceSum+(price*quantity);
		
	});
	$.each(cartPriceSum,function(){
		var price=parseInt($(this).text());
		var quantity=parseInt($(this).parent().next().next().children(".cartQuantity").text());

		discountSum=discountSum+(price*quantity);
	});
	
	$("#cartPriceSum").text(priceSum);
	$("#cartPriceDiscountSum").text(discountSum);
	$("#cartAllPriceSum").text(priceSum-discountSum);
}
$(function(){
	cartPriceSum();
	
	
})
/*-----------------장바구니에서 수량변경-------------------- */
$(function(){
	$(".cartQuantityPlusBtn").on("click",function(){
		var cartQuantity=parseInt($(this).siblings(".cartQuantity").text());
		cartQuantity=cartQuantity+1;
		$(this).siblings(".cartQuantity").text(cartQuantity);
		
		var quantity=$(this).siblings(".cartQuantity").text();
		var itemId=$(this).siblings(".itemId").text();
		updateCartQuantity(quantity,itemId);
		cartPriceSum();
	})
	
	$(".cartQuantityMiusBtn").on("click",function(){
		var cartQuantity=parseInt($(this).siblings(".cartQuantity").text());
		cartQuantity=cartQuantity-1;
		$(this).siblings(".cartQuantity").text(cartQuantity);
		
		var quantity=$(this).siblings(".cartQuantity").text();
		var itemId=$(this).siblings(".itemId").text();
		updateCartQuantity(quantity,itemId);
		cartPriceSum();
	})
	
})

function updateCartQuantity(quantity,itemId){
	var cartQuantity=parseInt(quantity);
	if(cartQuantity>0){
	$.ajax({
		type: "POST",
		url: "/cartPut",
		data: { "itemId": itemId,"quantity":quantity},
		success: function() {
			

		},
		error: function(){
			alert("DB 반영 에러");
			location.reload();
		}
		
	})
	}else if(cartQuantity==0){
		alert("0이하는 선택할수없습니다!.");
		location.reload();
		
	}else{
		alert("0이하는 선택할수없습니다!!.");
		location.reload();
	}
}
/*------------------장바구니에서 주문하기--------------------- */
$(function(){
	$("#cartOrderBtn").on("click",function(){
		
	})
})
/*---------------주문취소----------------------------------- */
$(function(){
	$(".myInfoOrderDelete").on("click",function(){
		var orderId=$(this).parent(".myInfoOrderDeleteWrap").next().children(".myInfoOrderId").text();
		var check=confirm("주문을 취소하시겠습니까?");
		if(check){
			myInfoOrderDelete(orderId);
		}else{
			
		}
		
		
	})
	
	$(".myInfoOrderDelete").on("mouseover", function() {
		$(this).parent(".myInfoOrderDeleteWrap").parent(".myInfoOrderDeleteBody").css("background", "#d2c9c9");
	
	})

	$(".myInfoOrderDelete").on("mouseout", function() {
		$(this).parent(".myInfoOrderDeleteWrap").parent(".myInfoOrderDeleteBody").css("background", "");

	})
	
})
function myInfoOrderDelete(orderId){
	
	$.ajax({
		type: "POST",
		url: "/myInfo/orderDelete",
		data: { "orderId": orderId},
		success: function() {
			alert("주문 취소가 완료되었습니다");
			location.reload();

		},
		error: function(){
			alert("이미 취소된 주문입니다.");
			location.reload();
		}
		
	})
}
/*---------------bbs 100글자제한----------------------------------- */
$(function(){
	$("#bbsWriteText").on("keyup",function(){
		$("#textAreaCnt").html("("+$(this).val().length+"/100)");
		
		if($(this).val().length>100){
			
			$(this).val($(this).val().substring(0,100));
		    $("#textAreaCnt").html("(100/100)");

		}
	})
	
	$("#bbsWriteText").on("keydown",function(){
		$("#textAreaCnt").html("("+$(this).val().length+"/100)");
		
		if($(this).val().length>100){
			
			$(this).val($(this).val().substring(0,100));
		    $("#textAreaCnt").html("(100/100)");

		}
	})
	
})

/*--------------------------장바구니주문페이지 fixed설정----------------------------------*/
$(document).ready(function(){ 
	
	
$(window).scroll(function() { 
	 
	
	if($(window).scrollTop()>200){
		$(".cartTextWrap").attr("class","cartTextWrap fixed");
	}else{
		$(".cartTextWrap").attr("class","cartTextWrap");
	}
		
	



 });
 }

);

