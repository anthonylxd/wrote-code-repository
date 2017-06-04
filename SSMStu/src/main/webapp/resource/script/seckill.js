//存放主要交互逻辑js代码
//javascript 模块化
var seckill = {
	// 封装秒杀相关ajax的url
	URL : {

	},
	//验证手机号
	validatePhone : function(phone) {
		if(phone && phone.length == 11 && !isNaN(phone)) {
			return true;
		}else{
			return false;
		}
	},
	
	// 详情页秒杀逻辑
	detail : {
		//详情页初始化
		init : function(params) {
		//手机验证和登录，计时交互
		//在cookie中查找手机号
		var killPhone = $.cookie('killPhone');
		var startTime = params['startTime'];
		var endTime = params['endTime'];
		var seckillId = params['startTime'];
		console.log(startTime+" 777 "+endTime+" 888 "+seckillId+" 999 "+killPhone);
		if(!seckill.validatePhone(killPhone)) {
			//绑定phone
			//控制输出
			var killPhoneModal = $('#killPhoneModal');
			killPhoneModal.modal({
				show:true,//显示弹出层
				backdrop:'static',//禁止位置关闭
				keyboard:false//关闭键盘事件		
			});
			
			$('#killPhoneBtn').click(function() {
				var inputPhone = $('#killPhone').val();
				console.log(inputPhone);
				if(seckill.validatePhone(inputPhone)) {
					$('#killPhoneMessage').hide();
					//电话写入cookie
					$.cookie('killPhone',inputPhone,{expires:7,path:'/SSMStu/seckill'});
					console.log("存入Phone "+$.cookie('killPhone'));
					//刷新页面
					window.location.reload();
				}else{
					$('#killPhoneMessage').hide().html('<label class="lable label-danger">手机号错误</label>').show(500);			
				}
			});
		}
		
		}
	}

}