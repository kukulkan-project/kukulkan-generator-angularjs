(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .factory('RightOneToManyBidirectionalSearch', RightOneToManyBidirectionalSearch);

    RightOneToManyBidirectionalSearch.$inject = ['$resource'];

    function RightOneToManyBidirectionalSearch($resource) {
        var resourceUrl =  'api/_search/rightOneToManyBidirectional/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
