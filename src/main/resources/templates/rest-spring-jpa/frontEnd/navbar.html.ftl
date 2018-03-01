<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" ng-click="vm.toggleNavbar()">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand logo" href="#/" ng-click="vm.collapseNavbar()">
                <img class="logo-img" src="content/images/logo-app.png" alt="logo"/>
                <span data-translate="global.title">${projectName}</span> <span class="navbar-version">v{{VERSION}}</span>
            </a>
        </div>
        <div class="navbar-collapse" uib-collapse="vm.isNavbarCollapsed" ng-switch="vm.isAuthenticated()">
            <ul class="nav navbar-nav navbar-right">
                <li ui-sref-active="active">
                    <a ui-sref="home" ng-click="vm.collapseNavbar()">
                        <span class="glyphicon glyphicon-home"></span>
                        <span class="hidden-sm" data-translate="global.menu.home">Home</span>
                    </a>
                </li>
                <!-- jhipster-needle-add-element-to-menu - JHipster will add new menu items here -->
                <li ng-class="{active: vm.$state.includes('entity')}" ng-switch-when="true" uib-dropdown class="dropdown pointer">
                    <a class="dropdown-toggle" uib-dropdown-toggle href="" id="entity-menu">
                        <span>
                            <span class="glyphicon glyphicon-th-list"></span>
                            <span class="hidden-sm" data-translate="global.menu.entities.main">
                                Entities
                            </span>
                            <b class="caret"></b>
                        </span>
                    </a>
                    <ul class="dropdown-menu" uib-dropdown-menu>
							<#list dataModelGroup as dmg>
								<#list dmg.entities as entity>
							<li ui-sref-active="active" has-any-authority="ROLE_ADMIN,ROLE_LOCAL">
								<a ui-sref="${entity.camelCaseFormat}" ng-click="vm.collapseNavbar()">
									<span class="glyphicon glyphicon-book"></span>&nbsp;
									<span data-translate="global.menu.entities.${entity.camelCaseFormat}">${entity.name}</span>
								</a>
							</li>    
								</#list>    
							</#list>
                        <!-- jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here -->
                    </ul>
                </li>
                <li ng-class="{active: vm.$state.includes('account')}" uib-dropdown class="dropdown pointer">
                    <a class="dropdown-toggle" uib-dropdown-toggle href="" id="account-menu">
                        <span>
                            <span class="glyphicon glyphicon-user"></span>
                            <span class="hidden-sm" data-translate="global.menu.account.main">
                                Account
                            </span>
                            <b class="caret"></b>
                        </span>
                    </a>
                    <ul class="dropdown-menu" uib-dropdown-menu>
                        <li ui-sref-active="active" ng-switch-when="true">
                            <a ui-sref="settings" ng-click="vm.collapseNavbar()">
                                <span class="glyphicon glyphicon-wrench"></span>&nbsp;
                                <span data-translate="global.menu.account.settings">Settings</span>
                            </a>
                        </li>
                        <li ui-sref-active="active" ng-switch-when="true">
                            <a ui-sref="password" ng-click="vm.collapseNavbar()">
                                <span class="glyphicon glyphicon-lock"></span>&nbsp;
                                <span data-translate="global.menu.account.password">Password</span>
                            </a>
                        </li>
                        <li ui-sref-active="active" ng-switch-when="true">
                            <a href="" ng-click="vm.logout()" id="logout">
                                <span class="glyphicon glyphicon-log-out"></span>&nbsp;
                                <span data-translate="global.menu.account.logout">Sign out</span>
                            </a>
                        </li>
                        <li ui-sref-active="active" ng-switch-when="false">
                            <a href="" ng-click="vm.login()" id="login">
                                <span class="glyphicon glyphicon-log-in"></span>&nbsp;
                                <span data-translate="global.menu.account.login">Sign in</span>
                            </a>
                        </li>
                        <li ui-sref-active="active" ng-switch-when="false">
                            <a ui-sref="register" ng-click="vm.collapseNavbar()">
                                <span class="glyphicon glyphicon-plus-sign"></span>&nbsp;
                                <span data-translate="global.menu.account.register">Register</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li ng-class="{active: vm.$state.includes('admin')}"  ng-switch-when="true" has-authority="ROLE_ADMIN" uib-dropdown class="dropdown pointer">
                    <a class="dropdown-toggle" uib-dropdown-toggle href="" id="admin-menu">
                        <span>
                            <span class="glyphicon glyphicon-tower"></span>
                            <span class="hidden-sm" data-translate="global.menu.admin.main">Administration</span>
                            <b class="caret"></b>
                        </span>
                    </a>
                    <ul class="dropdown-menu" uib-dropdown-menu>
                        <li ui-sref-active="active">
                            <a ui-sref="user-management" ng-click="vm.collapseNavbar()">
                                <span class="glyphicon glyphicon-user"></span>&nbsp;
                                <span data-translate="global.menu.admin.userManagement">User management</span>
                            </a>
                        </li>
                        <li ui-sref-active="active">
                            <a ui-sref="jhi-metrics" ng-click="vm.collapseNavbar()">
                                <span class="glyphicon glyphicon-dashboard"></span>&nbsp;
                                <span data-translate="global.menu.admin.metrics">Metrics</span>
                            </a>
                        </li>
                        <li ui-sref-active="active">
                            <a ui-sref="jhi-health" ng-click="vm.collapseNavbar()">
                                <span class="glyphicon glyphicon-heart"></span>&nbsp;
                                <span data-translate="global.menu.admin.health">Health</span>
                            </a>
                        </li>
                        <li ui-sref-active="active">
                            <a ui-sref="jhi-configuration" ng-click="vm.collapseNavbar()">
                                <span class="glyphicon glyphicon-list-alt"></span>&nbsp;
                                <span data-translate="global.menu.admin.configuration">Configuration</span>
                            </a>
                        </li>
                        <li ui-sref-active="active">
                            <a ui-sref="audits" ng-click="vm.collapseNavbar()">
                                <span class="glyphicon glyphicon-bell"></span>&nbsp;
                                <span data-translate="global.menu.admin.audits">Audits</span>
                            </a>
                        </li>
                        <li ui-sref-active="active">
                            <a ui-sref="logs" ng-click="vm.collapseNavbar()">
                                <span class="glyphicon glyphicon-tasks"></span>&nbsp;
                                <span data-translate="global.menu.admin.logs">Logs</span>
                            </a>
                        </li>
                        <li ng-show="vm.swaggerEnabled" ui-sref-active="active">
                            <a ui-sref="docs" ng-click="vm.collapseNavbar()">
                                <span class="glyphicon glyphicon-book"></span>&nbsp;
                                <span data-translate="global.menu.admin.apidocs">API</span>
                            </a>
                        </li>
                        <!-- jhipster-needle-add-element-to-admin-menu - JHipster will add entities to the admin menu here -->
                        <li ng-hide="vm.inProduction">
                            <a href='/h2-console' target="_tab" ng-click="vm.collapseNavbar()">
                                <span class="glyphicon glyphicon-hdd"></span>&nbsp;
                                <span data-translate="global.menu.admin.database">Database</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li ui-sref-active="active" uib-dropdown class="dropdown pointer" ng-controller="JhiLanguageController as languageVm">
                    <a class="dropdown-toggle" uib-dropdown-toggle href="" ng-if="languageVm.languages.length > 1">
                        <span>
                            <span class="glyphicon glyphicon-flag"></span>
                            <span class="hidden-sm" data-translate="global.menu.language">Language</span>
                            <b class="caret"></b>
                        </span>
                    </a>
                    <ul class="dropdown-menu" uib-dropdown-menu ng-if="languageVm.languages.length > 1">
                        <li active-menu="{{language}}" ng-repeat="language in languageVm.languages">
                            <a href="" ng-click="languageVm.changeLanguage(language);vm.collapseNavbar();">{{language | findLanguageFromKey}}</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
