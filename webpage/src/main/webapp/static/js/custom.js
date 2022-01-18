/*----------슬라이드 바--------------*/
$(function() {
	$('.slide').bxSlider({
		auto: true,
		controls: false,
		pager: true,
		autoHover: true,
		touchEnabled: false


	});

});

/*----------무한페이지-------------- */
var lastIdNum = $("div[class=itemId]").last().text();
var startAjax=true;
const url=new URL(window.location.href);
//const urlParams=url.searchParams.get("categoryPage");
const urlParamsCategory=url.searchParams.get("category");
var categoryPage=2;

$(window).scroll(function() {
	
	if ($(window).scrollTop()+100 >= $(document).height() - $(window).height()) {
		
		if(startAjax!=false)
		{
			
			startAjax=false;
			if(urlParamsCategory==null){
				
				next_page();
				
				
			}else{
				
				next_page_category();
			
				
			}
		
		    
		
			
		}
		
	}
})


function next_page() {
	
	$.ajax({
		type: "POST",
		url: "/index/ajax",
		data: {"lastIdNum":lastIdNum},
		dataType: "json",
		success: function(item) {
			try{
			
			for (step = 0; step < 6; step++){
			$("#itemListWrap").append("<div class='itemWrap'><div class='itemImgWrap'><a href='/itemView?itemId="+item[step].itemId+"'><img class='itemImg' src='" +
			 item[step].itemUrl +"'></a><div class='itemIcon'><a class='itemCartPut'><i class='fas fa-shopping-basket'></i></a></div></div><div class='itemTextWrap'><span class='itemText'>"+item[step].itemText+"</span></div>"+
		"<div class='itemPriceWrap'><span class='itemPrice'>"+item[step].itemPrice+"</span>원</div><div class='itemDiscountNumWrap'>-<span class='itemDiscountNum'>"+item[step].discountNum+"</span>원</div><div class='itemResultPriceWrap'><span class='itemResultPrice'></span>원</div><div class='itemId'>"+item[step].itemId+"</div>")
		}
		lastIdNum=item[5].itemId;
		startAjax=true;
		calculateDiscount();
		}catch(error){
			
			startAjax=false;
			calculateDiscount();

		}
		}
	});
	
}

/*---------------카테고리 무한페이지-------------- */

function next_page_category() {
	
	$.ajax({
		type: "POST",
		url: "/category/ajax",
		data: {"categoryPage":categoryPage,"category":urlParamsCategory},
		dataType: "json",
		success: function(item) {
			try{
	
			for (step = 0; step < 6; step++){
			$("#itemListWrap").append("<div class='itemWrap'><div class='itemImgWrap'><a href='/itemView?itemId="+item[step].itemId+"'><img class='itemImg' src='" +
			 item[step].itemUrl +"'></a><div class='itemIcon'><a class='itemCartPut'><i class='fas fa-shopping-basket'></i></a></div></div><div class='itemTextWrap'><span class='itemText'>"+item[step].itemText+"</span></div>"+
		"<div class='itemPriceWrap'><span class='itemPrice'>"+item[step].itemPrice+"</span>원</div><div class='itemDiscountNumWrap'>-<span class='itemDiscountNum'>"+item[step].discountNum+"</span>원</div><div class='itemResultPriceWrap'><span class='itemResultPrice'></span>원</div><div class='itemId'>"+item[step].itemId+"</div>")
		}
		
		 startAjax=true;
	     categoryPage++;
         calculateDiscount();
	
		
		}catch(error){
			
			startAjax=false;
			calculateDiscount();

		}
		},
		error:function(){
			
			startAjax=false;
		}
	});
	
}
/*-------------할인가격계산------- */
$(function(){
	calculateDiscount();
})
function calculateDiscount(){
	
	$.each($(".itemPrice"),function(index,item){
		var price=parseInt($(this).text());
		var discount=parseInt($(this).parent(".itemPriceWrap").next(".itemDiscountNumWrap").children(".itemDiscountNum").text());
		$(this).parent(".itemPriceWrap").nextAll(".itemResultPriceWrap").children(".itemResultPrice").text(price-discount);
	})
	

}

/*-------------------네비게이션 강조------------- */
$(function(){
	//alert(url.pathname.replace(/\//gi,""));
	$(".navLi").each(function(){
		if (urlParamsCategory == "discountItem") {
			
			$(".navLi:nth-child(1)").addClass("active");

		} else if (urlParamsCategory == "hotItem") {
			$(".navLi:nth-child(2)").addClass("active");

		} else if (urlParamsCategory == "food") {
			$(".navLi:nth-child(3)").addClass("active");

		} else if (urlParamsCategory == "appliance") {
			$(".navLi:nth-child(4)").addClass("active");

		} else if (urlParamsCategory == "clothing") {
			$(".navLi:nth-child(5)").addClass("active");

		} else if (urlParamsCategory == "book") {
			$(".navLi:nth-child(6)").addClass("active");

		}
		
	})
	
	
		
	
		
	
	
})
