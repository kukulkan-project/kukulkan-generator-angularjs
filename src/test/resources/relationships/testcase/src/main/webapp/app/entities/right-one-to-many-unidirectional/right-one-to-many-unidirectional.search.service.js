(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .factory('RightOneToManyUnidirectionalSearch', RightOneToManyUnidirectionalSearch);

    RightOneToManyUnidirectionalSearch.$inject = ['$resource'];

    function RightOneToManyUnidirectionalSearch($resource) {
        var resourceUrl =  'api/_search/rightOneToManyUnidirectional/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
