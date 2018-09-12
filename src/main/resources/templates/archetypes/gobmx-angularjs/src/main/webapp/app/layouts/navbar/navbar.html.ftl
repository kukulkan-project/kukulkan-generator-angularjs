<nav class="navbar navbar-inverse sub-navbar navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#subenlaces">
                <span class="sr-only">Interruptor de Navegación</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" ui-sref="home">
                <span data-translate="global.title">Compranet</span>
                <span class="navbar-version">v{{VERSION}}</span>
            </a>
        </div>
        <div class="collapse navbar-collapse" id="subenlaces" ng-switch="vm.isAuthenticated()">
            <ul class="nav navbar-nav navbar-right">
                <li><a ui-sref="home" data-translate="global.menu.home">Home</a></li>
                <li ng-class="{active: vm.$state.includes('entity')}" ng-switch-when="true" class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false" data-translate="global.menu.entities.main">Entities
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <!-- jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here -->
                    </ul>
                </li>
                <li ng-class="{active: vm.$state.includes('admin')}" ng-switch-when="true" has-authority="ROLE_ADMIN" class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false" data-translate="global.menu.admin.main">Administration
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li ui-sref-active="active">
                            <a ui-sref="user-management">
                                <span data-translate="global.menu.admin.userManagement">User management
                                </span>
                            </a>
                        </li>
                        <li ui-sref-active="active">
                            <a ui-sref="jhi-metrics">
                                <span data-translate="global.menu.admin.metrics">Metrics
                                </span>
                            </a>
                        </li>
                        <li ui-sref-active="active">
                            <a ui-sref="jhi-health">
                                <span data-translate="global.menu.admin.health">Health
                                </span>
                            </a>
                        </li>
                        <li ui-sref-active="active">
                            <a ui-sref="jhi-configuration">
                                <span data-translate="global.menu.admin.configuration">Configuration
                                </span>
                            </a>
                        </li>
                        <li ui-sref-active="active">
                            <a ui-sref="audits">
                                <span data-translate="global.menu.admin.audits">Audits
                                </span>
                            </a>
                        </li>
                        <li ui-sref-active="active">
                            <a ui-sref="logs">
                                <span data-translate="global.menu.admin.logs">Logs
                                </span>
                            </a>
                        </li>
                        <li ui-sref-active="active">
                            <a ui-sref="docs">
                                <span data-translate="global.menu.admin.apidocs">API
                                </span>
                            </a>
                        </li>
                        <!-- jhipster-needle-add-element-to-admin-menu - JHipster will add entities to the admin menu here-->
                        <li ui-sref-active="active">
                            <a href='/h2-console' target="_tab">
                                <span data-translate="global.menu.admin.database">Database
                                </span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li ui-sref-active="active" class="dropdown" ng-controller="JhiLanguageController as languageVm">
                    <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false" data-translate="global.menu.language">
                        <span data-translate="global.menu.language">Language</span>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu" ng-if="languageVm.languages.length > 1">
                        <li active-menu="{{language}}" ng-repeat="language in languageVm.languages">
                            <a href="" ng-click="languageVm.changeLanguage(language);">{{language | findLanguageFromKey}}</a>
                        </li>
                    </ul>
                </li>
                <li class="submenuLine hidden-xs" >&nbsp;</li>
                <li class="dropdown" ng-switch="vm.isAuthenticated()">
                    <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false" data-translate="global.menu.account.main">Account
                        <span class="icon-user" aria-hidden="true"></span>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <div ng-switch-when="true">
                            <li class="dropdown-header">
                                {{vm.account.login}}
                            </li>
                            <li class="divider"></li>
                        </div>
                        <li ui-sref-active="active" ng-switch-when="true">
                            <a ui-sref="settings">
                                <span data-translate="global.menu.account.settings">Settings
                                </span>
                            </a>
                        </li>
                        <li ui-sref-active="active" ng-switch-when="true">
                            <a ui-sref="password">
                                <span data-translate="global.menu.account.password">Password
                                </span>
                            </a>
                        </li>
                        <li ui-sref-active="active" ng-switch-when="true">
                            <a href="" ng-click="vm.logout()" id="logout">
                                <span data-translate="global.menu.account.logout">Sign out
                                </span>
                            </a>
                        </li>
                        <li ui-sref-active="active" ng-switch-when="false">
                            <a href="" ng-click="vm.login()" id="login">
                                <span data-translate="global.menu.account.login">Sign in
                                </span>
                            </a>
                        </li>
                        <li ui-sref-active="active" ng-switch-when="false">
                            <a ui-sref="register">
                                <span data-translate="global.menu.account.register">Register
                                </span>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
