/*
*@Name: 商城
*@Author: xuzhiwen
*@Copyright:layui.com
*/

layui.define(['layer','jquery'],function(exports){
	var layer = layui.layer;
	var $ = layui.jquery; //导入jquery
	
var car = {
  init : function(){
  		var uls = document.getElementById('list-cont').getElementsByTagName('ul');//每一行
  		var checkInputs = document.getElementsByClassName('check'); // 所有勾选框
      var checkAll = document.getElementsByClassName('check-all'); //全选框
      var SelectedPieces = document.getElementsByClassName('Selected-pieces')[0];//总件数
      var piecesTotal = document.getElementsByClassName('pieces-total')[0];//总价
      var batchdeletion = document.getElementsByClassName('batch-deletion')[0]//批量删除按钮
      //计算
      function getTotal(){
          var seleted = 0,price = 0;
          for(var i = 0; i < uls.length;i++){
        			if(uls[i].getElementsByTagName('input')[0].checked){
                seleted += parseInt(uls[i].getElementsByClassName('Quantity-input')[0].value);
                price += parseFloat(uls[i].getElementsByClassName('sum')[0].innerHTML);
              }
      		}
          SelectedPieces.innerHTML = seleted;
          piecesTotal.innerHTML = '￥' + price.toFixed(2);
      }

      function fn1(){
        alert(1)
      }
      // 小计
      function getSubTotal(ul){
        var unitprice = parseFloat(ul.getElementsByClassName('th-su')[0].innerHTML);
        var count = parseInt(ul.getElementsByClassName('Quantity-input')[0].value);
        var SubTotal = parseFloat(unitprice*count)
        ul.getElementsByClassName('sum')[0].innerHTML = SubTotal.toFixed(2);
      }
      for(var i = 0;i < checkInputs.length;i++){
        checkInputs[i].onclick = function(){
        	//循环选取
          if(this.className === 'check-all check'){
            for(var j = 0;j < checkInputs.length; j++){
              checkInputs[j].checked = this.checked;
            }
            var checknum = this.checked?1:2;
            car.isAllchecked(checknum);
          }
          //控制单选
          if(this.className == 'CheckBoxShop check'){
        	  var checknum = this.checked?1:2;
        	  car.isChecked(checknum,$(this).attr("data-id"));
        	 //console.log(checknum); 
          }
          if(this.checked == false){
            for(var k = 0;k < checkAll.length;k++){
              checkAll[k].checked = false;
            }
          }
          getTotal()
        }
      }

      for(var i = 0; i < uls.length;i++){
        uls[i].onclick = function(e){
          e = e || window.event;
          var el = e.srcElement;
          var cls = el.className;
          var input = this.getElementsByClassName('Quantity-input')[0];
          var less = this.getElementsByClassName('less')[0];
          var val = parseInt(input.value);
          var that = this;
          switch(cls){
            case 'add layui-btn':
              input.value = val + 1;
              getSubTotal(this)
              break;
            case 'less layui-btn':
              if(val > 1){
                input.value = val - 1;
              }
              getSubTotal(this)
              break;
            case 'dele-btn':
            	var elid =$(el).attr("data-id");
              layer.confirm('你确定要删除吗',{
                yes:function(index,layero){
                	car.delcartid(elid);
                  layer.close(index)
                  that.parentNode.removeChild(that);
                }
              })
              break;
          }
          //更新购物车数量
         // console.log(input.value);
          car.cartNum(input.value,input.getAttribute("data-id"));
          getTotal()
        }
      }
      batchdeletion.onclick = function(){
        if(SelectedPieces.innerHTML != 0){
          layer.confirm('你确定要删除吗',{
            yes:function(index,layero){
              layer.close(index)
              for(var i = 0;i < uls.length;i++){
                var input = uls[i].getElementsByTagName('input')[0];
                if(input.checked){
                  uls[i].parentNode.removeChild(uls[i]); 
                  i--;
                }
              }
              car.delAllcart(); //批量删除
              getTotal() 
            }

          })
        }else{
          layer.msg('请选择商品')
        }
        
      }
//        checkAll[0].checked = true;
//        checkAll[0].onclick();
      getTotal();
  	  },
  	  //更新勾选
  	  isChecked:function(checked,product_id){
  		var data={
  				 act:"editchecked",
  				 user_id:localStorage.getItem("userid"),
  				 product_id:product_id,
  				 checked:checked
  				}
  				$.ajax({
  				  type:"post",
  				  url:"../../data/liuyanAction.jsp",
  				  data:data,
  				  success:function(res){
  				    res =JSON.parse(eval(res));
  				    
  				  }
  		    })
  	  }
  	  //更新数量
  	  ,cartNum:function(num,product_id){
  		var data={
 				 act:"editcartnum",
 				 user_id:localStorage.getItem("userid"),
 				 product_id:product_id,
 				 num:num
 				}
 				$.ajax({
 				  type:"post",
 				  url:"../../data/liuyanAction.jsp",
 				  data:data,
 				  success:function(res){
 				    res =JSON.parse(eval(res));
 				    //console.log(res);
 				  }
 		    });
  	  }
  	  //更新该用户的所有勾选
  	  ,isAllchecked:function(checked){
  		var data={
 				 act:"editAllchecked",
 				 user_id:localStorage.getItem("userid"),
 				 checked:checked
 				}
 				$.ajax({
 				  type:"post",
 				  url:"../../data/liuyanAction.jsp",
 				  data:data,
 				  success:function(res){
 				    res =JSON.parse(eval(res));
 				    
 				  }
 		    })
  	  }
  	  //删除一条购物车
  	  ,delcartid:function(id){
  		var data={
				 act:"delcartid",
				 id:id
				}
				$.ajax({
				  type:"post",
				  url:"../../data/liuyanAction.jsp",
				  data:data,
				  success:function(res){
				    res =JSON.parse(eval(res));
				    if(res.name == 'ok'){
				    	
				    	layer.msg("删除成功");
				    	setTimeout(function(){
				    		location.reload();
				    	},1500);
				    }
				  }
		    })
  	  }
  	  //删除用户批量勾选的商品
  	  ,delAllcart:function(){
    		var data={
   				 act:"delAllcart",
   				 user_id:localStorage.getItem("userid")
   				}
   				$.ajax({
   				  type:"post",
   				  url:"../../data/liuyanAction.jsp",
   				  data:data,
   				  success:function(res){
   				    res =JSON.parse(eval(res));
   				    if(res.name == 'ok'){
   				    	layer.msg("批量删除成功");
   				     $("#list-cont").html('<p style="padding:30px 10px 30px 28px;">购物车空空如也！快去购物啦</p>');  
   				    }
   				  }
   		    })
     	  }

  }


  exports('car',car)
}); 