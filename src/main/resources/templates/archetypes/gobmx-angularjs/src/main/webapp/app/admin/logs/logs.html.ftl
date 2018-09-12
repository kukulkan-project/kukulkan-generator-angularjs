<div class="container-fluid">
    <div class="table-responsive">
        <h2 data-translate="logs.title">Logs</h2>

        <p data-translate="logs.nbloggers" translate-values="{total: '{{ vm.loggers.length }}'}">There are {{
            vm.loggers.length}} loggers.</p>

        <span data-translate="logs.filter">Filter</span> <input type="text" ng-model="filter" class="form-control">

        <table class="table table-condensed table-striped table-bordered">
            <thead>
            <tr title="click to order">
                <th ng-click="predicate = 'name'; reverse=!reverse"><span data-translate="logs.table.name">Name</span>
                </th>
                <th ng-click="predicate = 'level'; reverse=!reverse"><span
                    data-translate="logs.table.level">Level</span></th>
            </tr>
            </thead>

            <tr ng-repeat="logger in vm.loggers | filter:filter | orderBy:predicate:reverse">
                <td>
                    <small>{{logger.name | characters:140}}</small>
                </td>
                <td>
                    <button ng-click="vm.changeLevel(logger.name, 'TRACE')"
                            ng-class="(logger.level=='TRACE') ? 'btn-default' : 'btn-default'"
                            class="btn btn-default btn-xs">TRACE
                    </button>
                    <button ng-click="vm.changeLevel(logger.name, 'DEBUG')"
                            ng-class="(logger.level=='DEBUG') ? 'btn-warning' : 'btn-default'"
                            class="btn btn-default btn-xs">DEBUG
                    </button>
                    <button ng-click="vm.changeLevel(logger.name, 'INFO')"
                            ng-class="(logger.level=='INFO') ? 'btn-info' : 'btn-default'"
                            class="btn btn-default btn-xs">INFO
                    </button>
                    <button ng-click="vm.changeLevel(logger.name, 'WARN')"
                            ng-class="(logger.level=='WARN') ? 'btn-success' : 'btn-default'"
                            class="btn btn-default btn-xs">WARN
                    </button>
                    <button ng-click="vm.changeLevel(logger.name, 'ERROR')"
                            ng-class="(logger.level=='ERROR') ? 'btn-primary' : 'btn-default'"
                            class="btn btn-default btn-xs">ERROR
                    </button>
                </td>
            </tr>
        </table>
    </div>
</div>
