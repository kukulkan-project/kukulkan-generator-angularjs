(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .factory('RightManyToOneUnidirectionalSearch', RightManyToOneUnidirectionalSearch);

    RightManyToOneUnidirectionalSearch.$inject = ['$resource'];

    function RightManyToOneUnidirectionalSearch($resource) {
        var resourceUrl =  'api/_search/rightManyToOneUnidirectional/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
