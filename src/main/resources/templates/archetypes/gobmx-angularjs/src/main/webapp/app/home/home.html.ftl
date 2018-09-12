<div ng-cloak>
    <div class="row">
        <div class="col-md-12 widget">
            <p class="lead" data-translate="home.subtitle">This is your homepage</p>

            <span class="hipster img-responsive img-rounded"></span>

            <div class="widget-body" ng-switch="vm.isAuthenticated()">
                <div class="alert alert-success " ng-switch-when="true" data-translate="home.logged.message"
                     translate-values="{username: '{{vm.account.login}}'}">
                    You are logged in as user "{{vm.account.login}}".
                </div>

                <div class="alert alert-warning" ng-switch-when="false"
                     data-translate="global.messages.info.authenticated" translate-compile>
                    If you want to
                    <a class="alert-link" href="" ng-click="vm.login()">sign in</a>, you can try the default accounts:
                    <br/>- Administrator (login="admin" and password="admin")
                    <br/>- User (login="user" and password="user").
                </div>

                <div class="alert alert-warning" ng-switch-when="false" data-translate="global.messages.info.register"
                     translate-compile>
                    You don't have an account yet?
                    <a class="alert-link" ui-sref="register">Register a new account</a>
                </div>
            </div>
            <!--
            <p data-translate="home.question">
                If you have any question on Compranet:
            </p>

            <ul>
                <li>
                    <a href="https://github.com/${project.id}-project" target="_blank" rel="noopener" data-translate="home.link.homepage">Compranet homepage</a>
                </li>
                <li>
                    <a href="https://github.com/${project.id}-project" target="_blank" rel="noopener" data-translate="home.link.stackoverflow">Compranet on Stack Overflow</a>
                </li>
                <li>
                    <a href="https://github.com/${project.id}-project/${project.id}-engine/issues" target="_blank" rel="noopener" data-translate="home.link.bugtracker">Compranet bug tracker</a>
                </li>
                <li>
                    <a href="https://github.com/${project.id}-project" target="_blank" rel="noopener" data-translate="home.link.chat">Compranet public chat room</a>
                </li>
                <li>
                    <a href="https://github.com/${project.id}-project" target="_blank" rel="noopener" data-translate="home.link.follow">follow @java_${project.id} on Twitter</a>
                </li>
            </ul>

            <p>
                <span data-translate="home.like">If you like Compranet, don't forget to give us a star on </span>&nbsp;
                <a href="https://github.com/${project.id}-project"
                    target="_blank" rel="noopener" data-translate="home.github">GitHub</a>!
            </p>
        </div>-->
        </div>
    </div>
</div>
