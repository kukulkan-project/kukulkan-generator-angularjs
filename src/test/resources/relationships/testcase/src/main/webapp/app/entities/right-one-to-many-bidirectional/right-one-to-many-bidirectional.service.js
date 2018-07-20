(function() {
    'use strict';
    angular
        .module('testcaseApp')
        .factory('RightOneToManyBidirectional', RightOneToManyBidirectional);

    RightOneToManyBidirectional.$inject = ['$resource'];

    function RightOneToManyBidirectional ($resource) {
        var resourceUrl = 'api/rightOneToManyBidirectional/:id';

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