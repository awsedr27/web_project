/**
 * 
 */
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
/*--------------------------------*/
/*----------무한페이지-------------- */
var lastIdNum = $("div[class=itemId]").last().text();
var startAjax=true;
const url=new URL(window.location.href);
const urlParams=url.searchParams.get("category");

$(window).scroll(function() {
	if ($(window).scrollTop() == $(document).height() - $(window).height()) {
		if(startAjax!=false)
		{
			startAjax=false;
			
		if(urlParams==null){
			
			next_page();
		}
		else{
			
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
			$("#itemListWrap").append("<div class='itemImg'><img class='item' src='" +
			 item[step].itemUrl +"'><div class='itemText'>"+item[step].itemText+"</div>"+
		"<div class='itemPrice'><p>"+item[step].itemPrice+"</p></div>")
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
		data: {"lastIdNum":lastIdNum,"category":urlParams},
		dataType: "json",
		success: function(item) {
			try{
			
			for (step = 0; step < 6; step++){
			$("#itemListWrap").append("<div class='itemImg'><img class='item' src='" +
			 item[step].itemUrl +"'><div class='itemText'>"+item[step].itemText+"</div>"+
		"<div class='itemPrice'><p>"+item[step].itemPrice+"</p></div>")
		}
		lastIdNum=item[5].itemId;
		startAjax=true;
		
		}catch(error){
			
			startAjax=false;

		}
		}
	})
}

