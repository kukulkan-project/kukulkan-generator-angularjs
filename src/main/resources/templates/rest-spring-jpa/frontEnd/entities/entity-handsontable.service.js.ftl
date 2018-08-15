(function() {
    'use strict';

    angular
        .module('${projectName}App')
        .factory('${entity.name}Sheet', ${entity.name}Sheet);

    ${entity.name}Sheet.$inject = ['$resource'];

    function ${entity.name}Sheet($resource) {
        var resourceUrl =  'api/${entityCamelCasePlural}/sheet';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET' }
        });
    }
})();
