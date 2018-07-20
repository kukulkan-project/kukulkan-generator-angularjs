(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .factory('LeftBidirectionalSearch', LeftBidirectionalSearch);

    LeftBidirectionalSearch.$inject = ['$resource'];

    function LeftBidirectionalSearch($resource) {
        var resourceUrl =  'api/_search/leftBidirectional/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
