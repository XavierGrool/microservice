$(document).ready(function(){
    $("#test").click(function(){
        var formData = new FormData($('#test_form')[0]);
        formData.append("user_id", 1);
        console.log(formData.get("user_id"));
        console.log(formData.get("content"));
        $.ajax({
            url: 'http://127.0.0.1:9002/add',
            type: 'POST',
            data: formData,
            dataType: 'json',
            processData: false,
            contentType : false,
            success: function(data, textStatus){
                window.location.replace("all");
                window.location.reload()
                console.log("success!")
                console.log(data)
                console.log(textStatus)
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log("error!")
                console.log(XMLHttpRequest)
                console.log(textStatus)
                console.log(errorThrown)
            }
        })
    });

    $("#submit_test").click(function(){
        var formData = new FormData($('#test_form')[0]);
        formData.append("user_id", 1);
        console.log(formData.get("user_id"));
        console.log(formData.get("content"));
        $.ajax({
            url: 'http://127.0.0.1:9002/add',
            type: 'POST',
            data: formData,
            dataType: 'json',
            processData: false,
            contentType : false,
            success: function(data, textStatus){
                console.log("success!")
                console.log(data)
                console.log(textStatus)
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log("error!")
                console.log(XMLHttpRequest)
                console.log(textStatus)
                console.log(errorThrown)
            }
        })
    });
});