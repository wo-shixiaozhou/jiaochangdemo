$(function() {
    $.post({

        url: '/user/getAll',

        success: function (data) {

            for (var i = 0; i < data.length; i++) {


                var text = "<tr>\n" +

                    "                    <td>" + data[i].id + "</td>\n" +

                    "                    <td>" + data[i].username + "</td>\n" +

                    "                    <td>" + data[i].password + "</td>\n" +

                    "                    <td>" + data[i].createtime + "</td>\n" +

                    "                    <td>" + data[i].status + "</td>\n" +

                    "                    <td>\n" +

                    "                        <a href=\"user/delete?id=" + data[i].id + "\"  class=\"btn btn-danger\">删除</a>\n" +

                    "                        <a href=\"update.html?id="+data[i].id+"\" class=\"btn btn-success\">修改</a>\n" +

                    "                    </td>\n" +

                    "                </tr>"


                var obj = $(".pool");

                obj.append(text);

            }


        }

    });


    $("#sub").click(function () {
        var userName = $("#username").val();
        var passwordId1 = $("#password").val();
        var passwordId2 = $("#passwordId2").val();
        if (userName.length == 0) {
            alert("用户名不能为空");
            return;
        }
        if (passwordId1.length == 0 || passwordId2.length == 0) {
            alert("密码不能为空");
            return;
        }
        if (passwordId1 != passwordId2) {
            alert("两次密码输入不一致，请重新输入");
            return;
        }

        //封装
        var data = {
            "username": userName,
            "password": passwordId1
        }

        //实体类转为json
        var userJson = JSON.stringify(data);

        //提交给后台
        $.post({
            url: 'user/add',
            data: userJson,
            contentType:'application/json',
            success: function (data) {
                alert(data);
            }
        });

    })

    //获取url中的参数
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
    }

   $(function () {
      var id =  getUrlParam("id");
       $.post({
           url:'user/findById?id='+id,
           success:function (data) {
               $("#id").val(data.id);
               $("#username").val(data.username);
               $("#password").val(data.password);
               $("#passwordId2").val(data.password);
           }
       })
   })


    $("#sub1").click(function () {
        var id = $("#id").val();
        var userName = $("#username").val();
        var passwordId1 = $("#password").val();
        var passwordId2 = $("#passwordId2").val();
        if (userName.length == 0) {
            alert("用户名不能为空");
            return;
        }
        if (passwordId1.length == 0 || passwordId2.length == 0) {
            alert("密码不能为空");
            return;
        }
        if (passwordId1 != passwordId2) {
            alert("两次密码输入不一致，请重新输入");
            return;
        }

        //封装
        var data = {
            "id" : id,
            "username": userName,
            "password": passwordId1
        }

        //实体类转为json
        var userJson = JSON.stringify(data);

        //提交给后台
        $.post({
            url: 'user/update',
            data: userJson,
            contentType:'application/json',
            success: function (data) {
                alert(data);
            }
        });

    })

})
