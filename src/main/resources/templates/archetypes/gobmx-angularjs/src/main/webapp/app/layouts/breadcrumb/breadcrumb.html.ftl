<ol class="breadcrumKukul breadcrumb">
    <li>
        <a ui-sref="home"><i class="icon icon-home"></i></a>
    </li>
    <li ng-if="steps[0].parent !== 'app'" ng-repeat="step in steps">
        <a ui-sref="{{step.ncyBreadcrumbStateRef}}" data-translate="{{step.data.pageTitle}}">{{step.data.pageTitle}}</a>
    </li>
</ol>
