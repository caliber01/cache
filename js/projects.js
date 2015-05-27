$('.form').find('input, textarea').on('keyup blur focus', function (e) {
    var $this = $(this), label = $this.prev('label');
    if (e.type === 'keyup') {
        if ($this.val() === '') {
            label.removeClass('active highlight');
        } else {
            label.addClass('active highlight');
        }
    } else if (e.type === 'blur') {
        if ($this.val() === '') {
            label.removeClass('active highlight');
        } else {
            label.removeClass('highlight');
        }
    } else if (e.type === 'focus') {
        if ($this.val() === '') {
            label.removeClass('highlight');
        } else if ($this.val() !== '') {
            label.addClass('highlight');
        }
    }
});
$('.tab a').on('click', function (e) {
    e.preventDefault();
    $(this).parent().addClass('active');
    $(this).parent().siblings().removeClass('active');
    target = $(this).attr('href');
    $('.tab-content > div').not(target).hide();
    $(target).fadeIn(600);
});

function edit(){
    document.getElementById('group').contentEditable = true;
    document.getElementById('job').contentEditable = true;
    document.getElementById('work').contentEditable = true;
}

<<<<<<< HEAD
/*$('#addTeacher').click(function(event) {

    addDynamic();
    return false;
 });*/
function addDynamic() {
    var div = $('<div/>', {
        'class' : 'teachersDiv'
    }).appendTo($('#Div'));
    var div = $('<div/>', {
        'class' : 'gorizont'
    }).appendTo($('#Div'));
    var input = $('<input/>', {
        value : 'Преподаватель',
        type : 'button',
        style: 'border-style: none; width: 100%; margin: 0;padding-right: 90%;',
        'class' : 'btn btn-default buttonTeacher' }).appendTo(div);
    var but = $('<input/>', {
        type : 'button',
        style: 'border: none;',
        'class' : 'btn btn-default btn-small' }).appendTo(div);
    var e1 = $('<span/>', {
        'class': "glyphicon glyphicon-remove",
        'aria-hidden': "true"}).insertAfter(but);
}

function del(){
    this.outerHTML='';
}
=======
function addTeacher(){
    $("#mainTeacherDiv").append('<div id = "teacherDiv" style="padding:0;" class="panel-body"><div class = \'gorizont\'><input type="button" style = "border-style: none; width: 97%; margin: 0;padding-right: 90%;"class="btn btn-default buttonTeacher" value="Преподаватель"> <button id="deleteTeacher" style =\'border: none;\' type="button" class="btn btn-default btn-small" onclick="delTeacher();"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></div>');
}

function delTeacher(){
    $("#teacherDiv").remove();
}
function addProject(){
    $("#mainProjectDiv").append('<div id = "projectDiv" style="padding:0;" class="panel-body"><div class = \'gorizont\'><input type="button" style = "border-style: none;width: 90%; margin: 0;padding-right: 80%;"class="btn btn-default" value="MyProject"> <button id="deleteProject" style =\'border: none;\' type="button" class="btn btn-default btn-small" onclick="delProject();"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></div>');
}

function delProject(){
    $("#projectDiv").remove();
}
>>>>>>> web
