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
const urlParams=url.searchParams.get("category");

$(window).scroll(function() {
	if ($(window).scrollTop()+100 >= $(document).height() - $(window).height()) {
		
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
			$("#itemListWrap").append("<div class='itemWrap'><div class='itemImgWrap'><a href='/itemView?itemId="+item[step].itemId+"'><img class='itemImg' src='" +
			 item[step].itemUrl +"'></a><div class='itemIcon'><a href='cartPut?itemId="+item[step].itemId+"'><i class='fas fa-shopping-basket'></i></a></div></div><div class='itemText'><h2>"+item[step].itemText+"</h2></div>"+
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
			$("#itemListWrap").append("<div class='itemWrap'><div class='itemImgWrap'><a href='/itemView?itemId="+item[step].itemId+"'><img class='itemImg' src='" +
			 item[step].itemUrl +"'></a><div class='itemIcon'><a href='/cartPut?itemId="+item[step].itemId+"'><i class='fas fa-shopping-basket'></i></a></div></div><div class='itemText'>"+item[step].itemText+"</div>"+
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