(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .factory('RightOneToOneUnidirectionalSearch', RightOneToOneUnidirectionalSearch);

    RightOneToOneUnidirectionalSearch.$inject = ['$resource'];

    function RightOneToOneUnidirectionalSearch($resource) {
        var resourceUrl =  'api/_search/rightOneToOneUnidirectional/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
