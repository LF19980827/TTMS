
function select_studio(currentPage) {
    $("#select").attr("onclick","select_studio(1)");
    $("#span").html("影厅名称:");
    $("#selectName").attr("name","studio_name");
    $("#add_btn").attr("onclick","window.location = 'detailStudio.html'");
    $("#add_btn").show();
    $.get("studio/select",{currentPage:currentPage,studio_name:$("#selectName").val()},function (data) {
        //数据
        $("#table_tr").siblings().remove();
        var lis = '<th>影厅编号</th>\n' +
            '\t\t\t\t<th>影厅名称</th>\n' +
            '\t\t\t\t<th>座位行数</th>\n' +
            '\t\t\t\t<th>座位列数</th>\n' +
            '\t\t\t\t<th>影厅描述</th>\n' +
            '\t\t\t\t<th>操作</th>';
        $("#table_tr").html(lis);
        lis = "";
        for (var i = 0; i<data.list.length ;i++){
            var studio =data.list[i] ;
            var td = '<tr>' +
                '<td>'+studio.studio_id+'</td>'+
                '<td>'+studio.studio_name+'</td>'+
                '<td>'+studio.studio_row_count+'</td>'+
                '<td>'+studio.studio_col_count+'</td>'+
                '<td>'+studio.studio_introduction+'</td>'+
                '<td>删除</td>'+
                '</tr>';
            lis +=td;
        }
        $("#table").append(lis);
        //分页条
        var before = data.currentPage - 1 ;
        var after = data.currentPage + 1 ;


        var nav = '<ul class="pagination">' +
            '<li>' +
            '<a href="javascript:select_studio('+before+')" aria-label="Previous">' +
            '<span aria-hidden="true">&laquo;</span>' +
            '</a>' +
            ' </li>';

        for (var i = 1; i <= data.totalPage;i++){
            if(i == data.currentPage){
                var ul = '<li class="active"><a href="javascript:select_studio('+i+')">'+i+'</a></li>';
            }else{
                var ul = '<li><a href="javascript:select_studio('+i+')">'+i+'</a></li>';
            }
            nav +=ul;
        }
        nav += '<li>' +
            '<a href="javascript:select_studio('+after+')" aria-label="Next">' +
            '<span aria-hidden="true">&raquo;</span>' +
            '</a>' +
            '</li>' +
            '</ul>'
        $("#nav").html(nav);
    });
}

function select_employee(currentPage) {
    $("#select").attr("onclick","select_employee(1)");
    $("#span").html("员工名称:");
    $("#selectName").attr("name","emp_name");
    $("#add_btn").attr("onclick","window.location = 'detailEmployee.html'");
    $("#add_btn").show();
    $.get("employee/select",{currentPage:currentPage,emp_name:$("#selectName").val()},function (data) {
        //数据
        $("#table_tr").siblings().remove();
        var lis = '<th>员工编号</th>\n' +
            '\t\t\t\t<th>员工姓名</th>\n' +
            '\t\t\t\t<th>员工电话</th>\n' +
            '\t\t\t\t<th>员工住址</th>\n' +
            '\t\t\t\t<th>员工邮箱</th>\n' +
            '\t\t\t\t<th>员工账户</th>\n' +
            '\t\t\t\t<th>员工密码</th>';
        $("#table_tr").html(lis);
        lis = "";
        for (var i = 0; i<data.list.length ;i++){
            var emp =data.list[i] ;
            var td = '<tr>' +
                '<td>'+emp.emp_no+'</td>'+
                '<td>'+emp.emp_name+'</td>'+
                '<td>'+emp.emp_tel_num+'</td>'+
                '<td>'+emp.emp_addr+'</td>'+
                '<td>'+emp.emp_email+'</td>'+
                '<td>'+emp.emp_user+'</td>'+
                '<td>'+emp.emp_password+'</td>'+
                '</tr>';
            lis +=td;
        }
        $("#table").append(lis);
        //分页条
        var before = data.currentPage - 1 ;
        var after = data.currentPage + 1 ;
        var nav = '<ul class="pagination">' +
            '<li>' +
            '<a href="javascript:select_employee('+before+')" aria-label="Previous">' +
            '<span aria-hidden="true">&laquo;</span>' +
            '</a>' +
            ' </li>';

        for (var i = 1; i <= data.totalPage;i++){
            if(i == data.currentPage){
                var ul = '<li class="active"><a href="javascript:select_employee('+i+')">'+i+'</a></li>';
            }else {
                var ul = '<li><a href="javascript:select_employee('+i+')">'+i+'</a></li>';
            }
            nav +=ul;
        }
        nav += '<li>' +
            '<a href="javascript:select_employee('+after+')" aria-label="Next">' +
            '<span aria-hidden="true">&raquo;</span>' +
            '</a>' +
            '</li>' +
            '</ul>'
        $("#nav").html(nav);
    });
}

