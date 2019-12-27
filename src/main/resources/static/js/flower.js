//评论功能
function commentmsg() {
    var content = $("#comment_content").val();
    var flowerid = $("#flower_id").val();
    if (flowerid != 0 && content != null) {
        $.post(
            "/comment", {content: content, fid: flowerid}, function (data) {
                //收到数据
                if(data=="success"){
                    window.location.reload();
                }else if(data=="fail"){
                    alert("用户未登录不能评论！");
                }
            })
    }
}


//收藏功能
function changecolor() {
    // var fcollage = document.getElementById("fcollection");
    // fcollage.className = 'colorchange glyphicon glyphicon-heart';
    var flowerid = $("#flower_id").val();
    if (flowerid != 0) {
        $.post(
            "/collection", {fid: flowerid}, function (data) {
                if(data=="success"){
                    alert("收藏成功！");
                    $("#fcollection").removeClass("color");
                    $("#fcollection").addClass("colorchange");
                }else{
                    alert("用户未登陆，收藏失败！");
                }
            })
    }
}


//删除收藏
function deletecol(e) {
    var flowerid = e.getAttribute("data-id");
    if (flowerid != 0) {
        $.post(
            "/deletecol", {fid: flowerid}, function (data) {
                if(data=="success"){
                    alert("删除成功！");
                    window.location.reload();
                }else{
                    alert("删除失败！");
                }
            })
    }
}

