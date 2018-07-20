(function() {
    'use strict';
    angular
        .module('testcaseApp')
        .factory('RightManyToOneUnidirectional', RightManyToOneUnidirectional);

    RightManyToOneUnidirectional.$inject = ['$resource'];

    function RightManyToOneUnidirectional ($resource) {
        var resourceUrl = 'api/rightManyToOneUnidirectional/:id';

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