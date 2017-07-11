/**
 * User: harry.zhang
 * Date: 6-6-17
 * Time: 中午12:08
 * 小型婚礼
 */
$(function(){

    /* 场景七 */
    var $sevenBox = $(".seven-box"),
    	$sevenDiv = $(".seven-content div"),
        $clickMe = $(".clickMe"),
        /* 送上祝福 */
        $mask = $(".mask"),
        $popBox = $(".pop-box"),
        $write = $("#write"),
        $name = $("#name"),
        $uSure = $("#uSure"),
        $sevenContent = $(".seven-content");

    scene7();
    function scene7(){
        $sevenBox.fadeIn(1000);
        $sevenDiv.each(function(){
            //defineSevenDiv($(this));
        })

        function defineSevenDiv($own){
            var _obj = defineRandom();
            $own.css({"transform":"rotate("+_obj.rotate+"deg)"}); /* 设置随机旋转值 */
            $own.animate({left: _obj.left+"px",top: _obj.top+"px"}); /* 随机排布 */
        }

        /* 定义随机left，top和旋转值 */
        function defineRandom(){
            var randomLeft = Math.floor(680*(Math.random())) + 30, /* 图片left值 */
                randomTop =  Math.floor(400*Math.random()) + 30, /* 图片top值 */
                randomRotate = 20 - Math.floor(40*Math.random()); /* 图片旋转角度 */
            return {
                left: randomLeft,
                top: randomTop,
                rotate:randomRotate
            }
        }

        /* 拖动祝福卡片 */
        draggableNote();
        /* 拖动图片 */
        function draggableNote(){
            $(".seven-content div").draggable({
                containment: $sevenContent,
                zIndex: 2700,
                start: function(){
                    $(this).css({"transform":"rotate(0deg)","cursor": "crosshair"}); /* 开始拖动图片旋转为0，鼠标样式改变 */
                },
                stop: function(){
                    var _obj = defineRandom();
                    $(this).css({"transform":"rotate("+_obj.rotate+"deg)","cursor": "pointer"}); /* 停止拖动，旋转为随机的 */
                    var id = $(this).attr('id');
                    var classes = $(this).attr('class');
                    var style =$(this).attr('style');
                    //var text =$(this).text();
                    var $own = $(this);
                    sendGreet($own, id,classes,style,null,null);
                }
            })
        }

        /* 点我送祝福 */
        $clickMe.click(function(){
            $write.val("送上您的祝福吧~");
            $mask.fadeIn();
            $popBox.animate({top: "50%"});
        })

        /* 获取焦点时 */
        $write.focus(function(){
            var _val = $(this).val();
            if(_val == "送上您的祝福吧~"){
                $(this).val("");
            }
        })
        /* 丢失焦点时 */
        $write.blur(function(){
            var _val = $(this).val();
            if(_val.length == 0){
                $(this).val("送上您的祝福吧~");
            }
        })
        
         /* 获取焦点时 */
        $name.focus(function(){
            var _val = $(this).val();
            if(_val == "留下您的名字吧~"){
                $(this).val("");
            }
        })
        /* 丢失焦点时 */
        $name.blur(function(){
            var _val = $(this).val();
            if(_val.length == 0){
                $(this).val("留下您的名字吧~");
            }
        })

        /* 点击确定 */
        $uSure.click(function(){
            var _writeVal = $write.val();
            var _name = $name.val();
            var _randomNum = Math.ceil(Math.random()*6);
            if(_writeVal != "送上您的祝福吧~" && _name!="留下您的名字吧~"){
                var _div = '<div class="note-'+_randomNum+'">'+_name+':</p>'+_writeVal+'</div>';
                $sevenContent.append(_div); /* 如果输入祝福语，将此标签添加的尾部 */
                var $own = $sevenContent.find("div:last")
                //defineSevenDiv($own);
                
                var _obj = defineRandom();
                $own.css({"transform":"rotate("+_obj.rotate+"deg)"}); /* 设置随机旋转值 */
                $own.animate({left: _obj.left+"px",top: _obj.top+"px"}); /* 随机排布 */
                
                var classes = $own.attr('class');
                var style = "transform:rotate("+_obj.rotate+"deg);"+" left:"+_obj.left+"px;"+" top:"+ _obj.top+"px;";
                
                $popBox.animate({top: "-300px"},function(){
                    $mask.fadeOut();
                    draggableNote(); /* 可拖动卡片，给新添加的标签赋予拖动功能 */
                });
                sendGreet($own,null,classes,style,_writeVal,_name);
            }else{
                alert("赶紧留下名字和输入祝福语！祝福他们吧！");
            }
        })
        
        
        function sendGreet($own,id,classes,style,text,name){
        	var url = "update.do?id="+id+"&classes="+classes+"&style="+style;//更新数据不传内容进去
        	if(id == null){
        		url = "save.do?classes="+classes+"&style="+style+"&text="+text+"&name="+name;
        	}
        	$.ajax({
                url: url,
                type:"post",
                dataType:"json",
                success:function(msg){
                    if(msg.code == 0) {
                        //location.reload();
                    	$own.attr("id",msg.data.id);
                    }
                },error:function(){
                    //zrkj.alert("网络故障,删除失败!");
                }
           });
        	
        }
    }
    
})
