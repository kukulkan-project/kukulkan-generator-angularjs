(function() {
    'use strict';
    angular
        .module('testcaseApp')
        .factory('RightManyToManyBidirectional', RightManyToManyBidirectional);

    RightManyToManyBidirectional.$inject = ['$resource'];

    function RightManyToManyBidirectional ($resource) {
        var resourceUrl = 'api/rightManyToManyBidirectional/:id';

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