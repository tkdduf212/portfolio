// css로 안보이게(
//		좌표조절, 
//		투명도(opacity를 0으로),
//		visibility속성을 hidden으로 : 애니메이션x,
//		...
//	)

function connectSummonEvent() {
	var summon = false;
	$("#snsWriteSummonImg").click(function() {
		if (!summon) {
			$("#snsWriteTable").css("bottom", "0px");
		} else {
			$("#snsWriteTable").css("bottom", "-120px");
		}
		summon = !summon;
	});
}

function connectSummonEventLogin() {
	var summon = false;
	$("#loginImg").click(function() {
		if (!summon) {
			$("#loginArea").css("display", "block");
		} else {
			$("#loginArea").css("display", "None");
		}
		summon = !summon;
	});
}

function connectSummonAddrInputEvent(){
	$("#joinAddrSearchBtn").click(function(){
		new daum.Postcode({
	        oncomplete: function(data) {
	        	$("#p_adds1").val(data.zonecode);
	        	$("#p_adds2").val(data.address);
	        }
	    }).open();
	});
}

function mainImgSlide(){
	$('.bxslider').bxSlider({
		auto: true,
		autoControls: true,
		stopAutoOnClick: true,
		pager: true,
		infiniteLoop: true,
		slideWidth: 600,
		speed : 500
	});
}