function select_play(currentPage) {
    $("#select").attr("onclick","select_play(1)");
    $("#span").html("影片名称:");
    $("#selectName").attr("name","play_name");
    $("#add_btn").attr("onclick","window.location = 'detailPlay.html'");
    $("#add_btn").show();
    $.get("play/select",{currentPage:currentPage,play_name:$("#selectName").val()},function (data) {
        //数据
        $("#table_tr").siblings().remove();
        var lis = '<th>type_id</th>\n' +
            '\t\t\t\t<th>type_id</th>\n' +
            '\t\t\t\t<th>name</th>\n' +
            '\t\t\t\t<th>introduction</th>\n' +
            '\t\t\t\t<th>length</th>\n' +
            '\t\t\t\t<th>ticket_price</th>\n' +
            '\t\t\t\t<th>status</th>';
        $("#table_tr").html(lis);
        lis = "";
        for (var i = 0; i<data.list.length ;i++){
            var  play= data.list[i] ;
            var td = '<tr>' +
                '<td>'+play.play_type_id+'</td>'+
                '<td>'+play.play_lang_id+'</td>'+
                '<td>'+play.play_name+'</td>'+
                '<td>'+play.play_introduction+'</td>'+
                '<td>'+play.play_length+'</td>'+
                '<td>'+play.play_ticket_price+'</td>'+
                '<td>'+play.play_status+'</td>'+
                '</tr>';
            lis +=td;
        }
        $("#table").append(lis);
        //分页条
        var before = data.currentPage - 1 ;
        var after = data.currentPage + 1 ;
        var nav = '<ul class="pagination">' +
            '<li>' +
            '<a href="javascript:select_play('+before+')" aria-label="Previous">' +
            '<span aria-hidden="true">&laquo;</span>' +
            '</a>' +
            ' </li>';

        for (var i = 1; i <= data.totalPage;i++){
            if (i == data.currentPage){
                var ul = '<li class="active"><a href="javascript:select_play('+i+')">'+i+'</a></li>';
            } else {
                var ul = '<li><a href="javascript:select_play('+i+')">'+i+'</a></li>';
            }
            nav +=ul;
        }
        nav += '<li>' +
            '<a href="javascript:select_play('+after+')" aria-label="Next">' +
            '<span aria-hidden="true">&raquo;</span>' +
            '</a>' +
            '</li>' +
            '</ul>'
        $("#nav").html(nav);
    });
}

