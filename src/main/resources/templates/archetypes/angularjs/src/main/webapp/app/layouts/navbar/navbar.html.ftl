<div id="sidebar-wrapper" role="navigation">
    <ul class="sidebar" ng-switch="vm.isAuthenticated()">
        <li class="sidebar-main">
            <a ng-click="vm.toggleNavbar()">
                <span class="menu-icon glyphicon glyphicon-transfer"></span>
            </a>
        </li>
        <li class="sidebar-main">
            <a ng-click="vm.toggleNavbar()">
                <div class="logo-home">
                    <img src="content/images/logo-b.svg" srcset="content/images/isotipo.svg 480w">
                </div>
            </a>
        </li>

        <li class="sidebar-list" ui-sref-active="active">
            <a ui-sref="home" ng-click="vm.collapseNavbar()">
                <span class="menu-icon glyphicon glyphicon-home"></span>
                <span data-translate="global.menu.home">Home</span>
            </a>
        </li>
        <li ng-class="{active: vm.$state.includes('entity')}" ng-switch-when="true" uib-dropdown class="sidebar-list item dropdown pointer">
            <a class="dropdown-toggle" uib-dropdown-toggle href="" id="entity-menu">
                <span>
                    <span ng-click="vm.toggleNavbar()" class="menu-icon glyphicon glyphicon-th-list"></span>
                    <span data-translate="global.menu.entities.main">
                        Entities
                    </span>
                    <b class="caret"></b>
                </span>
            </a>

            <ul class="dropdown-menu" uib-dropdown-menu>
                <!-- jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here -->
            </ul>
        </li>
        <li ng-class="{active: vm.$state.includes('admin')}" ng-switch-when="true" has-authority="ROLE_ADMIN" uib-dropdown class="sidebar-list item dropdown pointer">
            <a class="dropdown-toggle" uib-dropdown-toggle href="" id="admin-menu">
                <span>
                    <span ng-click="vm.toggleNavbar()" class="menu-icon glyphicon glyphicon-tower"></span>
                    <span data-translate="global.menu.admin.main">Administration</span>
                    <b class="caret"></b>
                </span>
            </a>
            <ul class="dropdown-menu">
                <li ui-sref-active="active">
                    <a ui-sref="user-management" ng-click="vm.collapseNavbar()">
                        <span class="fa fa-users"></span>&nbsp;
                        <span data-translate="global.menu.admin.userManagement">User management</span>
                    </a>
                </li>
                <li ui-sref-active="active">
                    <a ui-sref="jhi-metrics" ng-click="vm.collapseNavbar()">
                        <span class="fa fa-chart-area"></span>&nbsp;
                        <span data-translate="global.menu.admin.metrics">Metrics</span>
                    </a>
                </li>
                <li ui-sref-active="active">
                    <a ui-sref="jhi-health" ng-click="vm.collapseNavbar()">
                        <span class="fa fa-heartbeat"></span>&nbsp;
                        <span data-translate="global.menu.admin.health">Health</span>
                    </a>
                </li>
                <li ui-sref-active="active">
                    <a ui-sref="jhi-configuration" ng-click="vm.collapseNavbar()">
                        <span class="fa fa-cog"></span>&nbsp;
                        <span data-translate="global.menu.admin.configuration">Configuration</span>
                    </a>
                </li>
                <li ui-sref-active="active">
                    <a ui-sref="audits" ng-click="vm.collapseNavbar()">
                        <span class="fa fa-edit"></span>&nbsp;
                        <span data-translate="global.menu.admin.audits">Audits</span>
                    </a>
                </li>
                <li ui-sref-active="active">
                    <a ui-sref="logs" ng-click="vm.collapseNavbar()">
                        <span class="fa fa-server"></span>&nbsp;
                        <span data-translate="global.menu.admin.logs">Logs</span>
                    </a>
                </li>
                <li ng-show="vm.swaggerEnabled" ui-sref-active="active">
                    <a ui-sref="docs" ng-click="vm.collapseNavbar()">
                        <span class="fa fa-book"></span>&nbsp;
                        <span data-translate="global.menu.admin.apidocs">API</span>
                    </a>
                </li>
                <!-- jhipster-needle-add-element-to-admin-menu - JHipster will add entities to the admin menu here-->
                <li ng-hide="vm.inProduction">
                    <a href='/h2-console' target="_tab" ng-click="vm.collapseNavbar()">
                        <span class="fa fa-database"></span>&nbsp;
                        <span data-translate="global.menu.admin.database">Database</span>
                    </a>
                </li>
            </ul>
            <li ui-sref-active="active" uib-dropdown class="sidebar-list item dropdown pointer" ng-controller="JhiLanguageController as languageVm">
                <a class="dropdown-toggle" uib-dropdown-toggle href="" ng-if="languageVm.languages.length > 1">
                    <span>
                        <span ng-click="vm.toggleNavbar()" class="menu-icon glyphicon glyphicon-flag"></span>
                        <span data-translate="global.menu.language">Language</span>
                        <b class="caret"></b>
                    </span>
                </a>

                <ul class="dropdown-menu" ng-if="languageVm.languages.length > 1">
                    <li active-menu="{{language}}" ng-repeat="language in languageVm.languages">
                        <a href="" ng-click="languageVm.changeLanguage(language);vm.collapseNavbar();">{{language | findLanguageFromKey}}</a>
                    </li>
                </ul>

            </li>
        </li>
    </ul>
    <div class="sidebar-footer">
        <div class="col-xs-12">
            <a href="https://github.com/kukulkan-project" target="_blank">
                Kukulkan 2018 </a>
        </div>
    </div>
</div>