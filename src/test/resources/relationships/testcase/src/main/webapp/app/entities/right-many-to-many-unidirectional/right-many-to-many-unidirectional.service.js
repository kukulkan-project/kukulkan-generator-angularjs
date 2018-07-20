(function() {
    'use strict';
    angular
        .module('testcaseApp')
        .factory('RightManyToManyUnidirectional', RightManyToManyUnidirectional);

    RightManyToManyUnidirectional.$inject = ['$resource'];

    function RightManyToManyUnidirectional ($resource) {
        var resourceUrl = 'api/rightManyToManyUnidirectional/:id';

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