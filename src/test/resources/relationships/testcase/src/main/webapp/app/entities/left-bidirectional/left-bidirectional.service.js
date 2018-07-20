(function() {
    'use strict';
    angular
        .module('testcaseApp')
        .factory('LeftBidirectional', LeftBidirectional);

    LeftBidirectional.$inject = ['$resource'];

    function LeftBidirectional ($resource) {
        var resourceUrl = 'api/leftBidirectional/:id';

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