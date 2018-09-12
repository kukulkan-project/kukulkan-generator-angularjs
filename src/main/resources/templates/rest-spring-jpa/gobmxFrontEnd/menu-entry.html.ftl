                <li ui-sref-active="active" has-any-authority="ROLE_ADMIN,ROLE_USER">
                    <a ui-sref="${camelCaseFormat}" ng-click="vm.collapseNavbar()">
                        <span class="fa fa-archive"></span>&nbsp;
                        <span data-translate="global.menu.entities.${camelCaseFormat}">${name}</span>
                    </a>
                </li>