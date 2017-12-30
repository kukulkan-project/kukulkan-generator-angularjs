<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <title th:text="#{email.reset.title}">JHipster password reset</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="shortcut icon" th:href="@{|${baseUrl}/favicon.ico|}" />
    </head>
    <body>
        <p th:text="#{email.reset.greeting(${user.login})}">
            Dear
        </p>
        <p th:text="#{email.reset.text1}">
            For your JHipster account a password reset was requested, please click on the URL below to reset it:
        </p>
        <p>
            <a th:href="@{|${baseUrl}/#/reset/finish?key=${user.resetKey}|}"
               th:text="@{|${baseUrl}/#/reset/finish?key=${user.resetKey}|}">Reset Link</a>
        </p>
        <p>
            <span th:text="#{email.reset.text2}">Regards, </span>
            <br/>
            <em th:text="#{email.signature}">JHipster.</em>
        </p>
    </body>
</html>