function select_schedule(currentPage) {
    $("#select").attr("onclick","select_schedule(1)");
    $("#span").html("计划编号:");
    $("#selectName").attr("name","sched_id");
    $("#add_btn").attr("onclick","window.location = 'detailSchedule.html'");
    $("#add_btn").show();
    $.get("schedule/select",{currentPage:currentPage,sched_id:$("#selectName").val()},function (data) {
        //数据
        $("#table_tr").siblings().remove();
        var lis = '<th>计划编号</th>\n' +
            '\t\t\t\t<th>影厅编号</th>\n' +
            '\t\t\t\t<th>影片编号</th>\n' +
            '\t\t\t\t<th>放映时间</th>\n' +
            '\t\t\t\t<th>票价</th>';
        $("#table_tr").html(lis);
        lis = "";
        for (var i = 0; i<data.list.length ;i++){
            var schedule =data.list[i] ;
            var td = '<tr>' +
                '<td>'+schedule.sched_id+'</td>'+
                '<td>'+schedule.studio_id+'</td>'+
                '<td>'+schedule.play_id+'</td>'+
                '<td>'+schedule.sched_time+'</td>'+
                '<td>'+schedule.sched_ticket_price+'</td>'+
                '</tr>';
            lis +=td;
        }
        $("#table").append(lis);
        //分页条
        var before = data.currentPage - 1 ;
        var after = data.currentPage + 1 ;
        var nav = '<ul class="pagination">' +
            '<li>' +
            '<a href="javascript:select_schedule('+before+')" aria-label="Previous">' +
            '<span aria-hidden="true">&laquo;</span>' +
            '</a>' +
            ' </li>';

        for (var i = 1; i <= data.totalPage;i++){
            if(i == data.currentPage){
                var ul = '<li class="active"><a href="javascript:select_schedule('+i+')">'+i+'</a></li>';
            }else {
                var ul = '<li><a href="javascript:select_schedule('+i+')">'+i+'</a></li>';
            }
            nav +=ul;
        }
        nav += '<li>' +
            '<a href="javascript:select_schedule('+after+')" aria-label="Next">' +
            '<span aria-hidden="true">&raquo;</span>' +
            '</a>' +
            '</li>' +
            '</ul>'
        $("#nav").html(nav);
    });
}

function select_seat(currentPage) {
    
    $("#select").attr("onclick","select_seat(1)");
    $("#span").html("影厅编号:");
    $("#selectName").attr("name","studio_id");
    $("#add_btn").hide();
    $.get("seat/select", {currentPage: currentPage,studio_id:$("#selectName").val()}, function (data) {
        //数据
        $("#table_tr").siblings().remove();
        var lis = '<th>座位编号</th>\n' +
            '\t\t\t\t<th>影厅编号</th>\n' +
            '\t\t\t\t<th>座位行号</th>\n' +
            '\t\t\t\t<th>座位列号</th>\n' +
            '\t\t\t\t<th>座位状态</th>';
        $("#table_tr").html(lis);
        lis = "";
        for (var i = 0; i < data.list.length; i++) {
            var seat = data.list[i];
            var td = '<tr>' +
                '<td>' + seat.seat_id + '</td>' +
                '<td>' + seat.studio_id + '</td>' +
                '<td>' + seat.seat_row + '</td>' +
                '<td>' + seat.seat_column + '</td>' +
                '<td>' + seat.seat_status + '</td>' +
                '</tr>';
            lis += td;
        }
        $("#table").append(lis);
        //分页条
        var before = data.currentPage - 1;
        var after = data.currentPage + 1;
        var nav = '<ul class="pagination">' +
            '<li>' +
            '<a href="javascript:select_seat(' + before + ')" aria-label="Previous">' +
            '<span aria-hidden="true">&laquo;</span>' +
            '</a>' +
            ' </li>';

        for (var i = 1; i <= data.totalPage; i++) {
            if(i == data.currentPage){
                var ul = '<li class="active"><a href="javascript:select_seat(' + i + ')">' + i + '</a></li>';
            }else {
                var ul = '<li><a href="javascript:select_seat(' + i + ')">' + i + '</a></li>';
            }
            nav += ul;
        }
        nav += '<li>' +
            '<a href="javascript:select_seat(' + after + ')" aria-label="Next">' +
            '<span aria-hidden="true">&raquo;</span>' +
            '</a>' +
            '</li>' +
            '</ul>'
        $("#nav").html(nav);
    });
}

function removeInput() {
    $("#selectName").val("");
}


function studio() {
    removeInput();
    select_studio(1);
}

function seat() {
    removeInput();
    select_seat(1);
}

function play() {
    removeInput();
    select_play(1);
}

function schedule() {
    removeInput();
    select_schedule(1);
}

function employee() {
    removeInput();
    select_employee(1);
}

// 事件监听
// document.getElementById("nav_table").addEventListener("click",function (e) {
//     var event = e || window.event;
//     var target = event.target || event.srcElement;
//     if(target.nodeName.toLocaleLowerCase() === "a"){
//         target.setAttribute("class","sign");
//         removeInput();
//     }
// });

