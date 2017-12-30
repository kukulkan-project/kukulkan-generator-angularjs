<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <title th:text="#{email.activation.title}">JHipster activation</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="shortcut icon" th:href="@{|${baseUrl}/favicon.ico|}" />
    </head>
    <body>
        <p th:text="#{email.activation.greeting(${user.login})}">
            Dear
        </p>
        <p th:text="#{email.activation.text1}">
            Your JHipster account has been created, please click on the URL below to activate it:
        </p>
        <p>
            <a th:href="@{|${baseUrl}/#/activate?key=${user.activationKey}|}"
               th:text="@{|${baseUrl}/#/activate?key=${user.activationKey}|}">Activation Link</a>
        </p>
        <p>
            <span th:text="#{email.activation.text2}">Regards, </span>
            <br/>
            <em th:text="#{email.signature}">JHipster.</em>
        </p>
    </body>
</html>
