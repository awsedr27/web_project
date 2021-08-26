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
			 item[step].itemUrl +"'></a><div class='itemIcon'><a class='itemCartPut'><i class='fas fa-shopping-basket'></i></a></div></div><div class='itemText'><span>"+item[step].itemText+"</span></div>"+
		"<div class='itemPrice'><span>"+item[step].itemPrice+"원</span></div><div class='itemId'>"+item[step].itemId+"</div>")
		}
		lastIdNum=item[5].itemId;
		startAjax=true;
		
		}catch(error){
			
			startAjax=false;

		}
		}
	})
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
			 item[step].itemUrl +"'></a><div class='itemIcon'><a class='itemCartPut'><i class='fas fa-shopping-basket'></i></a></div></div><div class='itemText'><span>"+item[step].itemText+"</span></div>"+
		"<div class='itemPrice'><span>"+item[step].itemPrice+"원</span></div><div class='itemId'>"+item[step].itemId+"</div>")
		}
		
		 startAjax=true;
	     categoryPage++;
	
		
		}catch(error){
			
			startAjax=false;

		}
		},
		error:function(){
			
			startAjax=false;
		}
	})
}
/*-------------인기상품 무한스크롤 ajax------- */
