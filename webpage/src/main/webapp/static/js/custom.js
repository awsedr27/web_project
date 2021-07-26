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
var pageNum = 1;
var startAjax=true;
$(window).scroll(function() {
	if ($(window).scrollTop() == $(document).height() - $(window).height()) {
		if(startAjax!=false)
		{next_page();}
		
	}
})


function next_page() {
	$.ajax({
		type: "POST",
		url: "/index/ajax",
		data: {"pageNum":pageNum},
		dataType: "json",
		success: function(item) {
			try{
			for (step = 0; step < 6; step++){
			$("#itemImgWrap").append("<div id='itemImg'><img id='item' src='" + item[step].itemUrl +"'><h2>"+item[step].itemText+"</h2></div>")
		}
		++pageNum;
		
		}catch(error){
			startAjax=false;

		}
		}
	})
}



