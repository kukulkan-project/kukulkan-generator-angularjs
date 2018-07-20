(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .factory('LeftUnidirectionalSearch', LeftUnidirectionalSearch);

    LeftUnidirectionalSearch.$inject = ['$resource'];

    function LeftUnidirectionalSearch($resource) {
        var resourceUrl =  'api/_search/leftUnidirectional/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
