<html>
    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta charset="UTF-8">
        <title>
            JSONP 테스트
        </title>
    </head>
    <script src="../../libs/jquery-3.6.0.min.js"></script>
<%--    <script src="http://dev.kwmembers.com/apis/mbrIntg/MbrIntgrtKmIsLogin.json?CODE=MK&callback=jsonpCallback"></script>--%>
    <script>
        let MK85_HOST = "https://devapi.market85.com:9443";
        let MK85_URI = "/opn/m85CheckSession";
        let MK85_URI_SESSION_CHECKER = MK85_HOST.concat(MK85_URI);
        let KM_HOST = "http://dev.kwmembers.com"
        let KM_URI = "/apis/mbrIntg/MbrIntgrtKmIsLogin.json";
        let KM_URI_SESSION_CHECKER = KM_HOST.concat(KM_URI);

        let LOCAL_HOST_URI = "http://localhost:17070/jsonpTest";

        $(document).ready(function(){
            console.log('document ready');
            $("#mkHostName").val(MK85_HOST);
            $("#mkUriPath").val(MK85_URI_SESSION_CHECKER);
            $("#kmHostName").val(KM_HOST);
            $("#kmUriPath").val(KM_URI_SESSION_CHECKER);
            // sendPost();
            // sendGet();
            callJsonpResponse(LOCAL_HOST_URI);
        });

        window.jsonpCallback = function (data){
            console.log(data);

        };

        function defaultGet(){
            callJsonpResponse(LOCAL_HOST_URI);
        }

        function callJsonpResponse(url){
            $.ajax({
                url:url,
                dataType:'jsonp',
                type:'GET',
                contentType: 'application/json',
                success:function(data){
                    console.log('success');
                    console.log(data);
                },
                error: function(jqXhr, textStatus, thrown){
                    console.log('jsonp connection failed');
                    console.log('jqXhr');
                    console.log(jqXhr);
                    console.log(jqXhr.status);
                    console.log(jqXhr.statusText);
                    console.log(jqXhr.responseText);
                    console.log(jqXhr.readyState);
                    console.log('textStatus');
                    console.log(textStatus);
                    console.log('thrown');
                    console.log(thrown);
                }
            });
        }

        function changeApiAddress(){
            MK85_HOST = $("#mkHostName").val();
            MK85_URI_SESSION_CHECKER = MK85_HOST.concat(MK85_URI);
            KM_HOST = $("#kmHostName").val();
            KM_URI_SESSION_CHECKER = KM_HOST.concat(KM_URI);
        }

        function clickSendGet(){
            changeApiAddress();
            sendGet();
        }

        function clickSendPost(){
            changeApiAddress();
            sendPost();
        }

        function sendGet(){
            $.getJSON(KM_URI_SESSION_CHECKER.concat('?CODE=MK&callback=?&CODE=MK'), function(data){
                console.log('get km checksession data');
                console.log(data);
            });
            $.support.cors=true;
            $.ajax({
                url:KM_URI_SESSION_CHECKER,
                data:{CODE:'MK'},
                dataType:'jsonp',
                jsonp:'request',
                type:'GET',
                contentType:'application/json',
                crossDomain: true,
                crossOrigin: true,
                // jsonpCallback: 'jsonpCallback',
                success:function(data){
                    console.log('KM connection completed');
                    console.log('data');
                    console.log(data);
                    // console.log(data.message);
                },
                error: function(jqXhr, textStatus, thrown){
                    console.log('KM connection failed');
                    console.log('jqXhr');
                    console.log(jqXhr);
                    console.log(jqXhr.status);
                    console.log(jqXhr.statusText);
                    console.log(jqXhr.responseText);
                    console.log(jqXhr.readyState);
                    console.log('textStatus');
                    console.log(textStatus);
                    console.log('thrown');
                    console.log(thrown);
                }
            });
        }

        function sendPost(){
            $.post(
                MK85_URI_SESSION_CHECKER,
                {code:'KM'},
                function(data, textStatus, jqXhr){
                    console.log('MK85 connection completed');
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
        }
    </script>
    <body>
        Just test<br/>
        MK<br/>
        <input type="button" onclick="clickSendPost()" value="변경 및 POST"/><br/>
        <input type="button" onclick="clickSendGet()" value="변경 및 GET"/><br/>
        <input type="button" onclick="defaultGet()" value="Default GET"/><br/>

        Host<input type="text" id="mkHostName"/><br/>
        URI<input type="text" id="mkUriPath"/><br/><br/>
        Host<input type="text" id="kmHostName"/><br/>
        URI<input type="text" id="kmUriPath"/><br/>
    </body>
</html>