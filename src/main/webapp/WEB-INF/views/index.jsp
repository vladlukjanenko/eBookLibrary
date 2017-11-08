<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Book Library</title>

        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" src="/static/bootstrap-4.0.0-beta/dist/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="/bootstrap-4.0.0-beta/dist/css/bootstrap.min.css"/>
    </head>

    <body>
        <div class="bookUpload">
            <input name="title">
            <input name="author">
            <input name="wrapper">
            <input name="isbn">
            <input name="description">

            <div class="wrapper-image-preview">

            </div>

            <button class="btn btn-primary" onclick="uploadBook()">Upload</button>
        </div>
    </body>
</html>
