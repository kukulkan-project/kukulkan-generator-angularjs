<form name="editForm" role="form" novalidate ng-submit="vm.save()" show-validation>

    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"
                ng-click="vm.clear()">&times;</button>
        <h4 class="modal-title" id="my${entity.name}Label" data-translate="${projectName}App.${entityCamelCase}.home.createOrEditLabel">Create or edit a ${entity.name}</h4>
    </div>
    <div class="modal-body">
        <jhi-alert-error></jhi-alert-error>
        <div class="form-group" ng-show="vm.${entityCamelCase}.${primaryKey.name}">
            <label for="id" data-translate="global.field.id">${primaryKey.name}</label>
            <input type="text" class="form-control" id="id" name="${primaryKey.name}"
                    ng-model="vm.${entityCamelCase}.${primaryKey.name}" readonly />
        </div>
        <#list properties as property>
        	<#if property.name?ends_with("ContentType") == false>
	        	<#if  property.blob == true>
		    	    <#if  property.clob == true>
						<#include "/rest-spring-jpa/frontEnd/entities/edit/textblob.ftl">
			    	<#else>
		    	        <#include "/rest-spring-jpa/frontEnd/entities/edit/blob.ftl">
		    		</#if>
		    	<#elseif property.time == true>
		    		<#if  property.zoneDateTime == true>
		        		<#include "/rest-spring-jpa/frontEnd/entities/edit/zonedatetime.ftl">
			    	<#elseif property.localDate == true>
			    		<#include "/rest-spring-jpa/frontEnd/entities/edit/localdate.ftl">
			    	<#else>
			    		<#include "/rest-spring-jpa/frontEnd/entities/edit/instant.ftl">
		    		</#if>
				<#elseif property.boolean == true>
					<#include "/rest-spring-jpa/frontEnd/entities/edit/boolean.ftl">
				<#elseif property.literal == true>
			    		<#include "/rest-spring-jpa/frontEnd/entities/edit/text.ftl">
			    <#elseif property.number == true>
					<#include "/rest-spring-jpa/frontEnd/entities/edit/number.ftl">
		        <#else>
		        	<#include "/rest-spring-jpa/frontEnd/entities/edit/text.ftl">
		    	</#if>
        	</#if>
		</#list>
        <#include "/rest-spring-jpa/frontEnd/entities/edit/associations/edit-properties.ftl">
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="vm.clear()">
            <span class="glyphicon glyphicon-ban-circle"></span>&nbsp;<span data-translate="entity.action.cancel">Cancel</span>
        </button>
        <button type="submit" ng-disabled="editForm.$invalid || vm.isSaving" class="btn btn-primary">
            <span class="glyphicon glyphicon-save"></span>&nbsp;<span data-translate="entity.action.save">Save</span>
        </button>
    </div>
</form>
