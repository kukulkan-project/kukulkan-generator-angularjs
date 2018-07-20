(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .factory('RightOneToOneBidirectionalSearch', RightOneToOneBidirectionalSearch);

    RightOneToOneBidirectionalSearch.$inject = ['$resource'];

    function RightOneToOneBidirectionalSearch($resource) {
        var resourceUrl =  'api/_search/rightOneToOneBidirectional/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
