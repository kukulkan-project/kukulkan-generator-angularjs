(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .factory('RightManyToManyUnidirectionalSearch', RightManyToManyUnidirectionalSearch);

    RightManyToManyUnidirectionalSearch.$inject = ['$resource'];

    function RightManyToManyUnidirectionalSearch($resource) {
        var resourceUrl =  'api/_search/rightManyToManyUnidirectional/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
