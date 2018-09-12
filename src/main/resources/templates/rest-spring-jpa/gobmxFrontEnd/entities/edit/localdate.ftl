        <div class="form-group">
            <div class="form-group datepicker-group">
        		<label class="control-label" for="${property.name}" data-translate="${projectName}App.${entityCamelCase}.${property.name}">${property.name}:</label>
        		<input id="${property.name}" class="form-control" placeholder="aaaa-mm-dd" maxlength="10" name="start" ng-model="vm.${entity.name}.${property.name}" ng-change="vm.onChangeDate('${property.name}')" ng-click="vm.onChangeDate('${property.name}')" <#if property.constraint.nullable==false> required</#if> />
	                <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
	        </div>
			<#if property.constraint.nullable==false>
			<div ng-show="editForm.${property.name}.$invalid">
	        	<p class="help-block" ng-show="editForm.${property.name}.$error.required" data-translate="entity.validation.required">
	            	This field is required.
	            </p>
            </div>
			 </#if>
        </div>