        <dt><span data-translate="${projectName}App.${entityCamelCase}.${property.name}">${property.name?cap_first}</span></dt>
        <dd>  
			<span>{{vm.${entityCamelCase}.${property.name} | date:'mediumDate'}}</span>
		</dd>