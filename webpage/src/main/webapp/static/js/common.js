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

			
			checkBtn = false;
		} else 
		{
			$("#dropDownWrap").children("ul").css("display", "none");
			$("#iconChevronDown").removeClass("fas fa-chevron-up");
			$("#iconChevronDown").addClass("fas fa-chevron-down");
			
			checkBtn = true;
		}
	})
})



/*----------장바구니 -------------- */
$(function() {
	$("#cartBtn").on("click", function() {
		if(document.getElementById("cartView")){
			$("#cartViewOutSide").remove();
			$("#cartView").remove();
			$("#iconChevronLeft").removeClass("fas fa-chevron-right");
			$("#iconChevronLeft").addClass("fas fa-chevron-left");
			$("#cartBtn").css("position","");
			$("#cartBtn").css("right","");
			
		}else{
			$("body").prepend("<div id='cartView'></div>");
			$("body").prepend("<div id='cartViewOutSide'></div>");
			$("#iconChevronLeft").removeClass("fas fa-chevron-left");
			$("#iconChevronLeft").addClass("fas fa-chevron-right");
			$("#cartBtn").css("position","relative");
			$("#cartBtn").css("right","984px");
			cart();
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
				$("#cartView").append("<div class='cartTableWrap'><table border='1'><tr><th class='cartTable'>이름</th><th class='cartTable'>가격</th><th class='cartTable'>인기도</th><th class='cartTable'>사진</th><th></th></table>")
				
				$.each(item,function(index,item){
					$(".cartTableWrap>table").append("<tr><td class='cartTable'>"
					+item.itemName+"</td>"
					+"<td class='cartTable'>"
					+item.itemPrice+ "</td>"
					+"<td class='cartTable'>"
					+item.popularity+ "</td>"
					+"<td class='cartTable'>"
					+ "<img src='" + item.itemUrl + "'>"
					+ "</td>"
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





