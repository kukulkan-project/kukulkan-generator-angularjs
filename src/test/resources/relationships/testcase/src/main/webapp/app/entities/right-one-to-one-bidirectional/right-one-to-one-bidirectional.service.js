(function() {
    'use strict';
    angular
        .module('testcaseApp')
        .factory('RightOneToOneBidirectional', RightOneToOneBidirectional);

    RightOneToOneBidirectional.$inject = ['$resource'];

    function RightOneToOneBidirectional ($resource) {
        var resourceUrl = 'api/rightOneToOneBidirectional/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();