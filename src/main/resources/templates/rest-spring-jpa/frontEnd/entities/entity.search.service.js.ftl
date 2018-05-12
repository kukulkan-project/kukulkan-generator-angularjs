(function() {
    'use strict';

    angular
        .module('${projectName}App')
        .factory('${entity.name}Search', ${entity.name}Search);

    ${entity.name}Search.$inject = ['$resource'];

    function ${entity.name}Search($resource) {
        var resourceUrl =  'api/_search/${entityCamelCasePlural}/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
