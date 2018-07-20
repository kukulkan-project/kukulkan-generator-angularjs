(function() {
    'use strict';
    angular
        .module('testcaseApp')
        .factory('RightManyToOneBidirectional', RightManyToOneBidirectional);

    RightManyToOneBidirectional.$inject = ['$resource'];

    function RightManyToOneBidirectional ($resource) {
        var resourceUrl = 'api/rightManyToOneBidirectional/:id';

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