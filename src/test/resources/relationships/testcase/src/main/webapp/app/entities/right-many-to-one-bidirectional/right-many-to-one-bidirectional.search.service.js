(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .factory('RightManyToOneBidirectionalSearch', RightManyToOneBidirectionalSearch);

    RightManyToOneBidirectionalSearch.$inject = ['$resource'];

    function RightManyToOneBidirectionalSearch($resource) {
        var resourceUrl =  'api/_search/rightManyToOneBidirectional/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
