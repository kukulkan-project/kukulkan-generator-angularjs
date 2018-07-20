(function () {
    'use strict';

    angular
        .module('testcaseApp')
        .directive('modalDialog', function () {
            return {
                restrict: 'AC',
                link: function ($scope, element) {
                    var draggableStr = "draggableModal";
                    var header = angular.element('.modal-header', element);

                    header.on('mousedown', function (mouseDownEvent) {
                        var modalDialog = element;
                        var offset = header.offset();

                        modalDialog.addClass(draggableStr).parents().on('mousemove', function (mouseMoveEvent) {
                            angular.element("." + draggableStr, modalDialog.parents())
                                .offset({
                                    top: mouseMoveEvent.pageY - (mouseDownEvent.pageY - offset.top),
                                    left: mouseMoveEvent.pageX - (mouseDownEvent.pageX - offset.left)
                                });
                        }).on('mouseup', function () {
                            modalDialog.removeClass(draggableStr);
                        });
                    });
                }
            }
        });
})();