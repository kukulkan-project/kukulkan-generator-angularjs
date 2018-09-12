<div class="container-fluid">
    <h2 data-translate="health.title">Health Checks</h2>
    <hr class="black"/>
    <p>
    <div class="col-md-12">
        <div class="pull-right">
            <button type="button" class="btn btn-primary" ng-click="vm.refresh()"><span
                class="glyphicon glyphicon-refresh"></span>&nbsp;<span
                data-translate="health.refresh.button">Refresh</span>
            </button>
        </div>
    </div>
    </p>
    <table id="healthCheck" class="table table-striped">
        <thead>
        <tr>
            <th class="col-md-7" data-translate="health.table.service">Service Name</th>
            <th class="col-md-2 text-center" data-translate="health.table.status">Status</th>
            <th class="col-md-2 text-center" data-translate="health.details.details">Details</th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="health in vm.healthData">
            <td>{{'health.indicator.' + vm.baseName(health.name) | translate}} {{vm.subSystemName(health.name)}}</td>
            <td class="text-center">
                        <span class="label" ng-class="vm.getLabelClass(health.status)">
                            {{'health.status.' + health.status | translate}}
                        </span>
            </td>
            <td class="text-center">
                <a class="hand" ng-click="vm.showHealth(health)" ng-show="health.details || health.error">
                    <i class="glyphicon glyphicon-eye-open"></i>
                </a>
            </td>
        </tr>
        </tbody>
    </table>
</div>
