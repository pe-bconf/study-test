<html>
    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta charset="UTF-8">
        <title>
            JSONP 테스트
        </title>
    </head>
    <script src="../../libs/jquery-3.6.0.min.js"></script>
    <script>
        const HOST = "http://localhost:8080"
        const URI_SESSION_CHECKER = HOST.concat("/opn/m85CheckSession");

        $(document).ready(function(){
            console.log('document ready');
            $.post(
                URI_SESSION_CHECKER,
                {code:'KM'},
                function(data, textStatus, jqXhr){
                    console.log('connection completed');
                    console.log('data');
                    console.log(data);
                    console.log('textStatus');
                    console.log(textStatus);
                    console.log('jqXhr');
                    console.log(jqXhr);
                }).done(function() {
                    console.log('done');
                }).fail(function(){
                    console.log('faile');
                }).always(function (){
                    console.log('always');
                });
        });
    </script>
    <body>
        Just test
    </body>
</html>