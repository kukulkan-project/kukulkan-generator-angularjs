(function() {
    'use strict';

    angular
        .module('${projectName}App')
        .factory('${entity.name}Handsontable', ${entity.name}Handsontable);

    ${entity.name}Handsontable.$inject = ['$resource'];

    function ${entity.name}Handsontable($resource) {
        var resourceUrl =  'api/${entityCamelCasePlural}/handsontable';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET' }
        });
    }
})();
