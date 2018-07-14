<form name="deleteForm" ng-submit="vm.confirmDelete(vm.${entityCamelCase}.id)">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"
                ng-click="vm.clear()">&times;</button>
        <h4 class="modal-title" data-translate="entity.delete.title">Confirm delete operation</h4>
    </div>
    <div class="modal-body">
        <jhi-alert-error></jhi-alert-error>
        <p data-translate="${projectName}App.${entityCamelCase}.delete.question" translate-values="{id: '{{vm.${entityCamelCase}.id}}'}">Are you sure you want to delete this ${entity.name}?</p>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="vm.clear()">
            <span class="glyphicon glyphicon-ban-circle"></span>&nbsp;<span data-translate="entity.action.cancel">Cancel</span>
        </button>
        <button type="submit" ng-disabled="deleteForm.$invalid" class="btn btn-danger">
            <span class="glyphicon glyphicon-remove-circle"></span>&nbsp;<span data-translate="entity.action.delete">Delete</span>
        </button>
    </div>
</form>
