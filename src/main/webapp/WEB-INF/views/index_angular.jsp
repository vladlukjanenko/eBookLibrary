<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="bookLibrary">
    <head>
        <title>Book Library</title>

        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <%--<link rel="stylesheet" href="/bootstrap-4.0.0-beta/dist/css/bootstrap.min.css"/>
        <script type="text/javascript" src="/static/bootstrap-4.0.0-beta/dist/js/bootstrap.min.js"></script>--%>

        <script type="text/javascript" src="/static/angular-1.6.6/angular.min.js"></script>

        <script type="text/javascript" src="/js/controllers/uploadBookController.js"></script>
        <script type="text/javascript" src="/js/app.js"></script>
    </head>
    <body>
        <div ng-controller="UploadBookCtrl as bookUploader">
            <button ng-click="bookUploader.uploadBook()">Upload</button>
        </div>
    </body>
</html>
