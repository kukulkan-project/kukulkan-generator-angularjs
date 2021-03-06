
<div>
    <h2><span data-translate="${projectName}App.${entityCamelCase}.detail.title">${entity.name}</span> {{vm.${entityCamelCase}.id}}</h2>
    <hr>
    <jhi-alert-error></jhi-alert-error>
    <dl class="dl-horizontal jh-entity-details">
        <dt><span data-translate="global.field.id">${primaryKey.name}</span></dt>
        <dd>
            <span>{{vm.${entityCamelCase}.${primaryKey.name}}}</span>
        <dd>
		<#list properties as property>
        	<#if property.name?ends_with("ContentType") == false>
	        	<#if  property.blob == true>
	        		<#if property.clob == true>
	        		<#include "/rest-spring-jpa/frontEnd/entities/read/textblob.ftl">
		    	    <#else>
		    	    <#include "/rest-spring-jpa/frontEnd/entities/read/blob.ftl">
	        		</#if>
		    	<#elseif property.time == true>
		    		<#if  property.zoneDateTime == true>
		        		<#include "/rest-spring-jpa/frontEnd/entities/read/zonedatetime.ftl">
			    	<#elseif property.localDate == true>
			    		<#include "/rest-spring-jpa/frontEnd/entities/read/localdate.ftl">
		    		<#else>
		    		    <#include "/rest-spring-jpa/frontEnd/entities/read/instant.ftl">
		    		</#if>
		        <#else> 
		        	<#include "/rest-spring-jpa/frontEnd/entities/read/text.ftl">
		    	</#if>
        	</#if>
		</#list>
		<#include "/rest-spring-jpa/frontEnd/entities/read/associations/read-association-properties.ftl">
    </dl>

    <button type="submit"
            ui-sref="{{ vm.previousState }}"
            class="btn btn-info">
        <span class="glyphicon glyphicon-arrow-left"></span>&nbsp;<span data-translate="entity.action.back"> Back</span>
    </button>

    <button type="button" ui-sref="${entityCamelCase}-detail.edit({id:vm.${entityCamelCase}.id})" class="btn btn-primary">
        <span class="glyphicon glyphicon-pencil"></span>
        <span class="hidden-sm-down" data-translate="entity.action.edit"> Edit</span>
    </button>
</div>
