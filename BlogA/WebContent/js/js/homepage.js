	function setWeiboList() {
	var weiboList = document.getElementById("weiboList");
	var weiboBoxs = weiboList.children;
	//把实践代理到每条分享li容器
	for(var i = 0; i<weiboBoxs.length;i++) {
		weiboBoxs[i].onclick = function (e) {
		//点击
		e = e || window.event;
		var el = e.srcElement;
		switch (el.className) {
			case 'praise':
				praise(el);
				break;
			case 'comment':
				comment(el);
				break;
			case 'cancelPraise':
				cancelPraise(el);
				break;
			case 'cancelComment':
				cancelComment(el);
				break;
			case 'btn':
				operate(el);
				break;
			case 'forward':
				alert('转发功能尚未实现');
				break;
	}	}	}
}

	//查看微博加载
	function loadWeibo(weibos,user,userseting) {
			var weibo = Array();
			var weiboslength = weibos.length;
		for(var i =0; i<weiboslength; i++){
			weibo[i] = document.createElement("li");
			var headImg = document.createElement("img");
			headImg.className = "headImg";
			headImg.src = "images/nice.png";//userseting.headImg
			var weiboContent = document.createElement("div");
			weiboContent.className = "weiboContent";
			var name = document.createElement("h4");
			var time = document.createElement("h5");
		 	var content = document.createElement("p");
			var img = document.createElement("img");
			var handle = document.createElement("div");
			name.innerHTML = user.username;
			time.innerHTML = weibos[i].weiboTime;
			content.innerHTML = weibos[i].weiboContent;
			img.src = "images/nice.png";
			handle.innerHTML = "<a class='forward'>转发</a>"+
					"<a class='praise'>赞<span>"+weibos[i].weiboLikeNum+"</span></a>"+
					"<a class='comment'>评论<span>"+weibos[i].weiboCommentNum+"</span></a>";
			handle.setAttribute("likeTotal",weibos[i].weiboLikeNum);
			handle.setAttribute("commentTotal",weibos[i].weiboCommentNum);
			handle.setAttribute("weiboId",weibos[i].weiboId);
			weibo[i].appendChild(headImg);
			weibo[i].appendChild(weiboContent);
			weiboContent.appendChild(name);
			weiboContent.appendChild(time);
			weiboContent.appendChild(content);
			weiboContent.appendChild(img);
			weiboContent.appendChild(handle);
			weiboList.appendChild(weibo[i]);
		}
	 }


	
	//点赞
	function praise(el) {
		var newLikeTotal = parseInt(el.parentNode.getAttribute("likeTotal"))+1;
		var weiboId = el.parentNode.getAttribute("weiboId");
		var add = 1;
		setLike(weiboId,add);
		el.innerHTML = "赞<span>" + newLikeTotal+"</span>";
		el.parentNode.setAttribute("likeTotal",newLikeTotal);
		el.className = "cancelPraise";
		el.style.color = "red";
	}

	//取消赞
	function cancelPraise(el) {
		var newLikeTotal = parseInt(el.parentNode.getAttribute("likeTotal"))-1;
		var weiboId = el.parentNode.getAttribute("weiboId");
		var add = -1;
		setLike(weiboId,add);
		el.innerHTML = "赞<span>" + newLikeTotal+"</span>";
		el.parentNode.setAttribute("likeTotal",newLikeTotal);
		el.className = "praise";
		el.style.color = "gray";		
	}

	//评论总设置
	function comment(el) {
		var textbox = document.createElement("div");
		textbox.className = "text-box";
		var weiboId = el.parentNode.getAttribute("weiboId");
		textbox.setAttribute("weiboId",weiboId);
		var commentbox = document.createElement("div");
		commentbox.className = "comment-box";
		textbox.innerHTML = '<textarea class="comment-write" autocomplete="off">评论…</textarea>'+
                	'<button class="btn">评 论</button>'+
                	'<span class="word"><span class="length">0</span>/140</span>';
        var weiboBox = el.parentNode.parentNode;
        weiboBox.appendChild(textbox);
        weiboBox.appendChild(commentbox);
        el.className = "cancelComment";
        var textArea = textbox.getElementsByClassName('comment-write')[0];
        
        var els = textArea.parentNode.children;
        var btn = els[1];
        btn.disabled = 'disabled';
        
        //评论获得焦点时
        textArea.onfocus = function () {
        	textArea.className = "comment-write comment-writed";
        	this.value = this.value == '评论…' ? '' : this.value;
        	this.onkeyup();
        }

        //评论失去焦点
        textArea.onblur = function () {
            var me = this;
            var val = me.value;
            if (val == '') {
                var timer = setTimeout(function () {
                    me.value = '评论…';
                    me.className = 'comment-write';
                }, 200);
            }
        }

        //评论按键事件
        textArea.onkeyup = function () {
            var val = this.value;
            var len = val.length;

            var els = this.parentNode.children;
            var btn = els[1];
            var word = els[2];
            if (len <=0 || len > 140) {
                btn.className = 'btn btn-off';
                btn.disabled = 'disabled';
            }
            else {
                btn.className = 'btn';
                btn.disabled = '';
            }
            word.innerHTML = len + '/140';
        }

        //已有评论显示
        setCommentList(weiboId,commentbox);

	}


	//取消隐藏评论
	function cancelComment(el) {
		el.className = "comment";
		var weiboBox = el.parentNode.parentNode;
		var textbox = weiboBox.getElementsByTagName("div")[1];
		var commentbox = weiboBox.getElementsByTagName("div")[2];
		textbox.parentNode.removeChild(textbox);
		commentbox.parentNode.removeChild(commentbox);
	}

	//留言评论
	function operate(el) {
		var textArea = el.parentNode.getElementsByTagName("textarea")[0];
		var commentContent = textArea.value;
		var weiboId = el.parentNode.getAttribute("weiboId");
		var commentbox = el.parentNode.parentNode.getElementsByClassName("comment-box")[0];
		var newcommentTotal = parseInt(el.parentNode.parentNode.getElementsByTagName("div")[0].getAttribute("commenttotal"))+1;
		el.parentNode.parentNode.getElementsByTagName("div")[0].setAttribute("commenttotal",newcommentTotal);
		var commentNum = el.parentNode.parentNode.getElementsByTagName("div")[0].getElementsByTagName("a")[2].getElementsByTagName("span")[0];
		commentNum.innerHTML = newcommentTotal;
$.ajax({
type:"POST",
url:"http://localhost:8082/BlogA/commenting",
dataType:"text",
data:{
	"weiboId":weiboId,
	"commentContent":commentContent
},
success:function(data){
    textArea.value = '评论…';
    textArea.className = 'comment-write';

    commentbox.innerHTML = "";
    //已有评论显示
    setCommentList(weiboId,commentbox);
},
error:function(){
alert("发生错误");
}
});
		// alert("提交");
	}

	//加载下一页
	var page = 0;
	var loadMore = document.getElementById("loadMore");
	loadMore.onclick = function() {
		page++;
		//alert(page);
$.ajax({
type:"POST",
url:"http://localhost:8082/BlogA/homepage",
dataType:"json",
data:{"page":page},
success:function(data){
	if(data.weibos == ""){
		loadMore.disabled="disabled";
		loadMore.innerHTML = "没有更多";
		return false;
	}
	loadWeibo(data.weibos,data.user,data.userseting);
	setWeiboList();
},
error:function(){
alert("加载下一页发生错误");
}
});
	}

	//加载微博已有评论
	function setCommentList(weiboId,commentbox) {
$.ajax({
type:"POST",
url:"http://localhost:8082/BlogA/commentSelect",
dataType:"json",
async:false,
data:{"weiboId":weiboId},
success:function(data){
	console.log("请求加载回复一次");
for(var i = 0;i<data.length;i++) {
	console.log("评论"+i+" "+data[i].commentContent);
	var commentTemp= '<p class="comment-text"><span class="user">'+data[i].info+'：</span>'+data[i].commentContent+'</p>'+
	'<p class="comment-time">'+data[i].commentTime+'</p>';
	var commentContent = document.createElement("div");
	commentContent.className = "comment-content";
	commentContent.innerHTML = commentContent.innerHTML + commentTemp
	commentbox.appendChild(commentContent);
	setComment2List(data[i].commentId,commentContent);
}
},
error:function(){
alert("加载评论发生错误");
}
});
	}

	//加载评论的评论
	function setComment2List(commentId,commentContent) {
$.ajax({
type:"POST",
url:"http://localhost:8082/BlogA/comment2Select",
dataType:"json",
async:false,
data:{"commentId":commentId},
success:function(data2){
	console.log("评论ID"+commentId);
	console.log("评论数量"+data2.length);
for(var j=0;j<data2.length;j++) {
	console.log("回复"+j+" "+data2[j].comment2Content);
	var comment2Temp= '<p class="comment-text"><span class="user">'+data2[j].info+'：</span>'+data2[j].comment2Content+'</p>'+
	'<p class="comment-time">'+data2[j].comment2Time+'</p>';
	var comment2Content = document.createElement("div");
	comment2Content.className = "comment-content";
	comment2Content.innerHTML = commentContent.innerHTML + comment2Temp
	commentContent.appendChild(comment2Content);
}
},
error:function(){
alert("加载评论的评论发生错误");
}
});
	}


	//点赞操作数据上传
	function setLike(weiboId,add) {
$.ajax({
type:"POST",
url:"http://localhost:8082/BlogA/likeAdd",
dataType:"json",
data:{"weiboId":weiboId,"add":add},
success:function(data){
console.log("like success");
},
error:function(){
alert("点赞发生错误,请稍后重试");
}
});		
	}

	//关注与取消关注操作
	function setFollow(userId,followinfo,follow) {
$.ajax({
type:"POST",
url:"http://localhost:8082/BlogA/relationFollow",
dataType:"json",
data:{"userId":userId,"followinfo":followinfo},
success:function(data){
if(followinfo == "0") {
			follow.innerHTML = "取消关注";
			follow.className = "follow";
		}else{
			follow.innerHTML = "关注";
			follow.className = "";			
		}
},
error:function(){
alert("关注操作发生错误,请稍后重试");
}
});		
	}