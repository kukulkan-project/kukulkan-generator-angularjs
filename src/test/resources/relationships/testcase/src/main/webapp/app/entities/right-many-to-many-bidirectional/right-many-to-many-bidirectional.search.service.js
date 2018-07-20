(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .factory('RightManyToManyBidirectionalSearch', RightManyToManyBidirectionalSearch);

    RightManyToManyBidirectionalSearch.$inject = ['$resource'];

    function RightManyToManyBidirectionalSearch($resource) {
        var resourceUrl =  'api/_search/rightManyToManyBidirectional/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
